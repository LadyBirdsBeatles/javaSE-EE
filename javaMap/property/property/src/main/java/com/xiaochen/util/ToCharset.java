package com.xiaochen.util;

import java.io.UnsupportedEncodingException;

public class ToCharset {
    public  static String toCharset(String valueStr){
        //乱码解决，这段代码在出现乱码时使用
        try {
            return new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String kfdjvdkmv = toCharset("能降低妇女哦");
        System.out.println(kfdjvdkmv);
    }
}
