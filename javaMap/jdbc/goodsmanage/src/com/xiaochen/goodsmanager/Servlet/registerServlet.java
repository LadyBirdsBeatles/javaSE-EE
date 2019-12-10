package com.xiaochen.goodsmanager.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.xml.transform.Source;
import java.io.IOException;

public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //重定向由响应触发
        System.out.println("你来了request");
     //response.sendRedirect("/admin");
        Object name = request.getAttribute("name");
        Object pwd = request.getAttribute("pwd");
        System.out.println(name+"+"+pwd);
        System.out.println("你来了Context");
        HttpSession session = request.getSession();
        System.out.println(session);
        Object name1 = this.getServletContext().getAttribute("name");
        Object pwd1 = this.getServletContext().getAttribute("pwd");
        System.out.println(name1+"+"+pwd1);
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
