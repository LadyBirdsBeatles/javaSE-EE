package com.itoyokado.cms.util;

public class RegexUtil {
    public static boolean isJob_Number(String str){
        String regex = "^[A-Za-z]{2}[0-9]{3,}$";
        return  str.matches(regex);
    }
}
