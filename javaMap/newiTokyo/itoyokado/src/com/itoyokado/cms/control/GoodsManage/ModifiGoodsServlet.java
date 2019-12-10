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

@WebServlet(name = "ModifiGoodsServlet",urlPatterns = {"/modifiers"})
public class ModifiGoodsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String gname = request.getParameter("gname");
        String fname = request.getParameter("fname");
        String sonname = request.getParameter("sonname");
        String mid = request.getParameter("mid");
        System.out.println("gname------"+gname );
        System.out.println("fathername------"+fname);
        System.out.println("sonname+++++++++"+sonname);
        System.out.println("mid+++"+mid);
        GoodsManageService goodsManageService = new GoodsManageServiceImpl();
        Goods goods=new Goods();
        goods.setGoods_name(gname);
        goods.setCategory_id(Integer.parseInt(mid));
        Goods_Category goods_category=new Goods_Category();
        goods_category.setCategory_name(fname);
        goods_category.setId(Integer.parseInt(mid));

        Goods_Category goods_category1=new Goods_Category();
        goods_category1.setCategory_name(sonname);
        goods_category1.setId(Integer.parseInt(mid));
        String flag=null;

                flag = "SUCCESS";

                flag = "FALL";

        PrintWriter writer = response.getWriter();
        writer.print("{\"flag\":\"" + flag + "\"}");
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
