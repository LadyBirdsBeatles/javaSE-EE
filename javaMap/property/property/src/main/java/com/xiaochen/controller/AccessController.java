package com.xiaochen.controller;

import com.xiaochen.pojo.Access;
import com.xiaochen.service.AccessService;
import com.xiaochen.util.CarCardUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/car")
public class AccessController {

    private AccessService accessService;

    @Autowired
    public AccessController(AccessService accessService) {
        this.accessService = accessService;

    }

    @RequestMapping("/jioncar")
    @ResponseBody
    public Map insertAccess() {
        Access access = new Access();
        Map map = new HashMap<>();
        String palte = CarCardUtil.getPalte();
        access.setAccessCarcard(palte);
        access.setAccessStartdate(new Date());
        access.setAccessCost("10");
        access.setAccessOther1("1");
        int i = accessService.insertAccess(access);
        if (i == 1) {
            System.out.println("添加成功");
            map.put("data", "");
            map.put("code", "");
            map.put("count", "");
            map.put("msg", "添加成功");
        } else {
            map.put("data", "");
            map.put("code", "");
            map.put("count", "");
            map.put("msg", "添加失败！");
        }
        return map;
    }


    @RequestMapping("/updatecar")
    @ResponseBody
    public Map updateAccess(Access access) {
        Map map = new HashMap<>();
        System.out.println(access);
        int i = accessService.updateAccess(access);
        if (i == 1) {
            map.put("returncode", 1);
            map.put("msg", "缴费成功！");
        } else {
            map.put("msg", "缴费失败！");
            map.put("returncode", -1);
        }
        return map;
    }

    @RequestMapping("/access")
    @ResponseBody
    public void selectAccessList(HttpServletResponse response, HttpServletRequest request, Access access,Integer page ,Integer limit) {
        System.out.println("查询access列表方法");
        HttpSession session = request.getSession();
        System.out.println("拿到的session：" + session);
        Map map = new HashMap<>();
        System.out.println(access);
//        if (access.getAccessOther1().equals("0")) {
//            access.setAccessOther1(nul
// l);
//        }
        Map maps = new HashMap<>();
        Integer rows = 0;
        maps.put("limits",limit);
        maps.put("page",page);
        maps.put("rows",rows);
        List<Access> accessesList = accessService.selectAccessList(maps);
        map.put("data", accessesList);
        map.put("code", "");
        map.put("count", maps.get("rows"));
        map.put("msg", "");
        JSONObject json = new JSONObject(map);
        response.setCharacterEncoding("utf-8");
        try {
            response.getWriter().write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    List<Access> selectAccess(Access access) {
        return this.selectAccess(access);
    }
}
