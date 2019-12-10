package com.xiaochen.service;


import net.sf.json.JSONObject;

import java.util.Map;

public interface LaliPayService {
    int insert(int costid);

    /**
     * 账单
     *
     * @return
     */
    JSONObject SelectAccountPay(Map map);
}
