package com.crady.framework.servlet;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * author:Crady
 * date:2019/08/10 14:22
 * desc:
 **/
@Data
@AllArgsConstructor
public class CradyHandler {

    private Object object;

    private Method method;

    private Pattern pattern;
}
