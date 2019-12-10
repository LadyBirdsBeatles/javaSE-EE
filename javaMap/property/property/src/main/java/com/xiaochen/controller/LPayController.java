package com.xiaochen.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/onpay")
public class LPayController {
    @RequestMapping("/pay")
    public void mypay(@RequestBody Map<String, String> map, HttpServletRequest request, HttpServletResponse response) throws IOException {
        int sumCost = Integer.parseInt(map.get("sumCost"));
        int costId = Integer.parseInt(map.get("costId"));
        int userId = Integer.parseInt(map.get("userId"));
        System.out.println(sumCost);
        System.out.println(costId);
        System.out.println(userId);
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGN_TYPE);
        //创建API对应的request
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        // 返给用户的响应地址,回调结果
        alipayRequest.setReturnUrl(AlipayConfig.RETURN_URL);
        //在公共参数中设置回跳和通知地址
        alipayRequest.setNotifyUrl(AlipayConfig.NOTIFY_URL);
        String outTradeNo = "panda" + System.currentTimeMillis() + (long) (Math.random() * 10000000L);
        String tmpe = "物业费";
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"" + outTradeNo + "\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":" + sumCost + "," +
                "    \"subject\":panda 1号," +
                "    \"body\":" + tmpe + "," +
                "    \"passback_params\":merchantBizType%3d3C%26merchantBizNo%3d2016010101111," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088102177718202\"" +
                "    }" +
                "  }");//填充业务参数
        String form = "";
        try {
            //调用SDK生成表单
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        //直接将完整的表单html输出到页面
        response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
        response.getWriter().write(form);
        response.getWriter().flush();
        response.getWriter().close();
        System.out.println(alipayRequest.toString());

    }

}

