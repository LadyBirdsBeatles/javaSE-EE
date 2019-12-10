package com.xiaochen.controller;


import com.xiaochen.pojo.Admin;
import com.xiaochen.pojo.User;
import com.xiaochen.service.AdminService;
import com.xiaochen.service.UserService;
import com.xiaochen.shiro.UsernamePasswordByUserTypeToken;
import com.xiaochen.util.SendSms;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final AdminService adminService;

    @Autowired
    public UserController(UserService userService, AdminService adminService) {
        System.out.println("--------------------------UserController构造函数");
        this.userService = userService;
        this.adminService = adminService;
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public Map loginUser(@RequestParam String username, @RequestParam String password, @RequestParam String type) {
        System.out.println("UserController ------username=" + username);
        System.out.println("UserController ------password=" + password);
        Map map = new HashMap<>();
        Subject currentUser = SecurityUtils.getSubject(); // shiro权限认证主体对象
        System.out.println(currentUser.isAuthenticated());
        if (!currentUser.isAuthenticated()) {//判断是否已登陆
            UsernamePasswordToken upTypeToken = new UsernamePasswordByUserTypeToken(username, password, type);
//          UsernamePasswordToken upToken = new UsernamePasswordToken(username, password);// shiro权限认证类型，未登录，将用户名密码封装成tonken
            upTypeToken.setRememberMe(true);// 用户登录时效性
            try {
                currentUser.login(upTypeToken);    // 调用realm认证用户权限

                Object principal = currentUser.getPrincipal();
                boolean resoult = principal instanceof Admin;
                if (resoult){
                    Admin test = (Admin) principal;
                    if (test.getAdminPower() == 0){
                        map.put("returncode", 1);
                    }else if (test.getAdminPower() == 1){
                        map.put("returncode", 2);//普通管理员
                    }else {
                        map.put("returncode", 3);
                    }

                }else {
                    map.put("returncode", 0);
                }

                map.put("msg", "登陆成功");
                Session session = currentUser.getSession();
                session.setAttribute("loginman", principal);
                System.out.println("拿到的对象" + principal);
                List list = new ArrayList();
                map.put("data", principal);
                return map;
            } catch (IncorrectCredentialsException ice) {
                map.put("msg", "用户名/密码不匹配！");
                map.put("returncode", -1);
                System.out.println("用户名/密码不匹配！");
                return map;
            } catch (LockedAccountException lae) {
                map.put("msg", "账户已被冻结！");
                map.put("returncode", -1);
                System.out.println("账户已被冻结！");
                return map;
            } catch (UnknownAccountException uae) {
                map.put("msg", "账户不存在");
                map.put("returncode", -1);
                System.out.println("账户不存在");
                return map;
            } catch (AuthenticationException ae) {
                map.put("msg", "未知异常");
                map.put("returncode", -1);
                System.out.println(ae.getMessage());
                return map;
            }
        }
        return map;
    }

    @RequestMapping(value = "/findpwd")
    @ResponseBody
    public Map findpwd(@RequestParam String phonenumber1, @RequestParam String phonenumber2,@RequestParam String sendmsm,HttpServletRequest request) {
        Map map = new HashMap<>();
        System.out.println("拿到的电话1" + phonenumber1 + "电话2" + phonenumber2+"拿到的验证码"+sendmsm);
        if (phonenumber1.equals(phonenumber2)) {
            String yzm = (String) request.getSession().getAttribute("yzm");
            if (yzm.equals(sendmsm)){
                User userByphone = userService.getUserByphone(phonenumber1);
                System.out.println("返回的对象=="+userByphone);
                if (userByphone != null){
                    userByphone.setUserPassword(md5(userByphone.getUserName(),phonenumber1));
                    int i = userService.updateByPrimaryKeySelective(userByphone);
                    System.out.println("更新密码后的返回值："+i);
                    map.put("msg","密码已成功重置为手机号码！");
                    map.put("returncode", 1);
                }else {
                    Admin admin = new Admin();
                    admin.setAdminPhoneNumber(phonenumber1);
                    System.out.println("注入的admin对象"+admin);
                    admin = adminService.loginAdmin(admin);
                    System.out.println("调用loginAdmin后拿到的对象："+admin);
                    if (admin != null ){
                        admin.setAdminPassword(md5(admin.getAdminName(),phonenumber1));
                        int i = adminService.updateByPrimaryKeySelective(admin);
                        System.out.println("更新密码后的返回对象："+admin);
                        System.out.println("更新密码结果："+i);
                        map.put("msg","密码已成功重置为手机号码！");
                        map.put("returncode", 1);
                    }else {
                        System.out.println("未找到该手机号对应的用户");
                        map.put("msg","找回失败，确认手机号码");
                        map.put("returncode", -1);
                    }

                }
            }else {
                System.out.println("验证码输入不正确");
                map.put("msg","找回失败，验证码不正确");
                map.put("returncode", -1);
            }
        }
        return map;
    }

    @RequestMapping(value = "/sendmsm")
    @ResponseBody
    public Map sendmsm(@RequestParam String phonenumber1, @RequestParam String phonenumber2, HttpServletRequest request) {
        Map map = new HashMap<>();
        System.out.println("拿到的电话1" + phonenumber1 + "电话2" + phonenumber2);
        if (phonenumber1.equals(phonenumber2)){
            String code = SendSms.sendmsm(phonenumber1);
            HttpSession session = request.getSession();
            session.setAttribute("yzm",code);
            map.put("msg","验证码已发送,请注意查收！");
            map.put("returncode", 1);
        } else {
            map.put("msg","两次输入手机号码不一致！");
            map.put("yzm","失败");
            map.put("returncode", -1);
        }

        return map;
    }
    /*@RequestMapping(value = "/reg")
    public String regUser(@RequestParam String username, @RequestParam String password) {
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        userService.regUser(username, md5(username, password));
        return "redirect:/login.html";
    }*/

    // 注册时，进行shiro加密，返回加密后的结果，如果在加入shiro之前，存在用户密码不是此方式加密的，那么将无法登录
    // 使用用户名作为盐值
    private String md5(String username, String password) {
        String hashAlgorithmName = "MD5";                   // 加密方式
        ByteSource salt = ByteSource.Util.bytes(username);  // 以账号作为盐值
        int hashIterations = 11;                            // 加密11次
        return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
    }
}
