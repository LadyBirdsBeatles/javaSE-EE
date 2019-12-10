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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MapServlet", urlPatterns = {"/map"})
public class MapServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        //获取范围名字
        HttpSession session = request.getSession();
        String getName = (String) session.getAttribute("mName");
        // String getName = request.getParameter("MapName");
        mapService mapService = new mapServiceImpl();
        List<B_Map> coordinate = new ArrayList<>();
        PrintWriter writer = response.getWriter();
        try {
            //根据范围名字获取坐标
            coordinate = mapService.selectCoordinate(getName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i=0;i<coordinate.size();i++){
            System.out.println(coordinate.get(i));
        }
        String jsonString = JSONArray.fromObject(coordinate).toString();
        writer.print(jsonString);
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
