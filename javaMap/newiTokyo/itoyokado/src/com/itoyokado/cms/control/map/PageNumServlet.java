package com.itoyokado.cms.control.map;

import com.itoyokado.cms.entity.B_Map;
import com.itoyokado.cms.service.impl.mapServiceImpl;
import com.itoyokado.cms.service.mapService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PageNumServlet",urlPatterns = {"/pageNum"})
public class PageNumServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        //获取前端页码
        String page=request.getParameter("page");
        //转为int
        int pageNum=Integer.parseInt(page) ;
        mapService mapService = new mapServiceImpl();
        //分页计算
        int pageNumber=(pageNum-1)*10;
        List<B_Map> pageList=new ArrayList<>();
        try {
            //获取每页数据
            pageList=mapService.bList(pageNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //传给前端每页的数据
        String json= JSONArray.fromObject(pageList).toString();
        PrintWriter writer = response.getWriter();
        writer.print(json);
        writer.close();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
