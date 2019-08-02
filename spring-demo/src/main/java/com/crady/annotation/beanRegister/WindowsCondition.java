package com.crady.annotation.beanRegister;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * author:Crady
 * date:2019/08/02 23:31
 * desc:
 **/
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String property = context.getEnvironment().getProperty("os.name");
        if("Windows 10".contains(property)){
            return true;
        }
        return false;
    }
}
