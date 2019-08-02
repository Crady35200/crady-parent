package com.crady.annotation.beanRegister;

import com.crady.annotation.beanRegister.bean.Duck;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * author:Crady
 * date:2019/08/02 23:23
 * desc:
 **/
@Component("duck")
public class DuckFactoryBean implements FactoryBean<Duck> {
    @Override
    public Duck getObject() throws Exception {
        return new Duck();
    }

    @Override
    public Class<?> getObjectType() {
        return Duck.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
