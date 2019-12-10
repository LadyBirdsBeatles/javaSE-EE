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
import java.util.List;

@WebServlet(name = "ZOptionServlet" ,urlPatterns = {"/son"})
public class ZOptionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        GoodsManageService goodsManageService = new GoodsManageServiceImpl();
        PrintWriter writer = response.getWriter();
        List soption = null;
        try {
            soption = goodsManageService.soption();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JSONObject json = JSONObject.fromObject(soption);
        String jsonJAVA = json.toString();
        writer.print(jsonJAVA);
        for (Object j : soption) {
            System.out.println("soption:"+j);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
