package com.xiaochen.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.xiaochen.service.LCostService;
import com.xiaochen.service.LaliPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("/pays")
public class Alipaycontroller {
    @Autowired
    LCostService lCostService;

    @Autowired
    LaliPayService laliPayService;


    @RequestMapping("/pay")
    @ResponseBody
    protected String doPay(String costid, String money) throws IOException {
        System.out.println(costid);
        System.out.println(money);
        int moneys = Integer.parseInt(money);
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGN_TYPE);
        //创建API对应的request

        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        // 返给用户的响应地址,回调结果
        alipayRequest.setReturnUrl(AlipayConfig.RETURN_URL);
        //在公共参数中设置回跳和通知地址
        alipayRequest.setNotifyUrl(AlipayConfig.NOTIFY_URL);
        //订单编号  10位随机数字组成
        Random random = new Random();
        int phone = 0;
        for (int i = 0; i < 10; i++) {
            phone = random.nextInt(50000);
        }
        String outTradeNo = "panda" + System.currentTimeMillis() + (long) (Math.random() * 10000000L);
        String body = "property";
        String uuid = "UUID.randomUUID().toString().replace(\"-\",\"\")";
        System.out.println(outTradeNo);
        System.out.println(phone);
        System.out.println(body);
        System.out.println(uuid);
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"" + UUID.randomUUID().toString().replace("-", "") + "\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":\"" + money + "\"," +
                "    \"subject\":\"" + outTradeNo + "\"," +
                "    \"body\":\"" + body + "\"," +
                "    \"timeout_express\":\"20m\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088102177718202\"" +
                "    }" +
                "  }");//填充业务参数

        String form = "";
        int costState = lCostService.updateCostState(Integer.parseInt(costid));
        System.out.println(costState);
        int insertpay = laliPayService.insert(Integer.parseInt(costid));
        System.out.println(insertpay);
        try {
            //调用SDK生成表单
            form = alipayClient.pageExecute(alipayRequest).getBody();

        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if (costState > 0 && insertpay > 0) {
            return form;
        }
        return null;
    }
}
