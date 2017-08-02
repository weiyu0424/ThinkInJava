package com.weiyu.thinkinginjava.algorithm;

/**
 * Created by weiyu on 2017/4/6.
 */
public class ReverseAddTest {
    public static int reverse(int num){
        int temp = num;
        if(temp < 0){
            temp = -temp;
        }
        int sum = 0;
        while(temp != 0){
            int resdue = temp % 10;
            sum = sum * 10 + resdue;
            temp = temp / 10;
        }

        return num < 0 ? -sum : sum;
    }

    public static void main(String... args){
        System.out.println(reverse(-1234));
    }
}
