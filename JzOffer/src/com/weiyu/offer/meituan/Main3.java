package com.weiyu.offer.meituan;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int length = in.nextInt();
            int[] array = new int[length + 1];
            long dp[] = new long[length + 1];
            dp[0] = 0;
            for(int i = 1;i <= length;i++){
                array[i] = in.nextInt();
                dp[i] = dp[i - 1] + array[i];
            }
            int k = in.nextInt();
            int maxValue = 0;
            for(int i = length; i >= 1;i--){
                if(i > maxValue) {
                    for (int j = 0; j <= length - i; j++) {
                        if ((dp[j + i] - dp[j]) % k == 0) {
                            if(i > maxValue)
                                maxValue = i;
                        }
                    }
                }
            }
            System.out.println(maxValue);
        }
        in.close();
    }
}