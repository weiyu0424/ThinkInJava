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
        int num0 = 100;
        Integer num1 = new Integer(100);
        Integer num2 = new Integer(100);
        Integer num3 = 259;
        Integer num4 = 259;
        Integer num5 = 100;
        /**
         * 1、基本型跟基本型封装型进行==比较时，封装型会拆箱成基本型，然后进行值比较
         * 2、基本型不能调用equals方法，基本型封装型与基本型进行equals比较时，基本型会装箱成基本型封装型，然后进行值比较
         * 3、两个Integer类型进行“==”比较，如果其值在-128至127，那么返回true，否则返回false, 这跟Integer.valueOf()的缓冲对象有关，这里不进行赘述。
         * 4、两个基本型的封装型进行equals()比较，首先equals()会比较类型，如果类型相同，则继续比较值，如果值也相同，返回true
         */
        System.out.println(num0 == num1);//true
        System.out.println(num1 == num2);//false
        System.out.println(num1.equals(num2));//true
        System.out.println(num1.equals(num0));//true
        System.out.println(num3 == num4);//false
        System.out.println(num0 == num5);//true

//        System.out.println("equals:" + str1.equals(str2) + ";==" + (str1 == str2));
//        System.out.println("equals:" + num1.equals(num2) + ";==" + (num1 == num2));

       // System.out.println(str3.equals(str1));

    }
}
