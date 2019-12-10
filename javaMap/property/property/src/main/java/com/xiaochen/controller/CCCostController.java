package com.xiaochen.controller;

import com.xiaochen.pojo.Cost;
import com.xiaochen.pojo.Pay;
import com.xiaochen.pojo.User;
import com.xiaochen.service.CCCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/ccCost")
public class CCCostController {

    @Autowired
    CCCostService service;

    /**
     * 查询账单
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/getAll")
    @ResponseBody
    public Map getAll(int page,int limit,String userName,String userPhonenumber){
        Map pageMap=new HashMap();
        if(userName==null||userName==""){
            pageMap.put("userName",null);
        }else {
            pageMap.put("userName","'"+userName+"'");
        }  if(userPhonenumber==""||userPhonenumber==null){
            pageMap.put("userPhonenumber",null);
        }else {
            pageMap.put("userPhonenumber","'"+userPhonenumber+"'");
        }
        pageMap.put("page",page);
        pageMap.put("limits",limit);
        int rows=0;
        pageMap.put("rows",rows);
        List<Cost> costs = service.ccGetAll(pageMap);
        Map layMap=new HashMap();
        List maps=new ArrayList();
        for (Cost cost : costs) {
            Map map=new HashMap();
            map.put("costId",cost.getCostId());
            map.put("costWater",cost.getCostWater());
            map.put("costAir",cost.getCostAir());
            map.put("costDate",new SimpleDateFormat("yyyy-MM").format(cost.getCostDate()));
            map.put("costGas",cost.getCostGas());
            map.put("costOther",cost.getCostOther());
            if(cost.getCostState()==0){
                map.put("costState","未缴费");
            }else if(cost.getCostState()==1){
                map.put("costState","已缴费");
            }
            if(cost.getUser()!=null){
            map.put("userName",cost.getUser().getUserName());
            map.put("userPhonenumber",cost.getUser().getUserPhonenumber());
            }
            map.put("costPower",cost.getCostPower());
            maps.add(map);
        }
        layMap.put("code",0);
        layMap.put("msg","");
        layMap.put("count",pageMap.get("rows"));
        layMap.put("data",maps);
        return layMap;
    }

    /**
     * 添加账单
     * @param cost
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Map add(Cost cost){
        cost.setCostState(0);
        System.out.println(cost);
        User user = service.ccGetUser(cost.getUser());
        Map map=new HashMap();
        if (user==null){
            map.put("tf","手机号错误,该用户没有这个手机号");
            return map;
        }
        Map ud=new HashMap();
        ud.put("userId",user.getUserId());
        ud.put("costDate",cost.getCostDate());
        if (service.ccGetCostByUserDate(ud)!=null){
            System.out.println(service.ccGetCostByUserDate(ud));
            map.put("tf","改账单已存在");
            return map;
        }
        cost.getUser().setUserId(user.getUserId());
       if( service.ccAdd(cost)>0){
           map.put("tf","true");
       }else {
           map.put("tf","添加失败，系统故障");
       }
       return map;
    }

    /**
     * 修改账单
     * @param cost
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Map update(Cost cost){
        Map map=new HashMap();
        cost.setCostState(0);
        User user = service.ccGetUser(cost.getUser());
        if(user==null){
            map.put("tf","手机号错误，该用户没有此手机号");
            return map;
        }
        cost.setUser(user);
        System.out.println(cost);
        Map ud=new HashMap();
        ud.put("userId",user.getUserId());
        ud.put("costDate",cost.getCostDate());
       Cost c= service.ccGetCostByUserDate(ud);
        if (c!=null&&c.getCostId()!=cost.getCostId()){
            System.out.println(service.ccGetCostByUserDate(ud));
            map.put("tf","该账单已存在");
            return map;
        }
       if( service.ccUpdate(cost)>0){
           map.put("tf","true");
       }else {
           map.put("tf","修改失败");
       }
       return map;
    }

    /**
     * 查询缴费
     * @param page
     * @param limit
     * @param userName
     * @param userPhonenumber
     * @return
     */
    @RequestMapping("/pay")
    @ResponseBody
    public Map pay(int page,int limit,String userName,String userPhonenumber){
        Map pageMap=new HashMap();
        pageMap.put("page",page);
        pageMap.put("limits",limit);
        if(userName==null||userName==""){
            pageMap.put("userName",null);
        }else {
            pageMap.put("userName","'"+userName+"'");
        }  if(userPhonenumber==""||userPhonenumber==null){
            pageMap.put("userPhonenumber",null);
        }else {
            pageMap.put("userPhonenumber","'"+userPhonenumber+"'");
        }
        Integer rows=0;
        pageMap.put("count",rows);
        List<Cost> costs = service.ccGetPay(pageMap);
        Map layMap=new HashMap();
        List maps=new ArrayList();
        for (Cost cost : costs) {
          Map map=new HashMap();
          map.put("costId",cost.getCostId());
          map.put("costDate",new SimpleDateFormat("yyyy-MM").format(cost.getCostDate()));
          map.put("userName",cost.getUser().getUserName());
          map.put("userDress",cost.getUser().getUserDress());
          map.put("sum",Integer.parseInt(cost.getCostPower())+Integer.parseInt(cost.getCostAir())+Integer.parseInt(cost.getCostGas())+Integer.parseInt(cost.getCostOther())+Integer.parseInt(cost.getCostWater()));
            if(cost.getCostState()==0){
                map.put("costState","未缴费");
            }else if(cost.getCostState()==1){
                map.put("costState","已缴费");
            }
           maps.add(map);
        }
        layMap.put("code",0);
        layMap.put("msg","");
        layMap.put("count",pageMap.get("count"));
        layMap.put("data",maps);
        return layMap;
    }

