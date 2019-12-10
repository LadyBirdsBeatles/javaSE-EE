package com.itoyokado.cms.dao.impl;

import com.itoyokado.cms.dao.WaybillDao;
import com.itoyokado.cms.entity.Waybill;
import com.itoyokado.cms.util.JDBCUtil;
import com.mysql.cj.x.protobuf.MysqlxExpr;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class WaybillDaoImpl implements WaybillDao {
    QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());



    /**
     * 添加订单的方法
     *
     * @param waybill
     * @return
     * @throws Exception
     */
    @Override
    public Boolean addWaybill(Waybill waybill) throws Exception {
        System.out.println(waybill.toString());
        String sql = "insert into waybill values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {
                waybill.getSys_no(),
                waybill.getGoods_no(),
                waybill.getCost(),
                waybill.getDistribution_date(),//开始配送时间
                waybill.getPlanned_end_time(),//预计到达时间
                null,//完成时间
                waybill.getConsignee_id(), //收货人ID
                waybill.getConsignee_address(),//收货人地址
                waybill.getConsignor_address(),//发货人地址
                null,//订单状态描述
                null, //完成方式
                null,//所属公司
                null,  //所属区域
                waybill.getCreated_date(), //上次修改时间
                waybill.getSys_user_id(), //制单人ID
                null, //配送地址维度
                null, //配送地址经度
                waybill.getPlanned_start_time(),//计划开始配送时间
                waybill.getPlanned_end_time(), //计划结束配送时间
                waybill.getBox_id(),//装箱号
                waybill.getGoods_price(),//货物价值
                waybill.getPay_way(), //支付方
        };
        int update = runner.update(sql, params);
        if (update == 1){
            return true;
        }else {
            return false;
        }

    }

    /**
     * 订单退货
     *
     * @param sys_no 订单编号
     * @return 执行结果
     * @throws Exception
     */
    @Override
    public Boolean waybillTuihuo(String sys_no) throws Exception {
        String sql = "update waybill set status_desc=? where sys_no = " + sys_no;
        int update = runner.update(sql);
        if (update == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 查找订单
     * @param waybill
     * @return
     * @throws Exception
     */
    @Override
    public Waybill findWaybill(Waybill waybill) throws Exception {
        String sql = "select * from waybill where sys_no=?";
        ResultSetHandler<Waybill> rsh = new BeanHandler<Waybill>(Waybill.class);
        System.out.println("传进来的sys_no:" + waybill.getSys_no());
         waybill = runner.query(sql, rsh, waybill.getSys_no());
        return waybill;
    }


}
