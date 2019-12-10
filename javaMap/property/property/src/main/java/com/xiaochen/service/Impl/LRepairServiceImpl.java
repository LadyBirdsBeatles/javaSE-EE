package com.xiaochen.service.Impl;

import com.xiaochen.mapper.RepairMapper;
import com.xiaochen.mapper.ReplyMapper;
import com.xiaochen.pojo.Repair;
import com.xiaochen.pojo.Reply;
import com.xiaochen.service.LRepairService;
import com.xiaochen.util.Tojsons;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("LReplyService")
public class LRepairServiceImpl implements LRepairService {

    @Autowired
    private RepairMapper repairMapper;

    @Autowired
    ReplyMapper replyMapper;

    @Override
    public int deleteByPrimaryKey(Integer repairId) {
        return repairMapper.deleteByPrimaryKey(repairId);
    }

    /*添加报修*/
    @Override
    public int insert(Repair record) {
        return repairMapper.insert(record);
    }

    @Override
    public int insertSelective(Repair record) {
        return 0;
    }

    @Override
    public Repair selectByPrimaryKey(Integer repairId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Repair record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Repair record) {
        return 0;
    }

    /*未处理*/
    @Override
    public JSONObject showrepair(int uid) {
        JSONObject jsons;
        List<Repair> showrepair = repairMapper.showrepair(uid);
        List list = new ArrayList();
        for (Repair c : showrepair) {
            Map<String, Object> maps = new HashMap<>();
            maps.put("repairId", c.getRepairId());
            maps.put("repairTitle", c.getRepairTitle());
            maps.put("repairIds", c.getRepairId());
            maps.put("repairDate", new SimpleDateFormat("yyyy-MM-dd").format(c.getRepairDate()));
            maps.put("repairState", c.getRepairState());
            maps.put("repairEva", c.getRepairEva());
            maps.put("repairContent", c.getRepairContent());
            maps.put("userName", c.getUser().getUserName());
           /* maps.put("phoneNumber", c.getUser().getUserPhonenumber());
            maps.put("userDress",c.getUser().getUserDress());
            maps.put("adminName",c.getAdmin().getAdminName());*/
            list.add(maps);
        }
        jsons = Tojsons.layuiJson(list.size(), list);
        return jsons;
    }
    /*
    未处理結果
    */

    @Override
    public Map nopairresult(int uid) {
        Repair c = repairMapper.noReairsResult(uid);
        Map<String, Object> maps = new HashMap<>();
        maps.put("repairId", c.getRepairId());
        maps.put("repairTitle", c.getRepairTitle());
        maps.put("repairContent", c.getRepairContent());
        maps.put("userName", c.getUser().getUserName());
        maps.put("phoneNumber", c.getUser().getUserPhonenumber());
        maps.put("userDress", c.getUser().getUserDress());
        maps.put("repairDate", new SimpleDateFormat("yyyy-MM-dd").format(c.getRepairDate()));
        maps.put("repairState", c.getRepairState());
        maps.put("repairEva", c.getRepairEva());
        if (c.getAdmin() == null) {
            maps.put("adminName", null);
        } else {
            maps.put("adminName", c.getAdmin().getAdminName());
        }

        List hf = new ArrayList();
        for (Reply reply : c.getReply()) {
            Map subhf = new HashMap();
            if (reply.getReplyPerson() == 0) {
                subhf.put("name", c.getUser().getUserName());
            } else {
                subhf.put("name", "客服");
            }
            subhf.put("replyDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(reply.getReplyDate()));
            subhf.put("replyContent", reply.getReplyContent());
            hf.add(subhf);
        }
        maps.put("reply", hf);

        return maps;
    }


    /*以处理*/
    @Override
    public JSONObject pastepair(Map map) {
        JSONObject jsons;
        List<Repair> noepair = repairMapper.noepair(map);
        List list = new ArrayList();
        for (Repair c : noepair) {
            Map<String, Object> maps = new HashMap<>();
            maps.put("repairId", c.getRepairId());
            maps.put("repairEva", c.getRepairEva());
            maps.put("repairDate", new SimpleDateFormat("yyyy-MM-dd").format(c.getRepairDate()));
            maps.put("repairState", c.getRepairState());
            maps.put("repairTitle", c.getRepairTitle());
            maps.put("repairIds", c.getRepairId());
            list.add(maps);
        }
        jsons = Tojsons.layuiJson((int)map.get("rowis"), list);
        return jsons;
    }

    /**
     * 已处理結果回复
     *
     * @param uid
     */
    @Override
    public Map psatpairresult(int uid) {
        Repair c = repairMapper.pastReairsResult(uid);
        Map<String, Object> maps = new HashMap<>();
        maps.put("repairId", c.getRepairId());
        maps.put("repairTitle", c.getRepairTitle());
        maps.put("userDress", c.getUser().getUserDress());
        maps.put("repairDate", new SimpleDateFormat("yyyy-MM-dd").format(c.getRepairDate()));
        maps.put("repairState", c.getRepairState());
        maps.put("repairEva", c.getRepairEva());
        if (c.getUser() == null) {
            maps.put("repairContent", null);
            maps.put("userName", null);
            maps.put("phoneNumber", null);
        } else {
            maps.put("repairContent", c.getRepairContent());
            maps.put("userName", c.getUser().getUserName());
            maps.put("phoneNumber", c.getUser().getUserPhonenumber());
        }

        if (c.getAdmin() == null) {
            maps.put("adminName", null);
        } else {
            maps.put("adminName", c.getAdmin().getAdminName());
        }

        List hf = new ArrayList();
        for (Reply reply : c.getReply()) {
            Map subhf = new HashMap();
            if (reply.getReplyPerson() == 0) {
                subhf.put("name", c.getUser().getUserName());
            } else {
                subhf.put("name", "客服");
            }
            subhf.put("replyDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(reply.getReplyDate()));
            subhf.put("replyContent", reply.getReplyContent());
            hf.add(subhf);
        }
        maps.put("reply", hf);

        return maps;
    }

    @Override
    public int clInsert(Reply record) {
        return replyMapper.clInsert(record);
    }

    /*报修评价*/
    @Override
    public int updateestimate(Repair record) {
        return repairMapper.updateByPrimaryKeySelective(record);
    }

}
