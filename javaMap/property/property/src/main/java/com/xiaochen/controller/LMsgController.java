package com.xiaochen.controller;


import com.xiaochen.service.LMsgService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/msg")
public class LMsgController {
    @Autowired
    private LMsgService lMsgService;
    @RequestMapping("/mags")
    @ResponseBody
    public JSONObject getMsgList(int page,int limit) {
        System.out.println(page+"====="+limit);
        Map map=new HashMap();
        int rows=0;
        map.put("page", page);
        map.put("limits", limit);
        map.put("rows", rows);
        return lMsgService.showmsg(map);
    }

}
