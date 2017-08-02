package com.weiyu.thinkinginjava.collection;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Wei Yu on 2017/7/24.
 */
public class HashSetTest {
    public static void main(String... args){
        HashSet<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.add("hello1");
        set.add("hello1");
        set.add("hello2");

        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String item = iterator.next();
            System.out.println(item);
        }

    }
}
