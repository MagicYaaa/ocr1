package com.example.demo.Model;

import java.util.List;

public class ResultJson {
    private List<ResData> list;
    private StringBuilder analise;
    private int error_code;


    public List getlist(){
        return list;
    }

    public void setList(List list){
        this.list = list;
    }

    public StringBuilder getAnalise(){
        return analise;
    }
    public void setAnalise(StringBuilder sb){
        this.analise = sb;
    }
    public int getError_code(){
        return error_code;
    }
    public void setError_code(int error_code){
        this.error_code = error_code;
    }

    public static class ResData{
        private String qc;
        private int value;

        public void setQc(String qc) {
            this.qc = qc;
        }

        public String getQc() {
            return qc;
        }

        public void setValue(int value){
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
}


