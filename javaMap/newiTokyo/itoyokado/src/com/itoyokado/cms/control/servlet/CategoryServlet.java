package com.itoyokado.cms.control.servlet;

import com.itoyokado.cms.control.base.BaseServlet;
import com.itoyokado.cms.entity.Goods_Category;
import com.itoyokado.cms.entity.PageBean;
import com.itoyokado.cms.service.CategoryService;
import com.itoyokado.cms.service.impl.CategoryServiceImpl;
import com.itoyokado.cms.util.PageJsonUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet{

    // 默认方法
    public String findCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        //当前页
        int page = Integer.parseInt(request.getParameter("page"));
        //每页数据条数
        int limit = Integer.parseInt(request.getParameter("limit"));
        //搜索内容
        String name = request.getParameter("name");
        System.out.println(page+"\t"+limit+"\t"+name);

        CategoryService categoryService = new CategoryServiceImpl();
        PageBean pageBean = null;
            //为空
            pageBean = categoryService.findCateBypageAndlimit(page,limit,name);
        JSONArray jsonArray = JSONArray.fromObject(pageBean.getList());
        JSONObject json = PageJsonUtil.pageJson(200, "", pageBean.getTotalSize(), jsonArray);
        System.out.println(json);
        // 设置类型以及编码
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(json);
        return null;
    }

    // 默认方法
    public String hideCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        String statu = request.getParameter("statu");
        System.out.println("分类的状态:"+id+"\t"+statu);

        CategoryService categoryService = new CategoryServiceImpl();
        int row = categoryService.updatStatu(id,statu);
        Boolean status = false;
        if (row > 0){
            status = true;
        }
        response.getWriter().print(status);
        return null;
    }

    public String findParentCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
        CategoryService categoryService = new CategoryServiceImpl();
        List<Goods_Category> list = categoryService.findParentCate();
        JSONArray jsonArray = JSONArray.fromObject(list);
        response.getWriter().print(jsonArray);
        return null;
    }
    // 默认方法
    public String addCate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
        int parent_id = Integer.parseInt(req.getParameter("parent_id"));
        String category_name = req.getParameter("category_name");
        CategoryService categoryService = new CategoryServiceImpl();
        Boolean s = categoryService.addCateByparentId(parent_id,category_name);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stat",s);
        resp.getWriter().print(jsonObject);
        return null;
    }

    // 添加父分类
    public String addParentCate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
        String category_name = req.getParameter("category_name");
        CategoryService categoryService = new CategoryServiceImpl();
        //调用添加分类的方法 0为父分类的parentid 是默认的
        Boolean s = categoryService.addCateByparentId(0,category_name);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stat",s);
        resp.getWriter().print(jsonObject);
        return null;
    }

}
