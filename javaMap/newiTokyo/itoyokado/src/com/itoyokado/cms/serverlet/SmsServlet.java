package com.itoyokado.cms.serverlet;

import com.itoyokado.cms.Sms.RandomNum;
import com.itoyokado.cms.Sms.Sms01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SmsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userphone = request.getParameter("userphone");
        System.out.println(userphone);
        RandomNum randomNum = new RandomNum();
        String random = randomNum.getRandom();
        System.out.println(userphone+","+random);
        Sms01.Sendmsm(userphone,random);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");


    }
}
