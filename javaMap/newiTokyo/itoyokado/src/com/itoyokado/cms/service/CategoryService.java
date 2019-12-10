package com.itoyokado.cms.service;

import com.itoyokado.cms.entity.Goods_Category;
import com.itoyokado.cms.entity.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService {
    PageBean findCateBypageAndlimit(int page, int limit, String name) throws SQLException;

    int updatStatu(int id, String statu) throws SQLException;

    List<Goods_Category> findParentCate() throws SQLException;

    Boolean addCateByparentId(int parent_id, String category_name) throws SQLException;
}
