package com.xiaochen.goodsmanager.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * 加载properties配置文件
 * IO读取文件，键值对存储到集合中
 * 从集合中以键值对方式获取数据库的连接信息，完成数据库的连接
 */
public class DbPropertiesloads {
   private static   InputStream inputStream=null;
   private  static   Properties properties=null;

    static {
     inputStream = DbPropertiesloads.class.getClassLoader().getResourceAsStream("db.properties");
     properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    加载文件获取键
     */
    public  static String getprokey(String keys) {
        return properties.getProperty(keys);
    }
}
