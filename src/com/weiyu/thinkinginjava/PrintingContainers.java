package com.weiyu.thinkinginjava;

import java.util.*;

/**
 * Created by weiyu on 2016/12/15.
 */
public class PrintingContainers {
    static Collection fill(Collection<String> collection){
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map fill(Map<String,String> map){
        map.put("rat","Fuzzy");
        map.put("cat","rags");
        map.put("dog","Bosco");
        map.put("dog","Spot");
        return map;
    }
    public static void main(String[] args){
        System.out.println("ArrayList:" + fill(new ArrayList<String>()));
        System.out.println("LinkedList:" + fill(new LinkedList<String>()));
        System.out.println("HashSet:" + fill(new HashSet<String>()));
        System.out.println("TreeSet:" + fill(new TreeSet<String>()));
        System.out.println("LinkedHashSet:" + fill(new LinkedHashSet<String>()));
        System.out.println("HashMap:" + fill(new HashMap<String, String>()));
        System.out.println("TreeMap:" + fill(new TreeMap<String, String>()));
        System.out.println("LinkedHashMap:" + fill(new LinkedHashMap<String, String>()));
    }
}
