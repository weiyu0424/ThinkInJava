package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/7/25.
 */
public class JoseffCircle {
    public int LastRemaining_Solution(int n, int m) {
        if(m <= 0 || n <= 0)
            return -1;

        int result = 0;
        for(int i = 1;i < n;i++){
            result = (result + m) % n;
        }
        return result;
    }

    public static void main(String... args){
        int result = new JoseffCircle().LastRemaining_Solution(6, 3);
        System.out.println(result);
    }
}
