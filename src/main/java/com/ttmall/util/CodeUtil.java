package com.ttmall.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.concurrent.ThreadLocalRandom;

public class CodeUtil {
    public static String  createCode(String phone){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIFi8bI8pBi23F", "EEQstTflNRn62GrBSdDLZvVu4xl3RW");
        IAcsClient client = new DefaultAcsClient(profile);
        String code = randomNum();
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "TTMall");
        request.putQueryParameter("TemplateCode", "SMS_172737767");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return code;
    }
    private static String randomNum(){
        int i = ThreadLocalRandom.current().nextInt(111211, 999999);

                return String.valueOf(i);
    }
}
