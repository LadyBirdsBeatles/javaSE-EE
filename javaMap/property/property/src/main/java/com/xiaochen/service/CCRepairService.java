package com.xiaochen.service;

import com.xiaochen.pojo.Admin;
import com.xiaochen.pojo.Repair;
import com.xiaochen.pojo.Reply;

import java.util.List;
import java.util.Map;

public interface CCRepairService {
    /**
     * 按id查询报修表
     * @param id
     * @return
     */
    public Repair getRepair(int id);

    /**
     * 查询所有报修表
     * @param map
     * @return
     */
   public List<Repair> ccGetRepairAll(Map map);

    /**
     * 查询所有维修人员
     * @return
     */
   public List<Admin> ccGetAdminAll();

    /**
     * 修改报修表维修人员
     * @param map
     * @return
     */
    int ccUpdateAdmin(Map map);

    /**
     * 插入回复内容
     * @param reply
     * @return
     */
    public int ccInsert(Reply reply);

    /**
     * 修改报修表状态
     * @param repair
     * @return
     */
    int ccUpdateState(Repair repair);
}
