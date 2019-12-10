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

@WebServlet(name = "FzOptionServlet",urlPatterns = {"/father"})
public class FOptionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        GoodsManageService goodsManageService = new GoodsManageServiceImpl();
        PrintWriter writer = response.getWriter();
        List foption = null;

        try {
            foption = goodsManageService.foption();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JSONObject json = JSONObject.fromObject(foption);
        String jsonJAVA = json.toString();
        writer.print(jsonJAVA);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
