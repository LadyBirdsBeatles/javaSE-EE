package com.itoyokado.cms.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_time {
       public static Timestamp mseconde(){
        //获得系统时间
        Date date = new Date();
        //将时间格式转换成符合Timestamp要求的格式
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        //把时间转换mseconde
        return  Timestamp.valueOf(nowTime);
    }

    public static void main(String[] args) {
        Timestamp t = Date_time.mseconde();
        System.out.println(t);
    }
}
