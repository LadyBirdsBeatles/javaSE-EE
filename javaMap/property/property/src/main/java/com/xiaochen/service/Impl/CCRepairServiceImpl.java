package com.xiaochen.service.Impl;

import com.xiaochen.mapper.AdminMapper;
import com.xiaochen.mapper.RepairMapper;
import com.xiaochen.mapper.ReplyMapper;
import com.xiaochen.pojo.Admin;
import com.xiaochen.pojo.Repair;
import com.xiaochen.pojo.Reply;
import com.xiaochen.service.CCRepairService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("repairService")
public class CCRepairServiceImpl implements CCRepairService {
    @Resource
    RepairMapper mapper;
    @Resource
    AdminMapper adminMapper;

    @Resource
    ReplyMapper replyMapper;
    @Override
    public Repair getRepair(int id){
      return  mapper.ccSelectById(id);
    }

    @Override
    public List<Repair> ccGetRepairAll(Map map) {
        return mapper.ccSelectAll(map);
    }

    @Override
    public List<Admin> ccGetAdminAll() {
        return adminMapper.ccSelectAllWX();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int ccUpdateAdmin(Map map) {
        return mapper.ccUpdateAdmin(map);
    }

    public int ccInsert(Reply reply){
       return replyMapper.ccInsert(reply);
    }

    @Override
    public int ccUpdateState(Repair repair) {
        return mapper.ccUpdateState(repair);
    }

}
