package com.crady.proxydesign.staticProxy;

import com.crady.proxydesign.IPerson;
import lombok.extern.slf4j.Slf4j;

/**
 * author:Crady
 * date:2019/1/15 13:46
 * desc:静态代理
 * 1.可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 2.缺点:
 * 因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,
 * 一旦接口增加方法,目标对象与代理对象都要维护.
 * 如何解决静态代理中的缺点呢?答案是可以使用动态代理方式
 **/
@Slf4j
public class StaticProxyFactory implements IPerson {

    private IPerson target;

    public StaticProxyFactory(IPerson target) {
        this.target = target;
    }

    @Override
    public void say(String words) {
        log.info("static invoke start ...");
        this.target.say(words);
        log.info("static invoke end ...");
    }
}
