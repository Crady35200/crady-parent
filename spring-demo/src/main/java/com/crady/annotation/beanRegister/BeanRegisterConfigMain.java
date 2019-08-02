package com.crady.annotation.beanRegister;

import com.crady.annotation.beanRegister.bean.*;
import org.springframework.context.annotation.*;

/**
 * author:Crady
 * date:2019/08/02 22:45
 * desc:
 把bean注册到spring容器中有5中方式：
 * 1、@ComponentScan 扫描，最方便，最常用的方式(bean ID默认为类名首字母小写)。
 * 2、@Bean一般用户加载第三方jar包中的类到spring容器(Bean ID默认为方法名，也可以通过@Bean("xxx")指定)。
 * 3、@Import(也有三种方式)
 *    a、通过@Import({Pig.class, Tiger.class})加载到容器(Bean ID默认为全类路径)。
 *    b、通过@Import({MyImportSelector.class})并自定义类实现接口ImportSelector Bean ID默认路全路径)加载到容器
 *          public class MyImportSelector implements ImportSelector {
 *           @Override
 *           public String[] selectImports(AnnotationMetadata importingClassMetadata) {
 *               return new String[]{"com.crady.annotation.beanRegister.bean.Bird"};
 *           }
 *         }
 *   c、通过@Import({MyImportBeanDefinitionRegistrar.class})并自定义接口实现ImportBeanDefinitionRegistrar加载到容器(Bean ID自定义)
 *          public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
 *              @Override
 *              public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
 *                  RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Monkery.class);
 *                  registry.registerBeanDefinition("monkey",rootBeanDefinition);
 *              }
 *          }
 * 4、通过实现FactoryBean注册到容器。
 *         @Component("duck")
 *         public class DuckFactoryBean implements FactoryBean<Duck> {
 *             @Override
 *             public Duck getObject() throws Exception {
 *                 return new Duck();
 *             }
 *             @Override
 *             public Class<?> getObjectType() {
 *                 return Duck.class;
 *             }
 *         }
 * 5、使用@Conditional(WindowsCondition.class)自定义接口实现WindowsCondition根据条件决定是否需要把该Bean加载到容器
 *         public class WindowsCondition implements Condition {
 *             @Override
 *             public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
 *                 String property = context.getEnvironment().getProperty("os.name");
 *                 if("Windows 10".contains(property)){
 *                     return true;
 *                 }
 *                 return false;
 *             }
 *         }
 **/
@Configuration
@ComponentScan("com.crady.annotation.beanRegister")
@Import({Pig.class, Tiger.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class BeanRegisterConfigMain {

    @Bean("fish")
    @Lazy
    public Fish fish(){
        System.out.println("***把Fish添加到容器***");
        return new Fish();
    }

    @Bean
    @Conditional(WindowsCondition.class)
    public Windows windows(){
        return new Windows();
    }
    @Bean
    @Conditional(LinuxCondition.class)
    public Linux linux(){
        return new Linux();
    }
}
