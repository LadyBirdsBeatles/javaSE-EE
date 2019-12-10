package com.xiaochen.service.Impl;

import com.xiaochen.mapper.AppealMapper;
import com.xiaochen.mapper.ReplyMapper;
import com.xiaochen.pojo.Appeal;
import com.xiaochen.pojo.Reply;
import com.xiaochen.service.LAppealService;
import com.xiaochen.util.Tojsons;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("LAppealService")
public class LAppealServiceImpl implements LAppealService {
    @Autowired
    AppealMapper appealMapper;

    @Autowired
    ReplyMapper replyMapper;

    @Override
    public int deleteByPrimaryKey(Integer appealId) {
        return 0;
    }

    /*添加投诉*/
    @Override
    public int insert(Appeal record) {

        return appealMapper.insert(record);
    }

    /**
     * 未处理投诉
     *
     * @param id
     * @return
     */
    @Override
    public JSONObject nocomplain(int id) {
        JSONObject jsons;
        List<Appeal> nocomplain = appealMapper.nocomplain(id);
        List list = new ArrayList();
        for (Appeal c : nocomplain) {
            Map<String, Object> maps = new HashMap<>();
            maps.put("appealId", c.getAppealId());
            maps.put("appealTitle", c.getAppealTitle());
            maps.put("appealDate", new SimpleDateFormat("yyyy-MM-dd").format(c.getAppealDate()));
            maps.put("appealState", c.getAppealState());
            list.add(maps);
        }
        jsons = Tojsons.layuiJson(list.size(), list);
        return jsons;

    }

    /**
     * 已处理投诉
     *
     * @param id
     * @return
     */
    @Override
    public JSONObject pastcomplain(Map map) {
        JSONObject jsons;
        List<Appeal> pastcomplain = appealMapper.pastcomplain(map);
        List list = new ArrayList();
        for (Appeal c : pastcomplain) {
            Map<String, Object> maps = new HashMap<>();
            maps.put("appealDate", new SimpleDateFormat("yyyy-MM-dd").format(c.getAppealDate()));
            maps.put("appealState", c.getAppealState());
            maps.put("appealId", c.getAppealId());
            maps.put("appealTitle", c.getAppealTitle());
            list.add(maps);
        }
        jsons = Tojsons.layuiJson((int)map.get("rowis"), list);
        return jsons;
    }

    @Override
    public int insertSelective(Appeal record) {
        return appealMapper.insert(record);
    }

    @Override
    public Appeal selectByPrimaryKey(Integer appealId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Appeal record) {
        return appealMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Appeal record) {
        return 0;
    }

    /**
     * 未处理的回复
     *
     * @param id
     * @return
     */
    @Override
    public Map nocomplainresult(int id) {
        Map<String, Object> maps = new HashMap<>();
        Appeal appeal = appealMapper.nocomplainresult(id);
        maps.put("appealDate", new SimpleDateFormat("yyyy-MM-dd").format(appeal.getAppealDate()));
        maps.put("appealState", appeal.getAppealState());
        maps.put("appealId", appeal.getAppealId());
        maps.put("appealTitle", appeal.getAppealTitle());
        maps.put("appealContent", appeal.getAppealContent());
        maps.put("appealEva", appeal.getAppealEva());
        if (appeal.getAdmin() == null) {
            maps.put("adminName", null);
        } else {
            maps.put("adminName", appeal.getAdmin().getAdminName());
        }
        maps.put("userName", appeal.getUser().getUserName());
        maps.put("userDress", appeal.getUser().getUserDress());
        List hf = new ArrayList();
        for (Reply reply : appeal.getReply()) {
            Map subhf = new HashMap();
            if (reply.getReplyPerson() == 0) {
                subhf.put("name", appeal.getUser().getUserName());
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

    /**
     * 以处理的回复结果
     *
     * @param id
     * @return
     */
    @Override
    public Map pastcomplainresult(int id) {
        Map<String, Object> maps = new HashMap<>();
        Appeal appeal = appealMapper.pastcomplainresult(id);
        maps.put("appealDate", new SimpleDateFormat("yyyy-MM-dd").format(appeal.getAppealDate()));
        maps.put("appealId", appeal.getAppealId());
        maps.put("appealTitle", appeal.getAppealTitle());
        maps.put("appealContent", appeal.getAppealContent());
        maps.put("appealEva", appeal.getAppealEva());
        maps.put("appealState", appeal.getAppealState());
        maps.put("adminName", appeal.getAdmin().getAdminName());
        maps.put("userName", appeal.getUser().getUserName());
        maps.put("userDress", appeal.getUser().getUserDress());
        List hf = new ArrayList();
        for (Reply reply : appeal.getReply()) {
            Map subhf = new HashMap();
            if (reply.getReplyPerson() == 0) {
                subhf.put("name", appeal.getUser().getUserName());
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

    /**
     * 添加回复
     * @param record
     * @return
     */
    @Override
    public int cflInsert(Reply record) {
        return replyMapper.cflInsert(record);
    }

    /**
     *  添加评价
     * @param appeal
     * @return
     */
    @Override
    public int updatestateappeal(Appeal appeal) {
        return appealMapper.updateByPrimaryKeySelective(appeal);
    }
}
