package com.crady.designpattern.proxydesign;

import com.crady.designpattern.proxydesign.dynamicProxy.CglibDynaticProxyFactory;
import com.crady.designpattern.proxydesign.dynamicProxy.JdkDynamicProxyFactory;
import com.crady.designpattern.proxydesign.staticProxy.StaticProxyFactory;
import org.junit.Test;

/**
 * @author :Crady
 * date:2019/1/15 11:32
 * desc:
 **/
public class ProxyDesignTest {

    /**
     * 1.可以做到在不修改目标对象的功能前提下,对目标功能扩展.
     * 2.缺点:
     * 因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,
     * 一旦接口增加方法,目标对象与代理对象都要维护.
     * 如何解决静态代理中的缺点呢?答案是可以使用动态代理方式
     */
    @Test
    public void testStaticProxyDesign(){
        Teacher teacher = new Teacher();
        StaticProxyFactory staticProxyFactory = new StaticProxyFactory(teacher);
        staticProxyFactory.say("Hi,nice to meet you !");
    }

    /**
     * desc:jdk实现-动态代理  仅适用于目标类需要实现指定接口
     * 代理对象不需要实现接口(可以实现或者不实现),但是目标对象一定要实现接口,否则不能用动态代理
     * 动态代理有以下特点:
     * 1.代理对象,不需要实现接口
     * 2.代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型)
     * 3.动态代理也叫做:JDK代理,接口代理
     */
    @Test
    public void testJdkDynaticProxyDesign(){
        IPerson teacher = new Teacher();
        IPerson proxyInstance = (IPerson) new JdkDynamicProxyFactory(teacher).getProxyInstance();
        System.out.println(proxyInstance.getClass());
        proxyInstance.say("Hi,nice to meet you !");
    }

    /**
     * 上面的静态代理和JDK动态代理模式都是要求目标对象是实现一个接口的目标对象,但是有时候目
     * 标对象只是一个单独的对象,并没有实现任何的接口,这个时候就可以使用以目标对象子类的方
     * 式类实现代理,这种方法就叫做:Cglib代理Cglib代理,也叫作子类代理,它是在内存中构建一个
     * 子类对象从而实现对目标对象功能的扩展.
     * JDK的动态代理有一个限制,就是使用动态代理的对象必须实现一个或多个接口,如果想代理没
     * 有实现接口的类,就可以使用Cglib实现.
     * Cglib是一个强大的高性能的代码生成包,它可以在运行期扩展java类与实现java接口.它广泛
     * 的被许多AOP的框架使用,例如Spring AOP和synaop,为他们提供方法的interception(拦截)
     * Cglib包的底层是通过使用一个小而块的字节码处理框架ASM来转换字节码并生成新的类.
     * 不鼓励直接使用ASM,因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉.
     * Cglib子类代理实现方法:
     * 1.需要引入cglib的jar文件,但是Spring的核心包中已经包括了Cglib功能,
     * 所以直接引入pring-core-3.2.5.jar即可.
     * 2.引入功能包后,就可以在内存中动态构建子类
     * 3.代理的类不能为final,否则报错
     * 4.目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方法.
     */
    @Test
    public void testCglibDynaticProxyDesign(){
        UserService userService = new UserService();
        UserService proxyFactory = (UserService) new CglibDynaticProxyFactory().getInstance(userService);
        proxyFactory.say("Hi,nice to meet you !");
    }
}