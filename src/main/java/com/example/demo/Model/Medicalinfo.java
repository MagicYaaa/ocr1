package com.example.demo.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Medicalinfo{
    private HashMap map;

    public Medicalinfo(){

    }
    public Medicalinfo(HashMap map){
        this.map = map;
    }

    public HashMap getmap(){
        return map;
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