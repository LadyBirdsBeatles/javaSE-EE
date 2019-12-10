package com.itoyokado.cms.dao.impl;

import com.itoyokado.cms.dao.GoodsDao;
import com.itoyokado.cms.entity.Buy_Goods;
import com.itoyokado.cms.entity.Goods;
import com.itoyokado.cms.entity.Waybill;
import com.itoyokado.cms.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;

public class GoodsDaoImpl implements GoodsDao {
    QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
    @Override
    public Boolean addGoods(Goods goods) throws Exception {
        String sql = "insert into goods values(null,?,?,?)";
        runner.update(sql,goods.getCategory_id(),goods.getGoods_weight(),goods.getGoods_name());
        return true;
    }

    @Override
    public Boolean addBuy_Goods(Buy_Goods goods) throws Exception {
        String sql = "insert into buy_goods values(null,?,?,?,?,?)";
        Object[] params ={
                goods.getGoods_id(),
                goods.getCategory_id(),
                goods.getGoods_name(),
                goods.getGoods_weight(),
                goods.getWaybill_id(),
        };
        runner.update(sql,params);

        return true;
    }
}
