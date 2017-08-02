package com.weiyu.thinkinginjava.algorithm;

import java.util.Scanner;

/**
 * Created by weiyu on 2017/3/24.
 */
public class ReverseAdd {
    public int reverse(int x) {
        if(x < 0 || x > 70000) return 0;
        long r = 0;
        while (x>0) {
            r = r * 10 + x % 10;
            if (r > Integer.MAX_VALUE) return 0;
            x /= 10;
        }
        return (int)r;
    }

    public int reverseAdd(int a,int b){
        int aResult = reverse(a);
        int bResult = reverse(b);
        return aResult + bResult;
    }

    public static void main(String... args){
        Scanner in = new Scanner(System.in);
//        int a = in.nextInt();
//        int b = in.nextInt();
        int result = new ReverseAdd().reverseInt(1234);
        System.out.println(result);
    }

    public int reverseInt(int num){
        int temp = num;
        if(num < 0){
            temp = -num;
        }
        long result = 0;
        while(temp > 0){
            result = result * 10 + temp % 10;
            temp /= 10;
        }

        if(num < 0){
            result *= -1;
        }
        return (int)result;
    }
}
