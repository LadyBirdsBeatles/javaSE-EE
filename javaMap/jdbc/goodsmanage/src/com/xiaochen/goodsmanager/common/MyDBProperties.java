package com.xiaochen.goodsmanager.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class MyDBProperties {
    private Map<String, String> map = new Hashtable<String, String>();

    public void myproperties(String path) throws IOException {
        FileReader reader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String s = "";
        while ((s = bufferedReader.readLine()) != null) {
            int indexOf = s.indexOf("=");
            String keys = s.substring(0, indexOf);
            String values = s.substring(indexOf + 1);
            map.put(keys, values);

        }
        bufferedReader.close();
        reader.close();

    }

    public String getkey(String keys) {

        return map.get(keys);
    }
}
