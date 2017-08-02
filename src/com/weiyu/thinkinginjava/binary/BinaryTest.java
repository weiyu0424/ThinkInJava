package com.weiyu.thinkinginjava.binary;

/**
 * Created by weiyu on 2017/3/16.
 */
public class BinaryTest {
    public static void main(String... args){
        int i = -1;
        System.out.println(Integer.toBinaryString(i));
        i >>>= 10;
        System.out.println(Integer.toBinaryString(i));
        short num1 = -1;
        System.out.println(Integer.toBinaryString(num1));
    }
}
