package com.crady.framework.servlet;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

/**
 * author:Crady
 * date:2019/08/10 14:23
 * desc:
 **/
@Data
@AllArgsConstructor
public class CradyHandlerAdapter {

    private CradyHandler handler;
    private Map<String,Integer> params;

    CradyModelAndView handle(HttpServletRequest request, HttpServletResponse response, CradyHandler handler) throws Exception{

//        List<Object> ps = new ArrayList<>();
//        ps.add(request);
//        ps.add(response);
        Class<?>[] types = handler.getMethod().getParameterTypes();
        Object [] ps = new Object[params.size()];
        Map<String,String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String,String[]> entry : parameterMap.entrySet()){
            if (params.containsKey(entry.getKey())){
//                ps.add(entry.getValue());
                int i = params.get(entry.getKey());
                ps[i] = castStringValue(Arrays.toString(entry.getValue()).replaceAll("\\[|\\]",""),types[i]);
            }
        }
        String reqName = HttpServletRequest.class.getSimpleName();
        if(params.containsKey(reqName)){
            int i = params.get(reqName);
            ps[i] = request;
        }
        String respName = HttpServletResponse.class.getSimpleName();
        if(params.containsKey(respName)){
            int i = params.get(respName);
            ps[i] = response;
        }

        handler.getMethod().invoke(handler.getObject(),ps);
        return null;
    }

    private Object castStringValue(String value, Class<?> type) {
        if(type == String.class){
            return value;
        }else if(type == Integer.class){
            return Integer.parseInt(value);
        }else {
            return null;
        }
    }
}
