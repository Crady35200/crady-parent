package com.crady.designpattern.facadeDesign;

import org.junit.Test;

/**
 * @author :Crady
 * date :2019/7/18 11:37
 * desc :门面模式就是把一个复杂的过程封装到一个门面类中，使得外部只能通过门面类访问封装的功能，
 * 使高层使用更加简单。主要要两个角色：具体子系统群(可以有多个类),门面类
 * 经典应用场景：Sl4j并不是日志系统的具体实现，而是一个java日志标准。
 * Tomcat中获取HttpServletRequest都是获取的 RequestFacade
 * 注意：门面类中不要有业务逻辑
 * 优点：1、松散偶尔，门面模式松散了客户端与具体功能类的耦合关系，让功能系统模块更易扩展和维护。
 * 2、简易使用。门面模式让子系统更加易用，客户端不再需要了解子系统内部的实现，也不需要跟众多子
 * 系统内部的模块进行交互，只需要跟门面类交互就可以了。
 * 3、更好的划分访问层次。通过合理使用Facade，可以帮助我们更好地划分访问的层次。有些方法是对系
 * 统外的，有些方法是系统内部使用的。把需要暴露给外部的功能集中到门面中，这样既方便客户端使用，
 * 也很好地隐藏了内部的细节。
 * 缺点：没有严格遵循开闭原则
 **/
public class FacadeTest {

    @Test
    public void facadeTest(){
        Facade facade = new Facade();
        facade.doSomethingA();
        facade.doSomethingB();
        facade.doSomethingC();
    }
}