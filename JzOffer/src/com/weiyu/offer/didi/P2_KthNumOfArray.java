package com.weiyu.offer.didi;

import java.util.Scanner;
public class P2_KthNumOfArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strs = line.split(" ");
        int[] nums = new int[strs.length];
        for(int i = 0;i < strs.length;i++){
            nums[i] = Integer.parseInt(strs[i]);
        }

        int k = in.nextInt();
        if(k > nums.length)
            System.out.println(-1);

        int result = getKthNumOfAnArray(nums, k);
        System.out.println(result);
    }

    private static int getKthNumOfAnArray(int[] nums,int k) {
        int index = 0;
        for(int i = 0 ;i < nums.length;i++){
            for(int j = 0;j < nums.length - i - 1;j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            index++;
            if(index == k){
                return nums[nums.length - k];
            }
        }
        return -1;
    }
}
