package com.xiaochen.controller;

import com.xiaochen.pojo.Admin;
import com.xiaochen.pojo.Msg;
import com.xiaochen.service.MsgService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/property")
public class MsgController {

    @Autowired
    private MsgService msgService;

    //查看公司列表
    @ResponseBody
    @RequestMapping(value = "/msg")
    public Map selectListC(Integer msgClass,Integer page,Integer limit){
        HashMap<Object, Object> mapPage = new HashMap<>();
        mapPage.put("msgClass",msgClass);
        mapPage.put("page",page);
        mapPage.put("limits",limit);
        int rows = 0;
        mapPage.put("rows",rows);
        List<Msg> select = msgService.select(mapPage);
        System.out.println(select);
        for (int i = 0;i < select.size();i++){
          if (select.get(i).getUsers().size() ==1 &&select.get(i).getUsers().get(0).getUserName()==null){
              select.get(i).setMsgOther2(0);
          }else {
              int size = select.get(i).getUsers().size();
              select.get(i).setMsgOther2(size);
          }
        }
        System.out.println(select);
        Map map =new HashMap<>();
        map.put("count",mapPage.get("rows"));
        map.put("data",select);
        map.put("code",0);
        map.put("msg","");
        return map;
    }


    //修改信息(包含假删除)
    @RequestMapping(value = "/msg/update")
    @ResponseBody
    public Integer updateList(@RequestBody Msg msg){
        System.out.println(msg);
        msg.setMsgCreatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        int i = msgService.updateByPrimaryKeySelective(msg);
        return i;
    }


    //添加信息
    @RequestMapping(value = "/msg/add/notice")
    @ResponseBody
    public void AddList(@RequestBody Msg msg){
        System.out.println(msg);
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        Admin admin = (Admin) session.getAttribute("loginman");
        msg.setMsgCreatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        msg.setMsgAdmin(admin.getAdminName());
        msgService.insertSelective(msg);
    }

}
