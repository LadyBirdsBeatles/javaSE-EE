package com.itoyokado.cms.service.impl;

import com.itoyokado.cms.dao.WaybillDao;
import com.itoyokado.cms.dao.impl.WaybillDaoImpl;
import com.itoyokado.cms.entity.Waybill;
import com.itoyokado.cms.service.WaybillService;

public class WaybillServiceImpl implements WaybillService {
    @Override
    public Boolean addWaybill(Waybill waybill) throws Exception {
        WaybillDao waybillDao = new WaybillDaoImpl();
        Boolean doneaddWaybill = waybillDao.addWaybill(waybill);
        if (doneaddWaybill) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean waybillTuihuo(String sys_no) throws Exception {
        WaybillDao waybillDao = new WaybillDaoImpl();
        Boolean isTuihuo = waybillDao.waybillTuihuo(sys_no);
        if (isTuihuo) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Waybill findWaybill(Waybill waybill) throws Exception {
        WaybillDao waybillDao = new WaybillDaoImpl();
        Waybill waybill1 = waybillDao.findWaybill(waybill);
        return waybill1;
    }
}
