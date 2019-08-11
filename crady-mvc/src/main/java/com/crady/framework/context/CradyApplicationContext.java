package com.crady.framework.context;

import com.crady.framework.annotation.CradyAutowire;
import com.crady.framework.annotation.CradyController;
import com.crady.framework.annotation.CradyService;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author:Crady
 * date:2019/08/10 13:51
 * desc:
 **/
@Slf4j
public class CradyApplicationContext {

    private Map<String,Object> instances = new ConcurrentHashMap<String,Object>();

    private List<String> beanNames = new ArrayList<>();

    private String basePackage;

    public CradyApplicationContext(String location) {
        //加载配置文件
        basePackage = loadConfig(location);
        //注册
        doRegister(basePackage);
        log.info("***********注册完成 beanNames:{}",beanNames);
        //初始化
        doCreateBean();
        log.info("***********初始化完成 {}:" + instances);
        //依赖注入
        populate();
        log.info("***********依赖注入完成");
//        UserController userController = (UserController) this.getBean("userController");
//        userController.register(null,null);
        log.info("***********IOC初始化完成");
    }

    private void populate() {
        if(instances != null && instances.size() > 0){
            for (Map.Entry<String,Object> entry: instances.entrySet()){
                Object bean = entry.getValue();
                Field [] fields = bean.getClass().getDeclaredFields();
                for (Field field : fields){
                    if(field.isAnnotationPresent(CradyAutowire.class)){
                        CradyAutowire cradyAutowire = field.getAnnotation(CradyAutowire.class);
                        //如果注入时设置了ID则按照ID注入
                        String id = cradyAutowire.value();
                        Object object = null;
                        //否则按照类型注入，如果类型有多个则报错
                        if(id == null || "".equals(id)){
                            object = getAutowareBean(field.getType());
//                            id = firstCharToLower(field.getType().getSimpleName());
                        }else{
                            object = instances.get(id);
                        }
                        if(object == null){
                            throw new RuntimeException("依赖注入失败:" + bean.getClass().getName() + "中的属性:" + field.getName() + "注入失败，找不到" + field.getType().getName());
                        }
                        field.setAccessible(true);
                        try {
                            field.set(bean,object);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }

    private Object getAutowareBean(Class<?> type) {
        //先按照默认名字(接口名字首字母小写查找，如果查不到在按照类型查找)
        Object object = instances.get(firstCharToLower(type.getSimpleName()));
        if(object != null){
            System.out.println("******************按照默认名字" + type.getSimpleName() + "查找成功");
            return object;
        }
        //根据默认接口名字没有找到则按照类型查找，如果该类型有多个则报错
        int count = 0;
        for (Map.Entry<String,Object> entry: instances.entrySet()){
            Object o = entry.getValue();
            if(type.isAssignableFrom(o.getClass())){
                count ++;
                object = o;
            }
        }
        if(count > 1){
            throw new RuntimeException("按类型注入失败，该类型有多个实现类：" + type.getName());
        }else {
            return object;
        }
    }

    private void doCreateBean() {
        if(beanNames != null && beanNames.size() > 0){
            for(String beanName : beanNames){
                try {
                    Class<?> cls = Class.forName(beanName);
                    if(cls.isAnnotationPresent(CradyController.class)){
                        instances.put(firstCharToLower(cls.getSimpleName()),cls.newInstance());
                    }else if(cls.isAnnotationPresent(CradyService.class)){
                        CradyService cradyService = cls.getAnnotation(CradyService.class);
                        String id = cradyService.value();
                        if(id != null && !"".equals(id)){
                            instances.put(id,cls.newInstance());
                        }else{
                            id = firstCharToLower(cls.getSimpleName());
                            Class<?>[] interfaces = cls.getInterfaces();
                            if(interfaces != null && interfaces.length == 1){
                                String s = firstCharToLower(interfaces[0].getSimpleName());
                                if(instances.get(s) == null){
                                    id = s;
                                }
                            }
                            instances.put(id,cls.newInstance());
                        }
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doRegister(String basePackage) {
        if(basePackage == null || "".equals(basePackage)){
            return;
        }
        URL url = this.getClass().getClassLoader().getResource("/");
        File file = new File(url.getFile() + "/" + basePackage.replaceAll("\\.","\\\\"));
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files){
                doRegister(basePackage + "." + f.getName().replaceAll("\\.class",""));
            }
        }else{
            beanNames.add(basePackage);
        }
    }

    private String loadConfig(String location) {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(location);
        Properties properties = new Properties();
        try {
            properties.load(in);
            return (String) properties.get("basePackage");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 类首字母小写作为bean的ID
     * @param beanName
     * @return
     */
    private String firstCharToLower(String beanName) {
        char [] chars = beanName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    public Object getBean(String name){
        return instances.get(name);
    }

    public Map<String,Object> getAll(){
        return  instances;
    }
}
