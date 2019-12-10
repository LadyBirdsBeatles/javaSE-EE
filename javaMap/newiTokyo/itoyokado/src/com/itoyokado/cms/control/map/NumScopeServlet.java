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

@WebServlet(name = "NumScopeServlet",urlPatterns = {"/num"})
public class NumScopeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        mapService mapService = new mapServiceImpl();
        List<B_Map> mapName=new ArrayList<>();
        PrintWriter writer=response.getWriter();
        try {
            //把分组得到的范围名字回传给前端
            mapName=mapService.group();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        String MapName= JSONArray.fromObject(mapName).toString();
        writer.print(MapName);
        writer.close();
        System.out.println(mapName);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
