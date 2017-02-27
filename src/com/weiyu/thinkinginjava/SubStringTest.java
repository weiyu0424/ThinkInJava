package com.weiyu.thinkinginjava;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weiyu on 2017/2/10.
 */
public class SubStringTest {
    public static void main(String... args){
        String params = "Hello,world";
        //substring函数包含第一个索引，不包括第二个索引

        /**so non-structural
         *  changes in the returned list are reflected in this list, and vice-versa.
         * The returned list supports all of the optional list operations supported
         * by this list.*/
        params = params.substring(2,5);
        System.out.println(params);

        List<String> keys = new ArrayList<>();
        keys.add("first");
        keys.add("second");
        keys.add("third");
        keys.add("fourth");
        keys.add("fifth");
        //这里可以将任何操作应用于子范围
        List<String> subKeys = keys.subList(0,3);
       // keys.add("six");
//        subKeys.add("seven");
//        subKeys.set(0,"first1");
        //System.out.println("keys:" + keys + ";subKeys:" + subKeys);
        //System.out.println(keys);
        System.out.println(subKeys);

    }
}
