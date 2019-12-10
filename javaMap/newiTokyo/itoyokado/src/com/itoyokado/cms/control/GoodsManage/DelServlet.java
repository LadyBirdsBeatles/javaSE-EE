package com.itoyokado.cms.control.GoodsManage;

import com.itoyokado.cms.entity.Goods;
import com.itoyokado.cms.service.GoodsManageService;
import com.itoyokado.cms.service.impl.GoodsManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "DelServlet",urlPatterns = {"/deltoids"})
public class DelServlet extends HttpServlet {
    /**
     * 删除商品
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String catgoodid = request.getParameter("catgoodid");
        System.out.println(catgoodid);
        GoodsManageService goodsManageService = new GoodsManageServiceImpl();
        Goods goods = new Goods();
        goods.setId(new Integer(catgoodid));
        String flag = null;
        boolean delgoods;
        try {
            delgoods = goodsManageService.delgoods(goods);
            if (delgoods) {
                flag = "SUCCESS";
            } else {
                flag = "FALL";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter writer = response.getWriter();
        writer.print("{\"flag\":\"" + flag + "\"}");
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
