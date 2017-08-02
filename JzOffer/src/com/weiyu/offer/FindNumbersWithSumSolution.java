package com.weiyu.offer;

import java.util.ArrayList;

/**
 * Created by Wei Yu on 2017/7/10.
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSumSolution {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(null == array || array.length < 2)
            return list;
        int multipleSum = Integer.MAX_VALUE;
        int left = 0;
        int right = array.length - 1;

        int tempLeft = 0;
        int tempRight = 0;
        while(left < right){
            int count = array[left] + array[right];
            if(sum == count){
                int mulValue = array[left] * array[right];
                if(mulValue < multipleSum){
                    multipleSum = mulValue;
                    tempLeft = left;
                    tempRight = right;
                }
                left++;
                right--;
            }else if(count < sum){
                left++;
            }else{
                right--;
            }
        }

        if(0 != tempLeft || 0 != tempRight){
            list.add(array[tempLeft]);
            list.add(array[tempRight]);
        }

        return list;
    }

    public static void main(String... args){
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        ArrayList<Integer> result = new FindNumbersWithSumSolution().FindNumbersWithSum(array, 21);
        System.out.println(result);
    }
}
