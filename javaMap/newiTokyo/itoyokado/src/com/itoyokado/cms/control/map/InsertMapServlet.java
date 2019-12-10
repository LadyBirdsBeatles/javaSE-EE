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

@WebServlet(name = "InsertMapServlet",urlPatterns = {"/insert"})
public class InsertMapServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String MapName=request.getParameter("MapName");
        String MapColor=request.getParameter("MapColor");
        mapService mapService = new mapServiceImpl();
        String[] coordinate = request.getParameterValues("coordinate");
        String stat=null;
        int lines=0;
        try {
            for (int i = 0; i <coordinate.length ; i++) {
                B_Map bMap=new B_Map();
                bMap.setMapName(MapName);
                bMap.setMapColor(MapColor);
                bMap.setCoordinate(coordinate[i]);
                lines= mapService.insertCoord(bMap);
                if (lines>0){
                    stat="SUCCESS";
                    System.out.println("数据添加成功!");
                }else{
                    stat="FAIL";
                    System.out.println("数据添加失败!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter writer = response.getWriter();
        writer.print("{\"stat\":\""+stat+"\"}");
        writer.close();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
