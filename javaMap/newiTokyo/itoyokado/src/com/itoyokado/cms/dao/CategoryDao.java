package com.itoyokado.cms.dao;

import com.itoyokado.cms.entity.Goods_Category;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CategoryDao {
    int findCateCount() throws SQLException;

    List<Map<String,Object>> findCateByPageAndlimit(int page, int limit, String name) throws SQLException;

    int updateStatu(int id, String statu) throws SQLException;

    int findCateCount(String name) throws SQLException;

    List<Goods_Category> findParentCate() throws SQLException;

    int addCateByparentId(int parent_id, String category_name) throws SQLException;
}
