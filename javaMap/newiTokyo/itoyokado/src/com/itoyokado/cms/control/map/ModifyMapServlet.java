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

@WebServlet(name = "ModifyMapServlet",urlPatterns = {"/modifyMap"})
public class ModifyMapServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String mapName=request.getParameter("mapName");
        String newName=request.getParameter("newName");
        String mapColor=request.getParameter("mapColor");
        String[] mapCoor=request.getParameterValues("mapCoor");
        mapService mapService = new mapServiceImpl();
        String flag="";
        int lines=0;
        try {
            //删除原有范围
            mapService.deleteMap(mapName);
            //添加范围
            for (int i = 0; i <mapCoor.length ; i++) {
                B_Map bMap=new B_Map();
                bMap.setMapName(newName);
                bMap.setCoordinate(mapCoor[i]);
                bMap.setMapColor(mapColor);
                lines=mapService.insertCoord(bMap);
                if (lines>0){
                    flag="SUCCESS";
                }else{
                    flag="FAIL";
                }
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
        doPost(request,response);
    }
}
