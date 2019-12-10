package com.xiaochen.goodsmanager.Servlet;

import com.xiaochen.goodsmanager.entity.Employee;
import com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl.ManageServiceDaoimpl;
import com.xiaochen.goodsmanager.service.ManageServiceDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "WritServlet",urlPatterns = {"/writ"})
public class WritServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManageServiceDao manageServiceDao = new ManageServiceDaoimpl();
        Employee employee = new Employee();
        List list = null;
        try {
            list = manageServiceDao.empshows(employee);
            JSONArray jSONArray = JSONArray.fromObject(list);
            String jsonJAVA = jSONArray.toString();
            response.getWriter().print(jsonJAVA);
            System.out.println(jSONArray);
            System.out.println(jsonJAVA);
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
