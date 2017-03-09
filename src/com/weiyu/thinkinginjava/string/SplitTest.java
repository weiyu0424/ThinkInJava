package com.weiyu.thinkinginjava.string;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by weiyu on 2017/3/4.
 */
public class SplitTest {
    public static void main(String... args){
        String str = "hello;world";
        String[] result  = str.split(";");
        System.out.println(Arrays.toString(result) + ";length:" + result.length);


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");
        System.out.println(format.format(new Date()));
    }
}
