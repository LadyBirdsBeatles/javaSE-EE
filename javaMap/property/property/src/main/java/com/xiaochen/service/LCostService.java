package com.xiaochen.service;
import net.sf.json.JSONObject;

import java.util.Map;

public interface LCostService {
    public JSONObject selectcostlist(Map map);
    /*缴费成功的账单*/
    public JSONObject selectcostsuccess(int id);

    /*缴费状态*/
    public int updateCostState(int id);
}
