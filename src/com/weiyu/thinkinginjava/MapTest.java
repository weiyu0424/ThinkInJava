package com.weiyu.thinkinginjava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by weiyu on 2017/3/10.
 */
public class MapTest {
    public static void main(String... args){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("key1","hello,world1");
        map.put("key2","hello,world2");
        map.put("key3","hello,world3");
        map.put("key4","hello,world4");
        map.put("key5","hello,world5");

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Object> item = iterator.next();
            System.out.println("key:" + item.getKey() + ";value:" + item.getValue());
        }
        map.remove("key1");

//        ConcurrentHashMap

        /*Set<Map.Entry<String, Object>> entries = map.entrySet();
        for(Map.Entry<String,Object> entry : entries){
            System.out.println("key:" + entry.getKey() + ";value:" + entry.getValue());
        }*/
    }
}
