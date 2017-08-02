package com.weiyu.thinkinginjava;

import java.util.*;

/**
 * Created by Wei Yu on 2017/7/5.
 */
public class LinkedListTest {
    public static void main(String... args){
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random(100);
        for(int i = 0;i < 1000;i++){
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        Queue<Integer> queue = new LinkedList<>();
        Map<String,String> map = new HashMap<>();
        map.put("one","hello");
        map.put("second","world");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
