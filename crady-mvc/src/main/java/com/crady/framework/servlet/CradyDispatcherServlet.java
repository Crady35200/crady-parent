package com.crady.framework.servlet;

import com.crady.framework.annotation.CradyController;
import com.crady.framework.annotation.CradyRequestMapping;
import com.crady.framework.annotation.CradyRequestParam;
import com.crady.framework.context.CradyApplicationContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Pattern;

/**
 * author:Crady
 * date:2019/08/10 12:40
 * desc:  手写SpringMVC框架，实现功能：
 * 1、自定义CradyAutowire、CradyController、CradyRequestMapping、CradyRequestParam、CradyService注解。
 * 2、IOC容器(a、配置文件加载、b、类注册、c、类初始化、d、依赖注入)。
 * 3、实现了简化版的SpringMVC功能。请求url支持正则表达式。
 **/
@Slf4j
public class CradyDispatcherServlet extends HttpServlet {

    private static final String LOCATION = "contextConfigLocation";
    private static final String REQ_SUFFIX = ".json";

    private List<CradyHandler> handlerMappings = new ArrayList<>();

    private List<CradyHandlerAdapter> handlerAdapters = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.doDispatch(req, resp);
        } catch (Exception e) {
            resp.getWriter().write("500 Exception,Msg :" + Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        log.info("***************************CradyDispatherServlet init...****************************");

        CradyApplicationContext context = new CradyApplicationContext(config.getInitParameter(LOCATION));

//        请求解析
//        initMultipartResolver(context);
//        语言国际化
//        initLocaleResolver(context);
//        主题解析层
//        initThemeResolver(context);
//        解析url与method的关连关系
        initHandlerMappings(context);
        log.info("************解析url与method的关连关系成功******{}",handlerMappings);
//        适配器匹配过程
        initHandlerAdapters(context);
//        异常解析
//        initHandlerExceptionResolvers(context);
//        视图转发(根据视图名字匹配到一个模版)
//        initRequestToViewNameTranslator(context);
//        解析模版中的内容(拿到容器传过来的数据,生成HTML代码)
//        initViewResolvers(context);
//        initFlashMapManager(context);
    }

    private void initHandlerAdapters(CradyApplicationContext context) {
        if(handlerMappings == null || handlerMappings.size() < 1)
            return;
        for (CradyHandler handler : handlerMappings){
            Method method = handler.getMethod();
            Map<String,Integer> params = new HashMap<>();
            Class<?>[] types = method.getParameterTypes();
            for (int i = 0; i < types.length; i++) {
                Class<?> cls = types[i];
                if(HttpServletRequest.class.isAssignableFrom(cls) || HttpServletResponse.class.isAssignableFrom(cls)){
                    params.put(cls.getSimpleName(),i);
                    continue;
                }
            }
            //自定义注解参数
            Annotation[][] annotations = method.getParameterAnnotations();
            for(int i=0;i< annotations.length;i++){
                for (Annotation a : annotations[i]){
                    if(a instanceof CradyRequestParam){
                        String p = ((CradyRequestParam) a).value();
//                            params.add(p);
                        params.put(p,i);
                    }
                }
            }

            handlerAdapters.add(new CradyHandlerAdapter(handler,params));
        }
    }


    private void initHandlerMappings(CradyApplicationContext context) {
        Map<String,Object> beans = context.getAll();
        for (Map.Entry<String,Object> entry : beans.entrySet()){
            Class<?> cls = entry.getValue().getClass();
            if(!cls.isAnnotationPresent(CradyController.class)){
                continue;
            }
            String baseUrl = "/";
            if(cls.isAnnotationPresent(CradyRequestMapping.class)){
                CradyRequestMapping cradyRequestMapping = cls.getAnnotation(CradyRequestMapping.class);
                baseUrl += cradyRequestMapping.value();
            }
            Method[] methods = cls.getDeclaredMethods();
            for(Method method : methods){
                String url = baseUrl + "//";
                if(method.isAnnotationPresent(CradyRequestMapping.class)){
                    CradyRequestMapping annotation = method.getAnnotation(CradyRequestMapping.class);
                    url += annotation.value();
                }
                if(url == null || "".equals(url)){
                    throw new RuntimeException("映射错误:" + cls.getName() + "中的方法" + method.getName() + "没有映射关系");
                }else{//
                    CradyHandler cradyHandler = new CradyHandler(entry.getValue(),method, Pattern.compile(url.replaceAll("/+","/")));
                    handlerMappings.add(cradyHandler);
                }
            }
        }
    }


    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {

        CradyHandler mappedHandler = getHandler(request);
        if (mappedHandler == null){
            response.getWriter().write("can't find object,Msg :" + request.getRequestURI());
        }
        CradyHandlerAdapter ha = getHandlerAdapter(mappedHandler);
        if(ha == null){
            response.getWriter().write("can't find handlerAdapter,Msg:" + request.getRequestURI());
        }

        CradyModelAndView mv = ha.handle(request, response, mappedHandler);

    }
    protected CradyHandler getHandler(HttpServletRequest request) throws Exception {
        if(this.handlerMappings == null)
            return null;
        String url = request.getRequestURI();
        String contextPath = request.getContextPath();
        url = url.replace(contextPath,"").replaceAll(REQ_SUFFIX,"").replaceAll("/+","/");
        for (CradyHandler handler : handlerMappings){
            if(handler.getPattern().matcher(url).matches()){
                return handler;
            }
        }
        return null;
    }

    protected CradyHandlerAdapter getHandlerAdapter(Object handler) throws ServletException {
        for (CradyHandlerAdapter handlerAdapter : handlerAdapters){
            if(handlerAdapter.getHandler() == handler){
                return handlerAdapter;
            }
        }
        return null;
    }

/*    protected void notFoundExcetion(HttpServletResponse response,Exception e){
        try {
            response.getWriter().write("500 Exception,Msg :" + Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }*/
}