    /**
     * 按id查询缴费表
     * @param costId
     * @return
     */
    @RequestMapping("/getCost")
    @ResponseBody
    public Cost getCostById(String costId){
        System.out.println(costId);
        Cost cost = service.ccGetCost(Integer.parseInt(costId));
        Cost c = new Cost();
        c.setUser(cost.getUser());
        c.setCostState(cost.getCostState());
        c.setCostAir(cost.getCostAir());
        c.setCostGas(cost.getCostGas());
        c.setCostOther(cost.getCostOther());
        c.setCostPower(cost.getCostPower());
        c.setCostWater(cost.getCostWater());
        c.setCostId(cost.getCostId());
        System.out.println(cost);
        return c;
    }

    /**
     * 添加缴费记录
     * @param cost
     * @return
     */
    @RequestMapping("/addPay")
    @ResponseBody
    public Map addPay(Cost cost){
        System.out.println(cost);
        Pay pay=new Pay();
        pay.setCost(cost);
        pay.setPayDate(new Date());
        pay.setPayWay(0);
        Map map=new HashMap();
        if(service.ccAddPay(pay)>0){
            if(service.ccUpdateState(cost.getCostId())>0){
                map.put("tf","true");
                return map;
            }
        }
        map.put("tf","缴费失败");
        return map;
    }

    /**
     * 查询缴费记录
     * @param userName
     * @param userPhonenumber
     * @return
     */
    @RequestMapping("/getPay")
    @ResponseBody
    public Map getPay(String userName,String userPhonenumber,int page,int limit){
        Map args=new HashMap();
        if(userName==null||userName==""){
            args.put("userName",null);
        }else {
            args.put("userName","'"+userName+"'");
        }  if(userPhonenumber==""||userPhonenumber==null){
            args.put("userPhonenumber",null);
        }else {
            args.put("userPhonenumber","'"+userPhonenumber+"'");
        }
        args.put("page",page);
        args.put("limits",limit);
        int rows=0;
        args.put("rows",rows);
        List<Pay> pays = service.ccGetPayAll(args);
        Map layMap=new HashMap();
        List maps=new ArrayList();
        for (Pay pay : pays) {
            Map map=new HashMap();
            map.put("costId",pay.getCost().getCostId());
            map.put("sum",Integer.parseInt(pay.getCost().getCostPower())+Integer.parseInt(pay.getCost().getCostAir())+Integer.parseInt(pay.getCost().getCostGas())+Integer.parseInt(pay.getCost().getCostOther())+Integer.parseInt(pay.getCost().getCostWater()));
            map.put("userName",pay.getCost().getUser().getUserName());
            map.put("payDate",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pay.getPayDate()));
            if(pay.getPayWay()==0){
                map.put("payWay","线下支付");
            }else {
                map.put("payWay","在线支付");
            }
            maps.add(map);
        }
        layMap.put("code",0);
        layMap.put("msg","");
        layMap.put("count",args.get("rows"));
        layMap.put("data",maps);
        return layMap;
    }

}
