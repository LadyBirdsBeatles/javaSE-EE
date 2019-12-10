package com.xiaochen.mapper;

import com.xiaochen.pojo.Repair;

import java.util.List;
import java.util.Map;

public interface RepairMapper {

   /**
    * 按id查询报修表
    * @param id
    * @return
    */
   Repair ccSelectById(int id);

   /**
    * 查询所有报修表
    * @param map
    * @return
    */
   List<Repair> ccSelectAll(Map map);

   /**
    * 修改报修表维修人员
    * @param map
    * @return
    */
   int ccUpdateAdmin(Map map);

   /**
    * 修改报修表状态
    * @param repair
    * @return
    */
   int ccUpdateState(Repair repair);
   int deleteByPrimaryKey(Integer repairId);

   int insert(Repair record);

   int insertSelective(Repair record);

   Repair selectByPrimaryKey(Integer repairId);

   int updateByPrimaryKeySelective(Repair record);

   int updateByPrimaryKey(Repair record);

   /*未处理*/
   List<Repair> showrepair(int uid);

   /*以处理*/
   List<Repair> noepair(Map map);

   List<Repair> shows();

   /*
    *未处理回复
    */
   Repair noReairsResult(int uid);

   /*
    * 已处理回复
    */
   Repair pastReairsResult(int uid);
}