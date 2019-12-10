package com.itoyokado.cms.service.impl;

import com.itoyokado.cms.dao.CategoryDao;
import com.itoyokado.cms.dao.impl.CategoryDaoImpl;
import com.itoyokado.cms.entity.Goods_Category;
import com.itoyokado.cms.entity.PageBean;
import com.itoyokado.cms.service.CategoryService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public PageBean findCateBypageAndlimit(int page, int limit, String name) throws SQLException {
        //封装分页类数据
        PageBean pageBean = new PageBean<>();
        pageBean.setCurrentPage(page);  //设置当前页
        pageBean.setPageSize(limit);         //设置每页显示多少记录

        CategoryDao categoryDao = new CategoryDaoImpl();
        int count = 0;
        if (name != null) {
             count = categoryDao.findCateCount(name);
        }
        count = categoryDao.findCateCount();

        pageBean.setTotalSize(count);   //设置总记录数

        List<Map<String,Object>> list = categoryDao.findCateByPageAndlimit(page,limit,name);
        pageBean.setList(list);         //设置当前页数据
        pageBean.setTotalPage(count % limit == 0 ? count / limit : count / limit + 1);        //设置总页数
        return pageBean;
    }

    @Override
    public int updatStatu(int id, String statu) throws SQLException {
        CategoryDao categoryDao = new CategoryDaoImpl();
        return categoryDao.updateStatu(id,statu);
    }

    @Override
    public List<Goods_Category> findParentCate() throws SQLException {
        CategoryDao categoryDao = new CategoryDaoImpl();
        return categoryDao.findParentCate();
    }

    @Override
    public Boolean addCateByparentId(int parent_id, String category_name) throws SQLException {
        CategoryDao categoryDao = new CategoryDaoImpl();
        int i = categoryDao.addCateByparentId(parent_id,category_name);
        if (i>0){
            return true;
        }
        return false;
    }
}
