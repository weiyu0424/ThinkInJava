package com.weiyu.offer.ali;

public class Solution {
    public int maxScore(int[] score) {
        if(null == score || 0 == score.length)
            return 0;

        int len = score.length;
        int[][] dp = new int[len+2][len+2];
        int[][] visit = new int[len+2][len+2];
        int[] numsPlus = new int[len+2];
        
        for(int i = 1;i<len + 1;i++){
            numsPlus[i] = score[i - 1];
        }
        numsPlus[0] = 1;
        numsPlus[len+1] = 1;
        
        int result = search(dp , visit , numsPlus , 1 , len);
        
        return result;
    }
    
    public int search(int[][] dp , int[][] visit , int[] numsPlus , int start , int end){
        if(visit[start][end] == 1){
            return dp[start][end];
        }
        int res = 0;
        for(int i = start; i<=end ; i++){
            int mid = 0;
            if(0 == numsPlus[i])
                mid = numsPlus[start-1] * numsPlus[i] * numsPlus[end+1];
            else
                mid = numsPlus[start-1] * numsPlus[i] * numsPlus[end+1];
            int right = search(dp , visit , numsPlus , start , i - 1);
            int left = search(dp , visit , numsPlus , i + 1 , end);
            res = Math.max(res , mid + right + left);
        }
        visit[start][end] = 1;
        dp[start][end] = res;
        
        return res;
    }
}
