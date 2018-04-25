package com.example.demo.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MedicalAnalyses {
    StringBuilder sb = new StringBuilder("----此处为分析模块测试内容：<br>");
    HashMap<String, ArrayList> medical_info_map;


    public MedicalAnalyses(MedicalJson medicalJson, HashMap<String,ArrayList> medical_info_map){
        this.medical_info_map = medical_info_map;
        Iterator<MedicalJson.DataBean.RetBean> it  = medicalJson.getData().getRet().iterator();
        while (it.hasNext()) {
            String qc = "";
            String judgement;
            //第一个字段 简称JC
            if(it.hasNext()){
                MedicalJson.DataBean.RetBean data = it.next();
                sb.append(data.getWord()+" ");
            }
            //第二个字段 全称QC
            if(it.hasNext()){
                MedicalJson.DataBean.RetBean data = it.next();
                qc = data.getWord();
                sb.append(qc +" ");
            }

            //第三个字段，数值     act + 天门冬氨基转移酶 :31.8
            if (it.hasNext()) {
                MedicalJson.DataBean.RetBean data = it.next();

                Float num = Float.parseFloat(data.getWord());

                Medicalinfo medicalinfo = new Medicalinfo();
                int tag = medicalinfo.judge0(medical_info_map,qc,num);
                System.out.print(qc+num+"tag = "+tag);
                if(tag == 0){
                    judgement = "正常";
                }else if(tag == 1){
                    judgement = "偏高";
                }else {
                    judgement = "偏低";
                }

                //judgement = "偏高";
                sb.append(" : "+ num + "     "+ judgement + "<br>");
            }
        }
    }

    public StringBuilder getSb() {
        return sb;
    }
    public int judge0(HashMap map,String s,Float num){
        if(map.containsKey (s)){
            ArrayList list = (ArrayList)map.get(s);
            System.out.print(map.get(s));//debug
            Float min = (Float) list.get(0);
            Float max = (Float) list.get(1);
            System.out.print("min:"+min+"max:"+max); //debug
            if(num < min ) {
                return -1;
            }else if(num > max ){
                if(max == 0){
                    return 0;
                }else return 1;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }
}
