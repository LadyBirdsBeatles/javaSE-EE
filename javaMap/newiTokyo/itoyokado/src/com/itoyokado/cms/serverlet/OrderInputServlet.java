package com.itoyokado.cms.serverlet;

import com.itoyokado.cms.entity.Buy_Goods;
import com.itoyokado.cms.entity.Goods;
import com.itoyokado.cms.entity.Sys_User;
import com.itoyokado.cms.entity.Waybill;
import com.itoyokado.cms.service.GoodsService;
import com.itoyokado.cms.service.UserService;
import com.itoyokado.cms.service.WaybillService;
import com.itoyokado.cms.service.impl.GoodsServiceImpl;
import com.itoyokado.cms.service.impl.UserServiceImpl;
import com.itoyokado.cms.service.impl.WaybillServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class OrderInputServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        if ("orderInput".equals(request.getParameter("func"))) {
            System.out.println("进来了");

            this.orderInput(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>();

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    public void orderInput(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Object userClass = request.getSession().getAttribute("userClass");
Sys_User s_userLogin = (Sys_User) userClass;
        //封装Waybill对象
        Waybill waybill = new Waybill();
        WaybillService waybillService = new WaybillServiceImpl();
        UserService userService = new UserServiceImpl();
        Date date = new Date();
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.HOUR, 1);
//        waybill.setSys_no(request.getParameter("title"));
        String uuid = UUID.randomUUID().toString();
        waybill.setSys_no(uuid);
        waybill.setGoods_no(request.getParameter("goods_number"));
        waybill.setCost(Integer.valueOf(request.getParameter("box_price")));
        waybill.setConsignee_address(request.getParameter("user_address"));
        waybill.setConsignor_address(request.getParameter("s_adress"));
        waybill.setCreated_date(date);
        waybill.setPay_way(request.getParameter("payway"));
        waybill.setSys_user_id(s_userLogin.getId());
        date = ca.getTime();
        //计划开始时间
        waybill.setPlanned_start_time(date);
        waybill.setDistribution_date(date);
        //时间推后一小时
        ca.add(Calendar.HOUR, 1);
        date=ca.getTime();
        //计划结束时间
        waybill.setPlanned_end_time(date);
        waybill.setEta(date);
        waybill.setGoods_price(Double.parseDouble(request.getParameter("goods_price")));
        waybill.setBox_id(Integer.valueOf(request.getParameter("box_id")));

        //调用Service方法
        try {
            //通过电话查询user_id,装入waybill中;
            waybill.setConsignee_id(userService.findUserByPhone(request.getParameter("user_phone")));
            Boolean isadded = waybillService.addWaybill(waybill);
            if (isadded){
                System.out.println("订单添加成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        //封装Buy_Goods对象
        Goods goods = new Goods();
        Buy_Goods buy_goods = new Buy_Goods();
        try {
            BeanUtils.populate(buy_goods,parameterMap);
            GoodsService goodsService = new GoodsServiceImpl();
            Boolean isadded = goodsService.addBuy_Goods(buy_goods);
            Waybill findWaybill = waybillService.findWaybill(waybill);
            buy_goods.setWaybill_id(findWaybill.getId());
            System.out.println(buy_goods.toString());

            if (isadded){
                System.out.println("商品添加成功");
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String s_tel = request.getParameter("s_tel");
        String s_name = request.getParameter("s_name");


    }

}
