package com.xiaochen.controller;

import com.xiaochen.pojo.User;
import com.xiaochen.service.CCUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ccUser")
public class CCUserController {

    @Autowired
    CCUserService service;


    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/ccAdd")
    @ResponseBody
    public Map add(@RequestBody User user) {
        Map map = new HashMap();

        map.put("userPhoneNumber",user.getUserPhonenumber());
        if(service.ccSelectByUser(user)!=null){
            map.put("tf","该手机号已被注册,如果不是机主本人注册,请联系物业相关人员处理");
            return map;
        }
        user.setUserAuth(3);
        user.setUserType(0);
        user.setUserPassword(md5(user.getUserName(),user.getUserPassword()));
        System.out.println(user);

        if (service.ccAdd(user) > 0) {
            map.put("tf", "true");
        } else {
            map.put("tf", "添加失败");
        }
        return map;
    }

    /**
     * 查询业主用户
     *
     * @param page
     * @param limit
     * @param userName
     * @return
     */
    @RequestMapping("/ccGetAll")
    @ResponseBody
    public Map getAll(int page, int limit, String userName) {
        Map args = new HashMap();
        Map layMap = new HashMap();
        if (userName == null || userName == "") {
            args.put("userName", null);
        } else {
            args.put("userName", "'"+userName+"'");
        }
        args.put("page", page);
        args.put("limits", limit);
        int rows=0;
        args.put("rows",rows);
        List<User> users = service.ccGetAll(args);
        layMap.put("code", 0);
        layMap.put("msg", "");
        layMap.put("count", args.get("rows"));
        layMap.put("data", users);
        return layMap;
    }

    /**
     * 修改业主账户
     * @param user
     * @return
     */
    @RequestMapping("/ccUpdate")
    @ResponseBody
    public Map update(@RequestBody User user) {
        Map map = new HashMap();
        if (service.ccUpdate(user) > 0) {
            map.put("tf", "true");
        } else {
            map.put("tf", "修改失败");
        }
        return map;
    }


    /**
     * 删除业主账户
     * @param list
     * @return
     */
    @RequestMapping("/ccDelete")
    @ResponseBody
    public Map delet(@RequestParam(value = "list") Integer []list){
        System.out.println(list);
        List l= Arrays.asList(list);

        Map map=new HashMap();
        if(service.ccDelete(l)>0){
            map.put("tf","true");

        }else {
            map.put("tf","删除失败");
        }
        return map;
    }


    /**
     * 加密工具
     * @param username
     * @param password
     * @return
     */
    private String md5(String username, String password) {
        String hashAlgorithmName = "MD5";                   // 加密方式
        ByteSource salt = ByteSource.Util.bytes(username);  // 以账号作为盐值
        int hashIterations = 11;                            // 加密11次
        return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
    }
}