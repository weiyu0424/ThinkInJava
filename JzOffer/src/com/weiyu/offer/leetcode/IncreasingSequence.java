package com.weiyu.offer.leetcode;

/**
 * Created by Wei Yu on 2017/8/22.
 */
public class IncreasingSequence {
    public static int getIncreasingSequenceCount(int[] num){
        int ans = 0;
        int[] dp = new int[num.length];
        for(int i = 1; i < num.length; ++i){
            for(int j = 0; j < i; ++j){
                if(num[i] > num[j]){
                    dp[i] += (dp[j] + 1);
                }
            }
            ans += dp[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int result = getIncreasingSequenceCount(new int[]{3,5,8,4,7});
        System.out.println(result);
    }
}
