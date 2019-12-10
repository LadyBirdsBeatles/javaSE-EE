package com.xiaochen.controller;

import com.xiaochen.pojo.MsgCount;
import com.xiaochen.pojo.User;
import com.xiaochen.service.MsgCountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/property")
public class MsgCountController {
    @Autowired
    private MsgCountService msgCountService;

    @ResponseBody
    @RequestMapping(value = "/msg/addCount")
    private void addMsgCount(@RequestBody MsgCount msgCount){
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        User loginman = (User) session.getAttribute("loginman");
        Integer userId = loginman.getUserId();
        System.out.println(msgCount);
        msgCount.setMsgcountUid(userId);
        System.out.println(msgCount);
        MsgCount msgCount1 = msgCountService.selectByPrimaryKey(msgCount);
        System.out.println(msgCount1);
        if (msgCount1 == null){
            msgCount.setMsgcountReadtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            msgCountService.insertSelective(msgCount);
            System.out.println("新增加的!");
        }else {
            msgCount1.setMsgcountReadtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            msgCountService.updateByPrimaryKeySelective(msgCount1);
            System.out.println("修改后的!");

        }

    }

}
