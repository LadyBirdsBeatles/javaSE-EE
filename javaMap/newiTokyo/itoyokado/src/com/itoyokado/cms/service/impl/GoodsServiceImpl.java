package com.itoyokado.cms.service.impl;

import com.itoyokado.cms.dao.GoodsDao;
import com.itoyokado.cms.dao.impl.GoodsDaoImpl;
import com.itoyokado.cms.entity.Buy_Goods;
import com.itoyokado.cms.entity.Goods;
import com.itoyokado.cms.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
    @Override
    public Boolean addGoods(Goods goods) throws Exception {
        GoodsDao goodsDao = new GoodsDaoImpl();
        Boolean isAddGoods = goodsDao.addGoods(goods);
        if (isAddGoods){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean addBuy_Goods(Buy_Goods goods) throws Exception {
        GoodsDao goodsDao = new GoodsDaoImpl();
        Boolean isAddGoods = goodsDao.addBuy_Goods(goods);
        if (isAddGoods){
            return true;
        }else{
            return false;
        }
    }
}
