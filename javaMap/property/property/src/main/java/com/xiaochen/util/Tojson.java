package com.xiaochen.util;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * @author xiaochen
 */
public class Tojson {
    public static String tojson(Integer pagecount, List list) {
       /* Map<String, Object> maps = new HashMap<>();*/
        JSONObject maps = new JSONObject();
        maps.put("code", 0);
        maps.put("msg", "");
        maps.put("count", list.size());
        maps.put("data", list);
        JSONObject jsons = JSONObject.fromObject(maps);
        String jsondate = jsons.toString();
        return jsondate;
    }
}
