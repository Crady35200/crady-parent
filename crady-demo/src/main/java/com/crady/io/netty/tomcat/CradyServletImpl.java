package com.crady.io.netty.tomcat;

/**
 * @author :Crady
 * date :2020/04/25 20:42
 * desc :
 **/
public class CradyServletImpl implements CradyServlet{

    @Override
    public void doGet(CradyRequest request, CradyResponse response) {
        response.write("welcome:" + request.getParameter("name"));
    }

    @Override
    public void doPost(CradyRequest request, CradyResponse response) {
        doGet(request,response);
    }
}
