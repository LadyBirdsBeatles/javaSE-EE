package com.xiaochen.goodsmanager.Servlet;

import com.xiaochen.goodsmanager.entity.Admin;
import com.xiaochen.goodsmanager.entity.Employee;
import com.xiaochen.goodsmanager.entity.Pagelimit;
import com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl.LimitServiceDaoimpl;
import com.xiaochen.goodsmanager.util.ToJson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * 单表查询单表查询分页
 */
@WebServlet(name = "PageLimitServlet",urlPatterns = {"/page"})
public class PageLimitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        LimitServiceDaoimpl limitDao = new LimitServiceDaoimpl();
        Employee employee = new Employee();
        //Admin admin = new Admin();
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        try {
            Pagelimit pageBean = limitDao.pageLimit(employee, page, limit);
            List  list = pageBean.getList();
            Integer pageRow = pageBean.getPageRow();
            ToJson toJson = new ToJson();
            String tojson = toJson.tojson(pageRow, list);
            PrintWriter out = response.getWriter();
            out.print(tojson);
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
}
