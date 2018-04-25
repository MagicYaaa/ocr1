package com.example.demo.Service;

import com.baidu.aip.ocr.AipOcr;
import com.example.demo.Model.InputInfo;
import com.example.demo.Model.MedicalAnalyses;
import com.example.demo.Model.MedicalJson;
import com.example.demo.Model.Medicalinfo;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.*;

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
        //请求百度识别         //System.out.println(res.toString(2));
        JSONObject res = client.custom(url,medicalTemplate, new HashMap<String, String>());

        //导入Medicalinfo文件，保存至map
        InputInfo inputInfo = new InputInfo("src/main/resources/imgs/text.txt");
        HashMap<String, ArrayList> medical_info_map = inputInfo.getMap();
        //文件导入map结束 ******

        //json实例化
        Gson gson = new Gson();
        MedicalJson medicalJson = gson.fromJson(res.toString(2), MedicalJson.class);

        //-------------=====

        //调用Medicalinfo信息 进行判断
        Medicalinfo medicalinfo = new Medicalinfo(medical_info_map);
        MedicalAnalyses medicalAnalyses = new MedicalAnalyses(medicalJson,medical_info_map);

        StringBuilder sb = medicalAnalyses.getSb();
        //分析结果

        String result =sb.toString() ;
        //返回识别结果
        return result;
    }
    /*  date 4.25 12.52
    public static void main(String[] args) {
        new OcrService().customeOcr("");
    }
    */

}
