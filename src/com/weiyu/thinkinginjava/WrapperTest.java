package com.weiyu.thinkinginjava;

/**
 * Created by weiyu on 2017/3/20.
 */
public class WrapperTest {
    public static void main(String... args){
        Integer i01 = 129;
        int i02 = 129;
        Integer i03 = Integer.valueOf(129);
        Integer i04 = new Integer(129);
        Integer i05 = 129;
        System.out.println(i01 == i02);
        System.out.println(i01 == i03);
        System.out.println(i03 == i04);
        System.out.println(i02 == i04);
        System.out.println(i01 == i05);
    }
}
