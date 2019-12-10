package com.itoyokado.cms.serverlet;

import com.itoyokado.cms.common.BaseCRUD;
import com.itoyokado.cms.util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ServletList extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        if ("ddlist".equals(request.getParameter("func"))) {
            String sql = "select * from waybill t1\n" +
                    "INNER JOIN `user` t2\n" +
                    "on t1.consignee_id = t2.id\n" +
                    "INNER JOIN sys_user t3\n" +
                    "on t1.sys_user_id = t3.id\n" +
                    "INNER JOIN (SELECT MAX(status_number) as status_number,waybill_id,text,last_date FROM waybill_detail GROUP BY waybill_id) t4\n" +
                    "on t1.id = t4.waybill_id";
            //调用查询方法,用list接收
            BaseCRUD baseCRUD = new BaseCRUD();
            try {
                List<Map<String, Object>> select = baseCRUD.select(sql, null);
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
                response.getWriter().print("{\"code\": 0,\"msg\": \"\",\"count\": 3,\"data\":"+jsonArray+"}");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
        doPost(request, response);

    }
}
