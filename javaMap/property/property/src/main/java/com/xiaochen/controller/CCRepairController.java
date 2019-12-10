package com.xiaochen.controller;

import com.xiaochen.pojo.Admin;
import com.xiaochen.pojo.Repair;
import com.xiaochen.pojo.Reply;
import com.xiaochen.service.CCRepairService;
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
@RequestMapping("/cc")
public class CCRepairController {
     @Autowired
     @Qualifier("repairService")
     CCRepairService repairService;

    /**
     * 查询报修详情
     * @param repairId
     * @param response
     */
    @RequestMapping(value = "/repair/details",method = RequestMethod.POST)
    public void details(Integer repairId, HttpServletResponse response){
        Repair repair = repairService.getRepair(repairId);
        Map map=new HashMap<>();
        map.put("repairId",repair.getRepairId());
        map.put("userName",repair.getUser().getUserName());
        map.put("userPhoneNumber",repair.getUser().getUserPhonenumber());
        map.put("repairTile",repair.getRepairTitle());
        map.put("repairDate",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(repair.getRepairDate()));
        map.put("repairContent",repair.getRepairContent());
        if(repair.getRepairState()==0){
            map.put("repairState","未处理");
        }else if (repair.getRepairState()==1){
            map.put("repairState","处理中");
        }else if (repair.getRepairState()==2){
            map.put("repairState","处理完成待评价");
        }else if (repair.getRepairState()==3){
            map.put("repairState","已评价");
        }
        map.put("repairEva",repair.getRepairEva());
        if(repair.getAdmin()==null){
            map.put("adminName",null);
        }else {
            map.put("adminName",repair.getAdmin().getAdminName());
        }

        map.put("userDress",repair.getUser().getUserDress());
        List hf=new ArrayList();
        for (Reply reply : repair.getReply()) {
            Map subhf=new HashMap();
            if(reply.getReplyPerson()==0){
                subhf.put("name",repair.getUser().getUserName());
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
     * 查询报修概况
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/repair/abstract")
    @ResponseBody
    public Map abstractAll(int page,int limit){
        Map pageMap=new HashMap();
        pageMap.put("tablename","repair");
        pageMap.put("page",page);
        pageMap.put("limits",limit);
        int rows=0;
        pageMap.put("rows",rows);
        Map layMap=new HashMap();
        List<Repair> repairs = repairService.ccGetRepairAll(pageMap);
        List maps=new ArrayList();
            for (Repair repair : repairs) {
                Map map=new HashMap<>();
                map.put("repairId",repair.getRepairId());
                map.put("userName",repair.getUser().getUserName());
                map.put("userPhoneNumber",repair.getUser().getUserPhonenumber());
                map.put("repairTitle",repair.getRepairTitle());
                map.put("repairDate",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(repair.getRepairDate()));
                if(repair.getRepairState()==0){
                    map.put("repairState","未处理");
                }else if (repair.getRepairState()==1){
                    map.put("repairState","处理中");
                }else if (repair.getRepairState()==2){
                    map.put("repairState","处理完成待评价");
                }else if (repair.getRepairState()==3){
                    map.put("repairState","已评价");
                }
                if(repair.getAdmin()==null){
                    map.put("adminName",null);
                }else {
                    map.put("adminName",repair.getAdmin().getAdminName());
                }
                map.put("userDress",repair.getUser().getUserDress());
                maps.add(map);
            }
        layMap.put("code",0);
        layMap.put("msg","");
        layMap.put("count",pageMap.get("rows"));
        layMap.put("data",maps);
        return layMap;
    }

    /**
     * 查询所有维修人员
     * @return
     */
    @RequestMapping("/repair/getAdmin")
    @ResponseBody
    public List<Admin> adminAll(){
       return repairService.ccGetAdminAll();
    }

    /**
     * 修改报修表维修人员id
     * @param adminId
     * @param id
     * @return
     */
  @RequestMapping(value = "/repair/updateAdmin",method = RequestMethod.POST)
  @ResponseBody
    public Map updateAdmin(Integer adminId,Integer id){
        System.out.println(adminId+";"+id);
      Map json= null;
         Map map=new HashMap();
         map.put("adminId",adminId);
         map.put("id",id);
          json = new HashMap();
          if(repairService.ccUpdateAdmin(map)>0){
              Repair repair = new Repair();
              repair.setRepairId(id);
              repair.setRepairState(1);
              repairService.ccUpdateState(repair);
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
    @RequestMapping("/repair/insertReply")
    @ResponseBody
    public Map insertReply(Reply reply){
        reply.setReplyDate(new Date());
        reply.setReplyPerson(1);
        reply.setReplyType(0);
        Map map=new HashMap();
        if(repairService.ccInsert(reply)>0){
            map.put("tf","true");

        }else {
            map.put("tf","回复系统故障");
        }
        return map;
    }



    /**
     * 修改状态
     * @param repair
     * @return
     */
    @RequestMapping("/repair/updateState")
    @ResponseBody
    public Map updateState(Repair repair){
        System.out.println(repair);
        Map json=new HashMap();
        if(repairService.ccUpdateState(repair)>0){
            json.put("tf","true");
        }else {
            json.put("tf","出现了一个错误");
        }
        return json;
    }
}
