package com.weiyu.offer.thread;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Wei Yu on 2017/7/18.
 */
public class ConcurrentHashMapTest {
    public static void main(String... args){
        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>();
        map.put("one","hello");
        map.put("second","world");

        Set<Map.Entry<String,Object>> entrySets = map.entrySet();
        for(Map.Entry<String,Object> entrySet : entrySets){
            System.out.println("key:" + entrySet.getKey() + " : value:" + entrySet.getValue());
        }

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Object> entry = iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
