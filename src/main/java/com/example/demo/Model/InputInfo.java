package com.example.demo.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class InputInfo {
    java.io.File file;
    //  = new java.io.File("src/main/resources/imgs/text.txt")
    /*
        if(file.exists()){
        System.out.println("exists");
    }else{
        System.out.println("noexists");
    }
    */
    HashMap<String, ArrayList> map = new HashMap<>();

    public InputInfo() {
        file = new java.io.File("src/main/resources/imgs/text.txt");
    }

    public InputInfo(String s) {
        file = new java.io.File(s);
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (input.hasNext()) {
            String text1 = input.next();    //读取第一个字段
            Float text2 = input.nextFloat();    //读取 上限值
            Float text3 = input.nextFloat();    //读取 下限值
            ArrayList<Float> arrayList = new ArrayList<>(); //上下限存入ArrayList
            arrayList.add(text2);
            arrayList.add(text3);
            map.put(text1, arrayList);   //名称字段作为key， 上下线作为value,存入map
        }
        // 保存至map结束
        System.out.println(map);  //打印一下text看看录入是否正确  可以删除的呦
        //文件导入map结束 ******

    }

    public HashMap<String, ArrayList> getMap() {
        return map;
    }

}
