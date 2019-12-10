package com.xiaochen.goodsmanager.Servlet;
import com.xiaochen.goodsmanager.entity.Employee;
import com.xiaochen.goodsmanager.entity.Pagelimit;
import com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl.ManageServiceDaoimpl;
import com.xiaochen.goodsmanager.service.ManageServiceDao;
import com.xiaochen.goodsmanager.util.ToJson;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet(name = "LimitServlet",urlPatterns = {"/limits"})
public class LimitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        ManageServiceDao manageServiceDao = new ManageServiceDaoimpl();
        Employee employee = new Employee();
        try {
            List list = manageServiceDao.empshows(employee);
            ToJson toJson = new ToJson();
            Pagelimit pagelimit=new Pagelimit();
            String tojson = toJson.tojson((int)pagelimit.getPageRow(),list);
            PrintWriter out = response.getWriter();
            out.print(tojson);
        } catch (ClassNotFoundException | SQLException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
