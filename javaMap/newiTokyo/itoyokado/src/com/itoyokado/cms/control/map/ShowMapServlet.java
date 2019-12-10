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

@WebServlet(name = "ShowMapServlet",urlPatterns = {"/show"})
public class ShowMapServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        mapService mapService = new mapServiceImpl();
        String mName=request.getParameter("mName");
        System.out.println(mName);
        PrintWriter writer = response.getWriter();
        List<B_Map> list=new ArrayList<>();
        try {
            list=mapService.selectCoordinate(mName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String json= JSONArray.fromObject(list).toString();
        writer.print(json);
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
