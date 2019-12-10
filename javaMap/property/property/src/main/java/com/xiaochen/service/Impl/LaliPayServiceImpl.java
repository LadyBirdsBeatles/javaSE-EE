package com.xiaochen.service.Impl;

import com.xiaochen.mapper.PayMapper;
import com.xiaochen.pojo.Cost;
import com.xiaochen.pojo.Pay;
import com.xiaochen.service.LaliPayService;
import com.xiaochen.util.Tojsons;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service("LaliPayService")
public class LaliPayServiceImpl implements LaliPayService {
    @Autowired
    PayMapper payMapper;
    Pay pay =new Pay();

    Cost cost =new Cost();
    @Override
    public int insert(int costid) {
        pay.setPayDate(new Date());
        pay.setPayWay(1);
        cost.setCostId(costid);
        pay.setCost(cost);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pay.getPayDate()));
        return payMapper.insert(pay);
    }
    @Override
    public JSONObject SelectAccountPay(Map map) {
        List<Pay> pays = payMapper.clSelectAccontPays(map);
        JSONObject jsons;
        Integer a = 0;
        List list = new ArrayList();
        for (Pay c : pays) {
            Map<String, Object> maps = new HashMap<>();
            maps.put("userId", c.getCost().getUser().getUserId());
            maps.put("costId", c.getCost().getCostId());
            maps.put("userName", c.getCost().getUser().getUserName());
            maps.put("userSize", c.getCost().getUser().getUserSize());
            maps.put("userPhonenumber", c.getCost().getUser().getUserPhonenumber());
            maps.put("userDress", c.getCost().getUser().getUserDress());
            maps.put("userType", c.getCost().getUser().getUserType());
            /*费用类型*/
            maps.put("costType", "水费-电费-燃气费-空调费-其他费用");
            maps.put("costPower", c.getCost().getCostPower());
            maps.put("costAir", c.getCost().getCostAir());
            maps.put("costOther", c.getCost().getCostOther());
            maps.put("costDate", new SimpleDateFormat("yyyy-MM-dd").format(c.getCost().getCostDate()));
            maps.put("costStates", c.getCost().getCostState());
            maps.put("costState", "是");
            maps.put("costWtate", c.getCost().getCostWater());
            maps.put("costGas", c.getCost().getCostGas());
            a = Integer.parseInt(c.getCost().getCostAir()) + Integer.parseInt(c.getCost().getCostWater()) + Integer.parseInt(c.getCost().getCostGas()) + Integer.parseInt(c.getCost().getCostOther()) + Integer.parseInt(c.getCost().getCostPower());
            maps.put("sumCost", a);
            maps.put("payDate", new SimpleDateFormat("yyyy-MM-dd").format(c.getPayDate()));
            maps.put("payWay", c.getPayWay());
            list.add(maps);
        }
        int rows =(int )map.get("rows");
        jsons = Tojsons.layuiJson(rows, list);
        return jsons;
    }
}
