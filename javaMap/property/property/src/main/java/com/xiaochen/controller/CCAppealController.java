package com.xiaochen.controller;

import com.xiaochen.pojo.Admin;
import com.xiaochen.pojo.Appeal;
import com.xiaochen.pojo.Reply;
import com.xiaochen.service.CCAppealService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/ccappeal")
public class CCAppealController {

    @Autowired
            @Qualifier("appealService")
    CCAppealService appealService;

    /**
     * 查询投诉详情
     * @param appealId
     * @param response
     */
    @RequestMapping(value = "/details",method = RequestMethod.POST)
    public void details(Integer appealId, HttpServletResponse response){
        Appeal appeal = appealService.getAppeal(appealId);
        Map map=new HashMap<>();
        map.put("appealId",appeal.getAppealId());
        map.put("userName",appeal.getUser().getUserName());
        map.put("userPhoneNumber",appeal.getUser().getUserPhonenumber());
        map.put("appealTile",appeal.getAppealTitle());
        map.put("appealDate",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(appeal.getAppealDate()));
        map.put("appealContent",appeal.getAppealContent());
        if(appeal.getAppealState()==0){
            map.put("appealState","未处理");
        }else if (appeal.getAppealState()==1){
            map.put("appealState","处理中");
        }else if (appeal.getAppealState()==2){
            map.put("appealState","处理完成待评价");
        }else if (appeal.getAppealState()==3){
            map.put("appealState","已评价");
        }
        map.put("appealEva",appeal.getAppealEva());
        if(appeal.getAdmin()==null){
            map.put("adminName",null);
        }else {
            map.put("adminName",appeal.getAdmin().getAdminName());
        }
        map.put("userDress",appeal.getUser().getUserDress());
        List hf=new ArrayList();
        for (Reply reply : appeal.getReply()) {
            Map subhf=new HashMap();
            if(reply.getReplyPerson()==0){
                subhf.put("name",appeal.getUser().getUserName());
            }else {
                subhf.put("name","客服");
            }
            subhf.put("replyDate",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(reply.getReplyDate()));
            subhf.put("replyContent",reply.getReplyContent());
            hf.add(subhf);
        }
        map.put("reply",hf);
        JSONObject json=new JSONObject(map);
        try {
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 查询投诉概况
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/abstract")
    @ResponseBody
    public Map abstractAll(int page,int limit){
        Map pageMap=new HashMap();
        pageMap.put("tablename","appeal");
        pageMap.put("page",page);
        pageMap.put("limits",limit);
        int rows=0;
        pageMap.put("rows",rows);
        Map layMap=new HashMap();
        List<Appeal> appeals = appealService.ccGetAppealAll(pageMap);
        List maps=new ArrayList();
        for (Appeal appeal : appeals) {
            Map map=new HashMap<>();
            map.put("appealId",appeal.getAppealId());
            map.put("userName",appeal.getUser().getUserName());
            map.put("userPhoneNumber",appeal.getUser().getUserPhonenumber());
            map.put("appealTitle",appeal.getAppealTitle());
            map.put("appealDate",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(appeal.getAppealDate()));
            if(appeal.getAppealState()==0){
                map.put("appealState","未处理");
            }else if (appeal.getAppealState()==1){
                map.put("appealState","处理中");
            }else if (appeal.getAppealState()==2){
                map.put("appealState","处理完成待评价");
            }else if (appeal.getAppealState()==3){
                map.put("appealState","已评价");
            }
            if(appeal.getAdmin()==null){
                map.put("adminName",null);
            }else {
                map.put("adminName",appeal.getAdmin().getAdminName());
            }
            map.put("userDress",appeal.getUser().getUserDress());
            maps.add(map);
        }
        layMap.put("code",0);
        layMap.put("msg","");
        layMap.put("count",pageMap.get("rows"));
        layMap.put("data",maps);
        return layMap;
    }

    /**
     * 查询所有客服人员
     * @return
     */
    @RequestMapping("/getAdmin")
    @ResponseBody
    public List<Admin> adminAll(){
        return appealService.ccGetAdminAll();
    }

    /**
     * 修改报投表客服id
     * @param adminId
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateAdmin")
    @ResponseBody
    public Map updateAdmin(Integer adminId,Integer id){
        System.out.println(adminId+";"+id);
        Map json= null;
        Map map=new HashMap();
        map.put("adminId",adminId);
        map.put("id",id);
        json = new HashMap();
        if(appealService.ccUpdateAdmin(map)>0){
            Appeal appeal = new Appeal();
            appeal.setAppealId(id);
            appeal.setAppealState(1);
            appealService.ccUpdateState(appeal);
            json.put("tf","true");
        }else {
            json.put("tf","设置失败");
        }
        return json;
    }

    /**
     * 客服回复
     * @param reply
     * @return
     */
    @RequestMapping(value = "/insertReply" )
    @ResponseBody
    public Map insertReply(Reply reply){
        reply.setReplyDate(new Date());
        reply.setReplyPerson(1);
        reply.setReplyType(1);
        Map map=new HashMap();
        if(appealService.ccInsert(reply)>0){
            map.put("tf","true") ;
        }else {
            map.put("tf","回复系统故障");
        }
        return map;
    }



    /**
     * 修改状态
     * @param appeal
     * @return
     */
    @RequestMapping(value = "/updateState")
    @ResponseBody
    public Map updateState(Appeal appeal){
        Map map=new HashMap();
        if(appealService.ccUpdateState(appeal)>0){
            map.put("tf","true");
        }else {
            map.put("tf","出现了一个错误");
        }
        return map;
    }



}
