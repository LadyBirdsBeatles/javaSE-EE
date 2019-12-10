package com.itoyokado.cms.control.servlet;

import com.itoyokado.cms.dao.SysUserDao;
import com.itoyokado.cms.dao.impl.SysUserDaoImpl;
import com.itoyokado.cms.entity.PageBean;
import com.itoyokado.cms.entity.Sys_User;
import com.itoyokado.cms.service.SysUserService;
import com.itoyokado.cms.service.impl.SysUserServiceImpl;
import com.itoyokado.cms.util.JsonDateValueProcessor;
import com.itoyokado.cms.control.base.BaseServlet;
import com.itoyokado.cms.util.RegexUtil;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.*;

@WebServlet("/SysUserServlet")
public class SysUserServlet extends BaseServlet {
    /**
     * 添加系统用户
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     * @throws SQLException
     */
    public String addSysUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        //获取所有参数为一个map集合
        Map<String, String[]> map = request.getParameterMap();
        Sys_User sys_user = new Sys_User();
        try {
            //利用BeanUtils的方法,将map得到的表单数据封装到Sys_User对象中
            BeanUtils.populate(sys_user, map);
            System.out.println(sys_user);
            SysUserService sysUserService = new SysUserServiceImpl();
            //调用添加系统用户方法
            Boolean isAdd = sysUserService.addUser(sys_user);
            response.getWriter().print(isAdd);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询系统用户的方法
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     * @throws SQLException
     */
    public String findSysUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        //当前页
        int page = Integer.parseInt(request.getParameter("page"));
        //每页数据条数
        int limit = Integer.parseInt(request.getParameter("limit"));
        //搜索内容
        String field = request.getParameter("field");
        System.out.println(field);
        SysUserService sysUserService = new SysUserServiceImpl();
        PageBean pageBean = null;
        List<Sys_User> list = null;
        if (StringUtils.isEmpty(field)) {
            //为空
            pageBean = sysUserService.findUserBypageAndlimit(page, limit);
        } else {
            if (RegexUtil.isJob_Number(field)) {
                list = sysUserService.findUserByField("job_number", field);
            } else {
                list =  sysUserService.findUserByField("s_name", field);
            }
            pageBean = new PageBean();
            pageBean.setList(list);
            pageBean.setTotalPage(1);
            pageBean.setTotalSize(1);
            pageBean.setCurrentPage(1);
            pageBean.setPageSize(limit);
        }

        JsonConfig jc = new JsonConfig();
        jc.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        //注册时间转换器
        JSONArray jsonArray = JSONArray.fromObject(pageBean.getList(), jc);

        JSONObject json = new JSONObject();
        JSONObject jsonmain = new JSONObject();
        json.put("item", jsonArray);
        jsonmain.put("status", 200);
        jsonmain.put("message", "");
        jsonmain.put("total", pageBean.getTotalSize());
        jsonmain.put("rows", json);
        System.out.println(jsonmain);
        // 设置类型以及编码
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jsonmain);
        return null;
    }

    public String updateSysUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        int type = Integer.parseInt(request.getParameter("type"));
        String s_password = request.getParameter("s_password");
        SysUserService sysUserService = new SysUserServiceImpl();
        int stat = 0;
        if (StringUtils.isEmpty(s_password)){
            stat = sysUserService.updateSysPower(type,id);
        }else {
            stat = sysUserService.updateSysPowerAndPasswordById(type,s_password,id);
        }
        response.setContentType("application/json;charset=utf-8");
        JSONObject json = new JSONObject();
        if (stat >0){
            json.put("status","true");
        }else {
            json.put("status","false");
        }
        response.getWriter().print(json);
        return null;
    }
}
