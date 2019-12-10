package com.xiaochen.service.Impl;

import com.xiaochen.mapper.MsgMapper;
import com.xiaochen.pojo.Msg;
import com.xiaochen.service.LMsgService;
import com.xiaochen.util.Tojsons;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("LMsgService")
public class LMsgServiceImpl implements LMsgService {
    @Autowired
    private MsgMapper msgMapper;

    @Override
    public int deleteByPrimaryKey(Integer msgId) {
        return 0;
    }

    @Override
    public int insert(Msg record) {
        return 0;
    }

    @Override
    public int insertSelective(Msg record) {
        return 0;
    }

    @Override
    public Msg selectByPrimaryKey(Integer msgId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Msg record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Msg record) {
        return 0;
    }

    @Override
    public JSONObject showmsg(Map map) {
        List<Msg> showmsg = msgMapper.showmsg(map);
        JSONObject jsons;
        List list = new ArrayList();
        for (Msg c : showmsg) {
            Map<String, Object> maps = new HashMap<>();
            maps.put("msgId", c.getMsgId());
            maps.put("msgTitle", c.getMsgTitle());
            maps.put("msgPartstarttime", new SimpleDateFormat("yyyy-MM-dd").format(c.getMsgPartstarttime()));
            maps.put("msgClass", c.getMsgClass());
            maps.put("msgOther1", c.getMsgOther1());
            maps.put("msgOther2", c.getMsgOther2());
            maps.put("msgOther3", c.getMsgOther3());
            list.add(maps);
        }
        jsons = Tojsons.layuiJson((int)map.get("rows"), list);
        return jsons;

    }
}