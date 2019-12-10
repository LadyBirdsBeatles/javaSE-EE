package com.xiaochen.controller;


import com.xiaochen.pojo.Admin;
import com.xiaochen.pojo.Appeal;
import com.xiaochen.pojo.Reply;
import com.xiaochen.pojo.User;
import com.xiaochen.service.LAppealService;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/complain")
public class LAppealController {
    /**
     * 在线投诉
     */
    @Autowired
    LAppealService lAppealService;

    @RequestMapping("/addcomplain")
    @ResponseBody
    public boolean onrepair(@RequestBody Map<String, String> map) {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        User userSession = (User) session.getAttribute("loginman");
        String titles = map.get("titles");
        String address = map.get("address");
        String desc = map.get("desc");
        String username = map.get("username");
        String phone = map.get("phone");
        System.out.println(username + phone + titles + address + desc);
        Appeal appeal = new Appeal();
        appeal.setAppealContent(desc);
        appeal.setAppealDate(new Date());
        appeal.setAppealDate(new Date());
        appeal.setAppealState(0);
        /*Admin admin = new Admin();
        admin.setAdminId(null);
        appeal.setAdmin(admin);*/
        User user = new User();
        user.setUserId(userSession.getUserId());
        user.setUserName(userSession.getUserName());
        user.setUserPhonenumber(userSession.getUserPhonenumber());
        appeal.setUser(user);
        appeal.setAppealTitle(titles);
        appeal.setAppealEva("未评价");
        int insert = lAppealService.insert(appeal);
        System.out.println(insert);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    /**
     * 未处理的投诉
     */
    @RequestMapping("/nail")
    @ResponseBody
    public JSONObject nocomplain() {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        User userSession = (User) session.getAttribute("loginman");
        return lAppealService.nocomplain(userSession.getUserId());
    }

    /**
     * 以处理的投诉
     */
    @RequestMapping("/past")
    @ResponseBody
    public JSONObject pastcomplain(int page,int limit) {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        User userSession = (User) session.getAttribute("loginman");
        Map map = new HashMap();
        int rowis = 0;
        map.put("uid", userSession.getUserId());
        map.put("page", page);
        map.put("limits", limit);
        map.put("rowis", rowis);
        return lAppealService.pastcomplain( map);
    }

    /**
     * 未处理的投诉回复
     *
     * @return
     */
    @RequestMapping("/nailresult")
    @ResponseBody
    public Map nocomplain(Integer appealId) {
        System.out.println(appealId);
        Map nocomplainresult = lAppealService.nocomplainresult(appealId);
        return nocomplainresult;
    }

    /**
     * 以处理的投诉结果
     */
    @RequestMapping("/pastresult")
    @ResponseBody
    public Map pastcomplain(Integer appealId) {
        return lAppealService.pastcomplainresult(appealId);
    }

    /**
     * 以处理的投诉的回复
     */
    @RequestMapping("/comreact")
    @ResponseBody
    public Map clinsertReply(Reply reply) {
        reply.setReplyDate(new Date());
        reply.setReplyPerson(0);
        reply.setReplyType(1);
        Map map = new HashMap();
        System.out.println(reply);
        if (lAppealService.cflInsert(reply) > 0) {
            map.put("tf", "true");
        } else {
            map.put("tf", "回复系统故障");
        }
        return map;
    }

    /**
     * 以处理报修的评价
     */
    @RequestMapping("/evaluate")
    @ResponseBody
    public Map upappealState(Appeal appeal) {
        System.out.println(appeal.getAppealId());
        System.out.println(appeal.getAppealEva());
        appeal.setAppealState(3);
        Map map = new HashMap();
        int i = lAppealService.updateByPrimaryKeySelective(appeal);
        System.out.println(i);
        if (i> 0) {
            map.put("state", "true");
        } else {
            map.put("state", "false");
        }
        return map;
    }
}
