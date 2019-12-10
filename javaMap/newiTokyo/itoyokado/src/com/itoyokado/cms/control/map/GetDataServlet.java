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

@WebServlet(name = "GetDataServlet",urlPatterns = {"/getData"})
public class GetDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        mapService mapService = new mapServiceImpl();
        String num=request.getParameter("page");
        int page=Integer.parseInt(num);
        int pageNum=(page-1)*10;
        List<B_Map> data=new ArrayList<>();
        //获取分组后的数据
        try {
            data=mapService.bList(pageNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String json= JSONArray.fromObject(data).toString();
        PrintWriter writer = response.getWriter();
        writer.print(json);
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
