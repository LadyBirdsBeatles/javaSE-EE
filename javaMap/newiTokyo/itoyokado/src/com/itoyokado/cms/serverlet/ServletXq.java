package com.itoyokado.cms.serverlet;

import com.itoyokado.cms.common.BaseCRUD;
import com.itoyokado.cms.util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class ServletXq extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        //获得订单号
        if ("login".equals(request.getParameter("func"))) {
            String sys_no = request.getParameter("ddname");
            //System.out.println(sys_no);
            HttpSession session = request.getSession(true);
            session.setAttribute("ddname",sys_no);
            //System.out.println(session.getAttribute("ddname"));
        }

        //货物信息
        if ("success".equals(request.getParameter("func"))) {
            HttpSession session = request.getSession();
            Object sys_no = session.getAttribute("ddname");
            String sql ="select t7.category_name,t6.goods_name,t5.goods_num from waybill t1\n" +
                    "INNER JOIN buy_goods t5\n" +
                    "ON t1.id = t5.waybill_id\n" +
                    "INNER JOIN goods t6\n" +
                    "ON t6.id = t5.goods_id\n" +
                    "INNER JOIN goods_category t7\n" +
                    "on t6.category_id = t7.id\n" +
                    "WHERE t1.sys_no=?";
            //System.out.println(sql);
            //调用查询方法,用list接收
            Object[] params = {sys_no};
            BaseCRUD baseCRUD = new BaseCRUD();
            try {
                List<Map<String, Object>> select = baseCRUD.select(sql, params);
                //System.out.println(select);
                JsonConfig jsonConfig = new JsonConfig();
                jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
                JSONArray jsonArray = JSONArray.fromObject(select,jsonConfig);
                response.getWriter().print("{\"code\": 0,\"msg\": \"\",\"count\": 60,\"data\":"+jsonArray+"}");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //订单详情查询
        if ("xq".equals(request.getParameter("func"))) {
            HttpSession session = request.getSession();
            Object sys_no = session.getAttribute("ddname");
            String sql ="select * from waybill t1\n" +
                    "INNER JOIN `user` t2\n" +
                    "on t1.consignee_id = t2.id\n" +
                    "INNER JOIN sys_user t3\n" +
                    "on t1.sys_user_id = t3.id\n" +
                    "INNER JOIN (SELECT MAX(status_number) as status_number,waybill_id,text,last_date FROM waybill_detail GROUP BY waybill_id) t4\n" +
                    "on t1.id = t4.waybill_id\n" +
                    "WHERE t1.sys_no=?";
            Object[] params = {sys_no};
            BaseCRUD baseCRUD = new BaseCRUD();
            try {
                List<Map<String, Object>> select = baseCRUD.select(sql, params);
                JsonConfig jsonConfig = new JsonConfig();
                jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
                select.forEach(item->{
                    if (Objects.nonNull(item.get("created_date"))) {
                        Date date = (Date) item.get("created_date");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        item.put("created_date", sdf.format(date));
                    }
                });
                JSONArray jsonArray = JSONArray.fromObject(select,jsonConfig);
                response.getWriter().print("{\"code\": 0,\"msg\": \"\",\"count\": 60,\"data\":"+jsonArray+"}");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //物流信息查询
        if ("wl".equals(request.getParameter("func"))) {
            HttpSession session = request.getSession();
            Object sys_no = session.getAttribute("ddname");
            String sql ="select t4.status_number,t3.s_name,t3.job_number,t4.last_date from waybill t1\n" +
                    "INNER JOIN sys_user t3\n" +
                    "on t1.sys_user_id = t3.id\n" +
                    "INNER JOIN waybill_detail t4\n" +
                    "on t1.id = t4.waybill_id\n" +
                    "WHERE t1.sys_no=?";
            //System.out.println(sql);
            //调用查询方法,用list接收
            Object[] params = {sys_no};
            BaseCRUD baseCRUD = new BaseCRUD();
            try {
                List<Map<String, Object>> select = baseCRUD.select(sql, params);
                JsonConfig jsonConfig = new JsonConfig();
                jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
                select.forEach(item->{
                    if (Objects.nonNull(item.get("last_date"))) {
                        Date date = (Date) item.get("last_date");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        item.put("last_date", sdf.format(date));
                    }
                });
                JSONArray jsonArray = JSONArray.fromObject(select,jsonConfig);
                response.getWriter().print("{\"code\": 0,\"msg\": \"\",\"count\": 60,\"data\":"+jsonArray+"}");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //退货列表
        if ("tlist".equals(request.getParameter("func"))) {
            String sql = "select * from waybill t1\n" +
                    "INNER JOIN `user` t2\n" +
                    "on t1.consignee_id = t2.id\n" +
                    "INNER JOIN sys_user t3\n" +
                    "on t1.sys_user_id = t3.id\n" +
                    "INNER JOIN waybill_detail t4\n" +
                    "on t1.id = t4.waybill_id\n" +
                    "WHERE t4.status_number='5'";
            //调用查询方法,用list接收
            BaseCRUD baseCRUD = new BaseCRUD();
            try {
                List<Map<String, Object>> select = baseCRUD.select(sql, null);
                System.out.println(select);
                JsonConfig jsonConfig = new JsonConfig();
                jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
                JSONArray jsonArray = JSONArray.fromObject(select,jsonConfig);
                System.out.println(jsonArray);
                response.getWriter().print("{\"code\": 0,\"msg\": \"\",\"count\": 1,\"data\":"+jsonArray+"}");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }








    }
}
