package com.weiyu.offer.java8.java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wei Yu on 2017/8/27.
 */
public class StreamCase {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for(int i = 0;i < 100000;i++){
            double d = Math.random() * 1000;
            list.add(d + " ");
        }

        long startTime = System.currentTimeMillis();
        /*Stream<String> sorted = list.stream().sequential().sorted();
        Iterator<String> iterator = sorted.iterator();
        while(iterator.hasNext()){
            String str = iterator.next( );
            System.out.println(str);
        }*/

        long count = list.stream().sequential().sorted().count();
        long end = System.currentTimeMillis();
        System.out.println((end - startTime));


        startTime = System.currentTimeMillis();
        count = list.stream().parallel().sorted().count();
        end = System.currentTimeMillis();
        System.out.println((end - startTime));


        list.stream().filter((s)-> s.startsWith("123.4")).forEach(System.out :: println);
    }
}
