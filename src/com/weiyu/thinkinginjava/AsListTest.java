package com.weiyu.thinkinginjava;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by weiyu on 2017/2/10.
 */
public class AsListTest {
    public static void main(String... args){
        String[] persons = {"person1","person2"};
        //asList方法返回的兑现更不是一个ArrayList对象，而是一个视图对象，
        // 带有访问底层数组的get和set方法。改变数组大小的所有方法都会抛出一个 Unsupported OperationException异常
        //Array可以转化为List,同样，List类中也有一个方法toArray方法转化为Array
        List list = Arrays.asList(persons);
//        list.add("hello");
        System.out.println(list);



        List<String> names = Collections.nCopies(10,"Samuel");
        System.out.println(names);
    }
}
