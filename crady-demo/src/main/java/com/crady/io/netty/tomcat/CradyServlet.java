package com.crady.io.netty.tomcat;

/**
 * @author :Crady
 * date :2020/04/25 20:40
 * desc :
 **/
public interface CradyServlet {

    void doGet(CradyRequest request,CradyResponse response);

    void doPost(CradyRequest request,CradyResponse response);

}
