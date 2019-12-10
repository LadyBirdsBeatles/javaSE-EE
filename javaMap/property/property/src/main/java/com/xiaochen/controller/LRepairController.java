package com.xiaochen.controller;

import com.xiaochen.pojo.Admin;
import com.xiaochen.pojo.Repair;
import com.xiaochen.pojo.Reply;
import com.xiaochen.pojo.User;
import com.xiaochen.service.LRepairService;
import net.sf.json.JSONArray;
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
@RequestMapping("/repair")
public class LRepairController {
    /**
     * 在线报修
     */
    @Autowired
    LRepairService repairService;

    @RequestMapping("/addrepair")
    @ResponseBody
    public boolean onrepair(@RequestBody Map<String, String> map) {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        User userSession = (User) session.getAttribute("loginman");
        String username = map.get("username");
        String phone = map.get("phone");
        String titles = map.get("titles");
        String address = map.get("address");
        String desc = map.get("desc");
        System.out.println(username + phone + titles + address + desc);
        Repair repair = new Repair();
        User user = new User();
        /*Admin admin = new Admin();
        admin.setAdminId(null);*/
        user.setUserId(userSession.getUserId());
        user.setUserPhonenumber(userSession.getUserPhonenumber());
        user.setUserName(userSession.getUserName());
        repair.setRepairDate(new Date());
        repair.setUser(user);
        /*repair.setAdmin(admin);*/
        repair.setRepairContent(desc);
        repair.setRepairTitle(titles);
        repair.setRepairState(0);
        repair.setRepairEva("未评价");
        int insert = repairService.insert(repair);
        System.out.println(insert);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    /**
     * 未处理的报修
     */
    @RequestMapping("/nail")
    @ResponseBody
    public JSONObject norepair() {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        User userSession = (User) session.getAttribute("loginman");
        return repairService.showrepair(userSession.getUserId());
    }

    /**
     * 未处理的报修结果
     *
     * @return
     */
    @RequestMapping("/noresult")
    @ResponseBody
    public Map norepairresult(Integer repairId) {
        System.out.println(repairId);
        Map nopairresult = repairService.nopairresult(repairId);
        JSONArray json = JSONArray.fromObject(nopairresult);
        System.out.println(json);
        return nopairresult;
    }

    /**
     * 已处理的报修结果
     * @return
     */
    @RequestMapping("/pastresult")
    @ResponseBody
    public Map pastrepairae(Integer repairId) {
        System.out.println(repairId);
        Map psatpairresult = repairService.psatpairresult(repairId);
        return psatpairresult;
    }

    /**
     * 以处理的报修
     */
    @RequestMapping("/past")
    @ResponseBody
    public JSONObject pastrepair(int page,int limit) {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        User userSession = (User) session.getAttribute("loginman");
        Map map = new HashMap();
        int rowis = 0;
        map.put("uid",userSession.getUserId());
        map.put("page", page);
        map.put("limits", limit);
        map.put("rowis", rowis);
        return repairService.pastepair(map);
    }

    /**
     * 以处理的报修的回复
     */
    @RequestMapping("/react")
    @ResponseBody
    public Map clinsertReply(Reply reply) {
        reply.setReplyDate(new Date());
        reply.setReplyPerson(0);
        reply.setReplyType(0);
        Map map = new HashMap();
        if (repairService.clInsert(reply) > 0) {
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
    public Map upReplyState(Repair repair) {
        System.out.println( repair.getRepairId());
        System.out.println( repair.getRepairEva());
        repair.setRepairState(3);
        Map map = new HashMap();
        if (repairService.updateestimate(repair) > 0) {
            map.put("state", "true");
        } else {
            map.put("state", "false");
        }
        return map;
    }
}
