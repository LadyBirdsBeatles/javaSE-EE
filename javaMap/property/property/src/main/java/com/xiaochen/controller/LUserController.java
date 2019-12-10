package com.xiaochen.controller;


import com.xiaochen.pojo.User;
import com.xiaochen.service.LUserService;
import com.xiaochen.util.Tojsons;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LUserController {
    @Autowired
    private LUserService lUserService;

    @RequestMapping("/touser")
    @ResponseBody
    public JSONObject getUserList(int page,int limit) {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        User userSession = (User) session.getAttribute("loginman");

        Map map = new HashMap();
        int rowis = 0;
        map.put("uid", userSession.getUserId());
        map.put("page", page);
        map.put("limits",limit);
        map.put("rowis", rowis);
        List<User> selectuser = lUserService.selectuser(map);
        JSONObject jsonObject = Tojsons.layuiJson((int)map.get("rowis"), selectuser);
        return jsonObject;
    }

    private String md5(String username, String password) {
        String hashAlgorithmName = "MD5";                   // 加密方式
        ByteSource salt = ByteSource.Util.bytes(username);  // 以账号作为盐值
        int hashIterations = 11;                            // 加密11次
        return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
    }

    @RequestMapping("/amendpwd")
    @ResponseBody
    public Map amendUsepwd(Integer userId, String userName, String newPassword) {
        User user = new User();
        user.setUserId(userId);
        user.setUserPassword(md5(userName, newPassword));
        JSONObject map = new JSONObject();
        if (lUserService.updateByPrimaryKeySelective(user) > 0) {
            map.put("msg", "修改成功~");
        } else {
            map.put("msg", "修改失败~");
        }
        return map;
    }
}
