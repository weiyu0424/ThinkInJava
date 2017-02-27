package com.weiyu.thinkinginjava;

import java.util.*;

/**
 * Created by weiyu on 2016/12/15.
 */
public class AddingGroups{
    public static void main(String... args){
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Integer[] moreInts = {6,7,8,9,10};
        collection.addAll(Arrays.asList(moreInts));

        Collections.addAll(collection,11,12,13,14,15);
        Collections.addAll(collection, moreInts);
        for(Integer num : collection){
            System.out.println(num);
        }

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.set(1,88);
//        list.add(21);
    }
}
