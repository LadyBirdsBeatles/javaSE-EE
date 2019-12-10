package com.itoyokado.cms.util;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 转换json
 */
public class JsonUtil {

    /**
     * 输出json
     * @param response
     * @param value
     */
    public  static void response(HttpServletResponse response, Object value){
        try {
            // 设置类型以及编码
            response.setContentType("application/json;charset=utf-8");
            //转换为json
            Gson gson=new Gson();
            String valueJson = gson.toJson(value);
            response.getWriter().println(valueJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 带响应 提示JSON
     * @param response
     * @param value
     */
    public  static void response(HttpServletResponse response,Integer code,String msg,Object value){
        try {
            // 设置类型以及编码
            response.setContentType("application/json;charset=utf-8");
            //map
            Map<String,Object> map=new HashMap<>();
            map.put("code",code);
            map.put("msg",msg);
            map.put("data",value);
            //转换为json
            Gson gson=new Gson();
            String mapJson = gson.toJson(map);
            response.getWriter().println(mapJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
