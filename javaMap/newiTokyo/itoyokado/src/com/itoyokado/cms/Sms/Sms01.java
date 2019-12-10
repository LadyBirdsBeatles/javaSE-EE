package com.itoyokado.cms.Sms;import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.0.3</version>
</dependency>
*/
public class Sms01 {

    public static void Sendmsm(String userphone, String random) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIAc0uCgAdXHzw", "HtYW8h7uf8L1EJf5kPu9eJKxBqH7bQ");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", userphone);
        request.putQueryParameter("SignName", "我的伊家");
        request.putQueryParameter("TemplateCode", "SMS_164276309");
        request.putQueryParameter("TemplateParam", "{\"code\":"+random+"}");
        System.out.println(random);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}