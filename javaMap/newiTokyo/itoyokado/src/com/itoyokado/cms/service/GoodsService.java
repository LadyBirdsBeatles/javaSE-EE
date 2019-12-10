package com.itoyokado.cms.service;

import com.itoyokado.cms.entity.Buy_Goods;
import com.itoyokado.cms.entity.Goods;

public interface GoodsService {
    public Boolean addGoods(Goods goods) throws Exception;
    public Boolean addBuy_Goods(Buy_Goods goods) throws Exception;

}
