package com.xiaochen.controller;

import com.xiaochen.pojo.Admin;
import com.xiaochen.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    //员工列表
    @RequestMapping(value = "property/staff")
    @ResponseBody
    public Map OnStaff(Integer adminStatus,HttpServletResponse response,Integer limit,Integer page){
        System.out.println("coming ------------------");
        HashMap<Object, Object> mapPage = new HashMap<>();
        int rows = 0;
        mapPage.put("adminStatus",adminStatus);
        mapPage.put("limits",limit);
        mapPage.put("page",page);
        mapPage.put("rows",rows);
        List<Admin> admins = adminService.selectByStatus(mapPage);
        Map map =new HashMap<>();
        map.put("code","");
        map.put("count",mapPage.get("rows"));
        map.put("data",admins);
        map.put("msg","");

        return map;
    }


    //添加员工
    @RequestMapping(value = "/propertyAdmin/staff/add")
    @ResponseBody
    public void addStaff(@RequestBody Admin admin){
        //System.out.println(admin);
        admin.setAdminStatus(0);
        String pwd = admin.getAdminPassword();
        admin.setAdminPassword(md5(admin.getAdminName(),pwd));
        admin.setAdminDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        //System.out.println(admin);
        int i = adminService.insert(admin);
        //System.out.println(i);
    }

    //修改员工信息(包含离职员工)
    @RequestMapping("/propertyAdmin/staff/update")
    @ResponseBody
    public Integer updateStaff(Admin admin){
        System.out.println(admin);
        int i = adminService.updateByPrimaryKeySelective(admin);
        System.out.println(i);
        return i;
    }


    //修改员工密码
    @RequestMapping("/propertyAdmin/staff/pwd")
    @ResponseBody
    public Map pwdStaff(@RequestParam String oldPwd, @RequestParam String newPwd){
        Map map = new HashMap<>();
        System.out.println(oldPwd+"======="+newPwd);
        //获得未修改的admin对象
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        Admin oldAdmin = (Admin) session.getAttribute("loginman");
        //给oldPwd加密
        String oldMd5 = md5(oldAdmin.getAdminName(),oldPwd);
        System.out.println(oldMd5);
        if (oldMd5.equals(oldAdmin.getAdminPassword())){
            oldAdmin.setAdminPassword(md5(oldAdmin.getAdminName(),newPwd));
            int i = adminService.updateByPrimaryKeySelective(oldAdmin);
            if (i!=0){
                map.put("msg","修改成功");
            }else {
                map.put("msg","修改失败,系统异常！");
            }

        }else{
            map.put("msg","修改失败,旧密码错误!");
        }
        return map;
    }

    private String md5(String username, String password) {
        String hashAlgorithmName = "MD5";                   // 加密方式
        ByteSource salt = ByteSource.Util.bytes(username);  // 以账号作为盐值
        int hashIterations = 11;                            // 加密11次
        return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
    }

}
