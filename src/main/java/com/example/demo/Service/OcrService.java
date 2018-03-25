package com.example.demo.Service;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.HashMap;

@Service
public class OcrService {
    //设置APPID/AK/SK String clientId = "";
    //        // 官网获取的 Secret Key 更新为你注册的
    //        String clientSecret = "YMAciakFkDHtKSFAblDqOF7Gib7AB7mY";
    public static final String APP_ID = "10937310";
    public static final String API_KEY = "A4DCESHpmtbluSGmwQUS12an";
    public static final String SECRET_KEY = "YMAciakFkDHtKSFAblDqOF7Gib7AB7mY";
    String medicalTemplate = "a55610ec785be3cdc1ce1fe30e80c3c8";


    public String customeOcr(String url){
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);


        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量

        // 调用接口
        if(url == null || url.equals("")){
            URL in = OcrService.class.getResource("/imgs/test.jpg");
            url = in.getPath();
        }
        //请求百度识别
        JSONObject res = client.custom(url,medicalTemplate, new HashMap<String, String>());
        //System.out.println(res.toString(2));



        //分析结果


        String result = "通过对化验单的分析，得出以下建议：1。胆固醇超标，建议节食。";
        //返回识别结果


        return result;
    }

    public static void main(String[] args) {
        new OcrService().customeOcr("");
    }
}
