package com.weiyu.offer.offer.didi.fans;

import java.util.Scanner;

/**
 * Created by xpZhu on 2017/8/26.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strs = line.split(" ");
        int[] nums = new int[strs.length];
        for(int i = 0;i < strs.length;i++){
            nums[i] = Integer.parseInt(strs[i]);
        }

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
        System.out.println(maxSum);
    }

}
