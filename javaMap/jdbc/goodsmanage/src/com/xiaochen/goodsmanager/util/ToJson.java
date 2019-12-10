package com.xiaochen.goodsmanager.util;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToJson {
    /**
     *
     * @param pagecount
     * @param list
     * @return
     */
    public String tojson(Integer pagecount, List list){
         /*JSONArray json = JSONArray.fromObject(empshows);
            PrintWriter pw = response.getWriter();
            pw.print(json);*/
        Map<String, Object> map = new HashMap<>();
        /* SONObject map=new JSONObject();*/
        map.put("code",0);
        map.put("msg","");
        map.put("count",pagecount);
        map.put("data",list);
        JSONObject json = JSONObject.fromObject(map);
        String jsonJAVA = json.toString();
        return jsonJAVA;
    }
}
