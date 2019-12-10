package com.itoyokado.cms.dao;

import com.itoyokado.cms.entity.Waybill;

public interface WaybillDao {

    public Boolean addWaybill(Waybill waybill) throws Exception;

    public Boolean waybillTuihuo(String sys_no) throws Exception;
    public Waybill findWaybill(Waybill waybill) throws  Exception;
}
