package com.itoyokado.cms.control.map;

import com.itoyokado.cms.entity.B_Map;
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
import java.util.List;

@WebServlet(name = "PageMapServlet",urlPatterns = {"/pageMap"})
public class PageMapServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        mapService mapService = new mapServiceImpl();
        List<B_Map> pageList;
        //每页记录数
        double pages=0;
        //总页数
        int pageTotal=0;
        try {
            pageList=mapService.groupData();
            //获取数据库中的数据数量
            pages=pageList.size();
            //计算总页数,每页显示10条记录
            pageTotal= (int) Math.ceil(pages/10);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //传给前端每页显示的数量以及总页数
        PrintWriter writer = response.getWriter();
        writer.print("{\"pages\":\""+(int)pages+"\",\"pageTotal\":\""+pageTotal+"\"}");
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
