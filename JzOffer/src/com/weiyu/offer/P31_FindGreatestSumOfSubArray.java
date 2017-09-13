package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/9/13.
 */
public class P31_FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int begin = 0;
        int end = array.length - 1;
        for(int i = 0;i < array.length;i++){
            if(sum < 0){
                sum = 0;
                begin = i;
            }

            sum += array[i];

            if(sum > maxValue){
                maxValue = sum;
                end = i;
            }
        }
        for(int i = begin;i <= end;i++){
            System.out.print(array[i] + " ");
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] array = {1,-2,3,10,-4,7,2,-5};
        int result = new P31_FindGreatestSumOfSubArray().FindGreatestSumOfSubArray(array);
        System.out.println();
        System.out.println(result);
    }
}
