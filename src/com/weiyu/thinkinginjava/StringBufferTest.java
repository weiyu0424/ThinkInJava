package com.weiyu.thinkinginjava;

/**
 * Created by weiyu on 2017/3/16.
 */
public class StringBufferTest {
    public static void main(String... args){
        StringBuffer buffer = new StringBuffer();
        buffer.append("hello,world");
        buffer.insert(3,"which");
        System.out.println(buffer.toString());
    }
}
