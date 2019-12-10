package com.itoyokado.cms.control.map;

import com.itoyokado.cms.service.impl.mapServiceImpl;
import com.itoyokado.cms.service.mapService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "DeleteMapServlet",urlPatterns = {"/deleteMap"})
public class DeleteMapServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        //获取范围名字
        String mName= request.getParameter("mName");
        mapService mapService = new mapServiceImpl();
        String flag=null;
        //根据名字进行删除
        try {
            int lines=mapService.deleteMap(mName);
            if (lines>0){
                flag="SUCCESS";
            }else{
                flag="FAIL";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter writer = response.getWriter();
        writer.print("{\"flag\":\""+flag+"\"}");
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
