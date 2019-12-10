package com.xiaochen.service.Impl;

import com.xiaochen.mapper.CostMapper;
import com.xiaochen.pojo.Cost;
import com.xiaochen.service.LCostService;
import com.xiaochen.util.Tojsons;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("LCostService")
public class LCostServiceImpl implements LCostService {
    @Autowired
    private CostMapper costMapper;


    @Override
    public JSONObject selectcostlist(Map map) {
        List<Cost> selectcostlist = costMapper.selectcostlist(map);
        JSONObject jsons;
        Integer a = 0;
        List list = new ArrayList();
        for (Cost c : selectcostlist) {
            Map<String, Object> maps = new HashMap<>();
            maps.put("userId", c.getUser().getUserId());
            maps.put("userName", c.getUser().getUserName());
            maps.put("userPhonenumber", c.getUser().getUserPhonenumber());
            maps.put("userDress", c.getUser().getUserDress());
            maps.put("userSize", c.getUser().getUserSize());
            maps.put("userType", c.getUser().getUserType());
            maps.put("costId", c.getCostId());
            /*费用类型*/
            maps.put("costType", "水费-电费-燃气费-空调费-其他费用");
            maps.put("costWtate", c.getCostWater());
            maps.put("costGas", c.getCostGas());
            maps.put("costPower", c.getCostPower());
            maps.put("costAir", c.getCostAir());
            maps.put("costOther", c.getCostOther());
            maps.put("costDate", new SimpleDateFormat("yyyy-MM-dd").format(c.getCostDate()));
           /* maps.put("costState", c.getCostState());*/
            maps.put("costState", "否");
            a = Integer.parseInt(c.getCostAir()) + Integer.parseInt(c.getCostWater()) + Integer.parseInt(c.getCostGas()) + Integer.parseInt(c.getCostOther()) + Integer.parseInt(c.getCostPower());
            maps.put("sumCost", a);
            list.add(maps);
        }
        jsons = Tojsons.layuiJson((int)map.get("rows"), list);
        return jsons;
    }

    @Override
    public JSONObject selectcostsuccess(int id) {
        List<Cost> selectcostsuccess = costMapper.selectcostsuccess(id);
        JSONObject jsons;
        Integer a = 0;
        List list = new ArrayList();
        for (Cost c : selectcostsuccess) {
            Map<String, Object> maps = new HashMap<>();
            maps.put("userId", c.getUser().getUserId());
            maps.put("costId", c.getCostId());
            maps.put("userName", c.getUser().getUserName());
            maps.put("userSize", c.getUser().getUserSize());
            maps.put("userPhonenumber", c.getUser().getUserPhonenumber());
            maps.put("userDress", c.getUser().getUserDress());
            maps.put("userType", c.getUser().getUserType());
            /*费用类型*/
            maps.put("costType", "水费-电费-燃气费-空调费-其他费用");
            maps.put("costPower", c.getCostPower());
            maps.put("costAir", c.getCostAir());
            maps.put("costOther", c.getCostOther());
            maps.put("costDate", new SimpleDateFormat("yyyy-MM-dd").format(c.getCostDate()));
            maps.put("costStates", c.getCostState());
            maps.put("costState", "是");
            maps.put("costWtate", c.getCostWater());
            maps.put("costGas", c.getCostGas());
            a = Integer.parseInt(c.getCostAir()) + Integer.parseInt(c.getCostWater()) + Integer.parseInt(c.getCostGas()) + Integer.parseInt(c.getCostOther()) + Integer.parseInt(c.getCostPower());
            maps.put("sumCost", a);
            list.add(maps);
        }
        jsons = Tojsons.layuiJson(list.size(), list);
        return jsons;
    }

    @Override
    public int updateCostState(int id) {
        Cost cost = new Cost();
        cost.setCostId(id);
        cost.setCostState(1);
        return costMapper.updateByPrimaryKeySelective(cost);
    }

}
