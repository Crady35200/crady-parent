package com.crady.framework.annotation;

import java.lang.annotation.*;

/**
 * author:Crady
 * date:2019/08/10 13:47
 * desc:
 **/
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CradyRequestParam {
    String value() default "";
}
