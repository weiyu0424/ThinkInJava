package com.weiyu.offer.didi;

import java.util.Scanner;

/**
 * Created by xpZhu on 2017/8/26.
 */
public class P1_ConsistentSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strs = line.split(" ");
        int[] nums = new int[strs.length];
        for(int i = 0;i < strs.length;i++){
            nums[i] = Integer.parseInt(strs[i]);
        }

        int sum = getConsistentSum(nums);
        System.out.println(sum);
    }

    private static int getConsistentSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int tempSum = Integer.MIN_VALUE;
        for(int i = 0 ;i < nums.length;i++){
            if(tempSum > 0){
                tempSum += nums[i];
            }else{
                tempSum = nums[i];
            }
            if(tempSum > maxSum){
                maxSum = tempSum;
            }
        }
        return maxSum;
    }
}
