package com.weiyu.thinkinginjava;

/**
 * Created by weiyu on 2017/2/17.
 * ==与equals的区别
 */
public class EqualsTest {
    public static void main(String... args){
        String str33 = "str3";
        String str43 = "str3";
        System.out.println("str33==str43:" + (str33 == str43));
        String str1 = new String("str2");
        String str2 = new String("str2");
        String str3 = null;
        Integer num1 = new Integer(100);
        Integer num2 = new Integer(100);

        System.out.println("equals:" + str1.equals(str2) + ";==" + (str1 == str2));
        System.out.println("equals:" + num1.equals(num2) + ";==" + (num1 == num2));

       // System.out.println(str3.equals(str1));

    }
}
