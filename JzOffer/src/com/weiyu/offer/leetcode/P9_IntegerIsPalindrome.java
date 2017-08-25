package com.weiyu.offer.leetcode;

/**
 * Created by Wei Yu on 2017/8/22.
 */
public class P9_IntegerIsPalindrome {
    public static boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0))
            return false;
        int temp = 0;
        while(x > temp){
            temp = temp * 10 + x % 10;
            x /= 10;
        }
        return (x == temp) || (temp / 10 == x);
    }

    public static void main(String[] args) {
        boolean flag = isPalindrome(0);
        System.out.println(flag);
    }
}
