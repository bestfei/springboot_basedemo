package com.bestfei.springboot_basedemo.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class StrUtil {

    String baseNum = "0123456789";
    String baseLetters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String baseChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /*
    生成随机固定长度的数字
     */
    public String genRndFixedNum (int length){
        StringBuilder str=new StringBuilder();//定义可变长字符串
        Random random=new Random();
        for(int i=0;i<length;i++){
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    /*
    生成随机固定长度的字母
     */
    public String genRndFixedStr(int length){
        StringBuilder str=new StringBuilder();//定义可变长字符串
        Random random=new Random();
        for(int i=0;i<length;i++){
            int position = random.nextInt(52);
            str.append(baseLetters.charAt(position));
        }
        return str.toString();
    }

    /*
    生成随机固定长度的字符(数字+字母)
     */
    public String genRndFixedStrNum(int length){
        StringBuilder str=new StringBuilder();//定义可变长字符串
        Random random=new Random();
        for(int i=0;i<length;i++){
            int position = random.nextInt(62);
            str.append(baseChar.charAt(position));
        }
        return str.toString();
    }

    public static String list2JsonStr (List l){
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < l.size(); i++) {
            int count = 0;
            if(l.get(i) instanceof Map) {
                sb.append("{");
                for (Object key : ((Map) l.get(i)).keySet()) {
                    sb.append("\"");
                    sb.append(key);
                    sb.append("\"");
                    sb.append(":");
                    if (((Map) l.get(i)).get(key) instanceof String) {
                        sb.append("\"");
                        sb.append(((Map) l.get(i)).get(key));
                        sb.append("\"");
                    } else {
                        sb.append(((Map) l.get(i)).get(key));
                    }
                    if (count < ((Map) l.get(i)).size() - 1) {
                        sb.append(",");
                    }
                    count++;
                }
                sb.append("}");
                if (i != l.size() - 1) {
                    sb.append(",");
                }
            }
            else {
                sb.append("\"");
                sb.append(l.get(i));
                sb.append("\"");
                count ++;
                if (i != l.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    public static String rmNumFromStr (String str) {
        return str.replaceAll("\\d+", "");
    }

    public String removeBlankSpace(String str){
        return str.replace(" ","");
    }

    public String removeSqlString(String str){
        return str.replace(";","").replace("'","").replace("#","")
                .replace("*","");
    }

    public BigDecimal bigDecimalFormat(BigDecimal b){
        if(b.compareTo(new BigDecimal(0E-8))==0)
            b = new BigDecimal(0);
        return b;
    }

    public String maskString(String value){
//        if (value.length() <= 1) {
//            value = "*";
//        } else if (value.length() == 2) {
//            value = replaceAction(value, "(?<=.{0}).(?=.{1})");
//        } else
        if (value.length() >= 4 && value.length() <= 6) {
            value = replaceAction(value, "(?<=.{1}).(?=.{1})");
        } else if (value.length() == 7) {
            value = replaceAction(value, "(?<=.{1}).(?=.{2})");
        } else if (value.length() == 8) {
            value = replaceAction(value, "(?<=.{2}).(?=.{2})");
        } else if (value.length() == 9) {
            value = replaceAction(value, "(?<=.{2}).(?=.{3})");
        } else if (value.length() == 10) {
            value = replaceAction(value, "(?<=.{3}).(?=.{3})");
        } else if (value.length() >= 11) {
            value = replaceAction(value, "(?<=.{3}).(?=.{4})");
        }
        return value;
    }

    public String replaceAction(String value, String regular) {
        return value.replaceAll(regular, "*");
    }

}
