package com.itoyokado.cms.control.GoodsManage;

import com.itoyokado.cms.entity.Goods;
import com.itoyokado.cms.entity.Goods_Category;
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

@WebServlet(name = "AddgoodsServlet", urlPatterns = {"/adgodos"})
public class AddgoodsServlet extends HttpServlet {
    /*
     * 添加商品
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
        String goodsNames = request.getParameter("adgoods");
        String addpaent = request.getParameter("addparent");
        String addchid = request.getParameter("addson");
        System.out.println(goodsNames);
        System.out.println(addpaent);
        System.out.println(addchid);
        GoodsManageService goodsManageService = new GoodsManageServiceImpl();
        Goods goods = new Goods();
        goods.setGoods_name(goodsNames);
        Goods_Category goods_category = new Goods_Category();
        goods_category.setCategory_name(addpaent);
        String sql = "insert into goods (category_id,goods_name) values(?,?)";
        boolean addgoods = false;
        String flag = null;
        try {
            //添加物品
            addgoods = goodsManageService.addgoods(goods);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter writer = response.getWriter();
        if (addgoods) {
            flag = "SUCCESS";
        } else {
            flag = "FALL";
        }

        writer.print("{\"flag\":\"" + flag + "\"}");
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
