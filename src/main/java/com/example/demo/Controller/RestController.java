package com.example.demo.Controller;

import com.example.demo.Service.OcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")

public class RestController {

    @Autowired
    OcrService service;

    @RequestMapping("/ocr")
    @ResponseBody
    public String hello(@RequestParam(name = "url", required = false) String url) {

        String result = service.customeOcr(url);

        return result;
    }


    @RequestMapping("/ocr2")
    @ResponseBody
    public String ocr2(@RequestParam(name = "url", required = false) String url) {


        return "nihao";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello2(
            @RequestParam(name = "url", required = false) String temlasd,
            @RequestParam(name = "template", required = false) String template,
            @RequestParam(name = "url2", required = false) String url2

            ) {
        return "我接受到你的请求了："+temlasd+" template"+template;
    }
}
