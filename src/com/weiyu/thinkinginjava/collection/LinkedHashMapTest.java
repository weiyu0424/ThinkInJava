package com.weiyu.thinkinginjava.collection;

import java.util.*;

/**
 * Created by Wei Yu on 2017/7/25.
 */
public class LinkedHashMapTest {
    public static void main(String... args){
        Map<String,String> map = new HashMap<>();
        map.put("apple","苹果");
        map.put("watermelon","西瓜");
        map.put("banana","香蕉");
        map.put("peach","桃子");

        Set<Map.Entry<String,String>> entrySets = map.entrySet();
        Iterator<Map.Entry<String,String>> iterator = entrySets.iterator();
        while(iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            System.out.println("key:" + entry.getKey() + ":value:" + entry.getValue());
        }

        System.out.println("===============================");

        map = new LinkedHashMap<>();
        map.put("apple","苹果");
        map.put("watermelon","西瓜");
        map.put("banana","香蕉");
        map.put("peach","桃子");

        entrySets = map.entrySet();
        iterator = entrySets.iterator();
        while(iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            System.out.println("key:" + entry.getKey() + ":value:" + entry.getValue());
        }


        System.out.println("====================================");
        //true表示按照访问顺序来，会按照get的顺序将元素加入到队列的尾部
        map = new LinkedHashMap<>(16,0.75f,true);
        map.put("apple","苹果");
        map.put("watermelon","西瓜");
        map.put("banana","香蕉");
        map.put("peach","桃子");

        map.get("apple");
        map.get("watermelon");

        entrySets = map.entrySet();
        iterator = entrySets.iterator();
        while(iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            System.out.println("key:" + entry.getKey() + ":value:" + entry.getValue());
        }
    }
}
