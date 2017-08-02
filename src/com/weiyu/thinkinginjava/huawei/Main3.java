package com.weiyu.thinkinginjava.huawei;

import java.math.BigInteger;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        /*while(cin.hasNext()) {
            BigInteger a = new BigInteger(cin.next(), 7);//转为10进制
            BigInteger b = new BigInteger(cin.next(), 7);
            BigInteger c = a.multiply(b);
            System.out.println(c.toString(7));
        }*/
        BigInteger d = new BigInteger("14",7);
        System.out.println(d.toString(6));
    }

}