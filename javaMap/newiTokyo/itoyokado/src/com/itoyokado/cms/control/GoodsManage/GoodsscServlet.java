package com.itoyokado.cms.control.GoodsManage;

import com.itoyokado.cms.service.GoodsManageService;
import com.itoyokado.cms.service.impl.GoodsManageServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "GoodsscServlet", urlPatterns = {"/goods"})
public class GoodsscServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        GoodsManageService goodsManageService = new GoodsManageServiceImpl();
        String name = request.getParameter("id");
        PrintWriter writer = response.getWriter();
        List showgoods = null;
        List showname = null;
        try {
            if (name!=null){
                showname = goodsManageService.showname(name);
            }else {
                showgoods = goodsManageService.showgoods();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (name != null) {
            Map<String, Object> maps = new HashMap<>();
            maps.put("code", 0);
            maps.put("msg", "");
            maps.put("count", showname.size());
            maps.put("data", showname);
            JSONObject jsons = JSONObject.fromObject(maps);
            String jsonname = jsons.toString();
            writer.print(jsonname);
            System.out.println(jsonname);
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", showgoods.size());
            map.put("data", showgoods);
            JSONObject json = JSONObject.fromObject(map);
            String jsonJAVA = json.toString();
            System.out.println(jsonJAVA);
            writer.print(jsonJAVA);
        }
        writer.close();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
