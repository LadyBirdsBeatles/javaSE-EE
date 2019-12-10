package com.xiaochen.controller;


import com.xiaochen.pojo.User;
import com.xiaochen.service.LCostService;
import com.xiaochen.service.LaliPayService;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cost")
public class LCostController {
    @Autowired
    private LCostService lCostService;

    @Autowired
    private LaliPayService laliPayService;

    /**
     * 缴费单
     */
    @RequestMapping("/nocost")
    @ResponseBody
    public JSONObject getcostList(int page, int limit) {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        User userSession = (User) session.getAttribute("loginman");
        Map map = new HashMap();
        int rows = 0;
        map.put("uid", userSession.getUserId());
        map.put("page", page);
        map.put("limits", limit);
        map.put("rows", rows);
        JSONObject selectcostlist = lCostService.selectcostlist(map);
        return selectcostlist;
    }

    /**
     * 账单
     */
    @RequestMapping("/pastsuccess")
    @ResponseBody
    public JSONObject getcostsuccess() {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        User userSession = (User) session.getAttribute("loginman");
        JSONObject selectcostsuccess = lCostService.selectcostsuccess(userSession.getUserId());
        return selectcostsuccess;
    }

    /**
     * pay的账单账单
     */
    @RequestMapping("/account")
    @ResponseBody
    public JSONObject getAccount(int page, int limit) {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        User userSession = (User) session.getAttribute("loginman");
        Map map = new HashMap();
        int rows = 0;
        map.put("uid", userSession.getUserId());
        map.put("page", page);
        map.put("limits", limit);
        map.put("rows", rows);
        JSONObject jsonObject = laliPayService.SelectAccountPay(map);
        return  jsonObject;
    }
}
