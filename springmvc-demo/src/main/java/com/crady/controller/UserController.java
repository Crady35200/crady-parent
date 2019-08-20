package com.crady.controller;

import com.crady.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * author:Crady
 * date:2019/08/07 23:26
 * desc:
 **/
@Slf4j
public class UserController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<User> users = new ArrayList<>();
        User u1 = new User();
        u1.setId(1);
        u1.setName("ming");
        u1.setAge(25);
        users.add(u1);

        User u2 = new User();
        u2.setId(2);
        u2.setName("zhou");
        u2.setAge(20);
        users.add(u2);
System.out.println("**********************=" + users);
//request.getRequestDispatcher("WEB-INF/jsp/userList.jsp").forward(request,response);
//System.out.println("***********==============***********=");
        log.info("**************getServletContext().getAttribute(\"title\")={}",getServletContext().getAttribute("title"));
        request.setAttribute("us",users);
        return new ModelAndView("userList","users",users);
    }
}
