package com.itoyokado.cms.serverlet;

import com.itoyokado.cms.entity.Sys_User;
import com.itoyokado.cms.service.SysUserService;
import com.itoyokado.cms.service.impl.SysUserServiceImpl;
import com.itoyokado.cms.util.JsonUtil;
import com.itoyokado.cms.util.MD5Creater;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进post");
        if ("login".equals(request.getParameter("func"))) {
            System.out.println("进判断了");
            this.loginresult(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void loginresult(HttpServletRequest request, HttpServletResponse response) {
        Date date = new Date();
        String loginname = request.getParameter("username");
        String password = request.getParameter("password");//66666
        password = MD5Creater.getMD5(password);//MD5(66666)
        //获取IP地址
        String login_IpAddr = this.getClientIp(request);
        Sys_User sys_user_login = new Sys_User();
        sys_user_login.setS_name(loginname);
        sys_user_login.setS_password(password);
        sys_user_login.setLast_login_date(date);
        sys_user_login.setLast_login_ip(login_IpAddr);
        SysUserService sysUserService = new SysUserServiceImpl();
        try {
            Sys_User sys_userFind = sysUserService.loginSysUser(sys_user_login);
            if (Objects.isNull(sys_userFind)) {
                System.out.println("账号不存在或密码错误");
                JsonUtil.response(response, 400, "账号或密码错误", null);
            } else {
                System.out.println("登陆成功");
                //存储Session
                HttpSession session = request.getSession();
                session.setAttribute("userClass",sys_userFind );
                //成功后,更新登陆时间,
                LoginServlet.successLogin(sys_user_login, sysUserService);
                Integer type = sys_userFind.getType();
                if (type == 1){
                    JsonUtil.response(response, 1, "录入人员,登陆成功", null);
                }else if (type == 2){
                    JsonUtil.response(response, 2, "配送人员,登陆成功", null);
                }else if (type == -1){
                    JsonUtil.response(response, -1, "管理员,登陆成功", null);
                }else {
                    JsonUtil.response(response, 0, "客服人员,登陆成功", null);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //更新登陆时间,
    private static void successLogin(Sys_User sys_user, SysUserService sysUserService) {
        try {
            sysUserService.updateMsg(sys_user);
            System.out.println("信息更新成功!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("信息更新异常!");
        }
    }

    //获取用户真实IP的方法
    private String getClientIp(HttpServletRequest request) {
        //X-Forwarded-For，不区分大小写
        String possibleIpStr = request.getHeader("X-Forwarded-For");
        String remoteIp = request.getRemoteAddr();
        String clientIp;
        if (StringUtils.isNotBlank(possibleIpStr) && !"unknown".equalsIgnoreCase(possibleIpStr)) {
            //可能经过好几个转发流程，第一个是用户的真实ip，后面的是转发服务器的ip
            clientIp = possibleIpStr.split(",")[0].trim();
        } else {
            //如果转发头ip为空，说明是直接访问的，没有经过转发
            clientIp = remoteIp;
        }
        return clientIp;
    }
}
