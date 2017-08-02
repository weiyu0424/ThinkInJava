package com.weiyu.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Wei Yu on 2017/7/3.
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class MinimumK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(k > input.length)
            return result;
        quickSort1(input,0,input.length - 1);
        for(int i = 0; i < k;i++){
            result.add(input[i]);
        }
        return result;
    }

    public void quickSort1(int[] array, int left, int right){
        if(left >= right) return;
        int i = left + 1;
        int j = right;
        while(i < j){
            while(j > i && array[j] > array[left])
                j--;
            while(i < j && array[i] < array[left]) {
                i++;
            }
            if(i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        if(array[i] < array[left]){
            int t = array[left];
            array[left] = array[i];
            array[i] = t;
        }

        quickSort1(array,left,i - 1);
        quickSort1(array,i + 1,right);
    }


    public void quickSort(int[] array, int left, int right){
        if(left >= right) return;
        int temp = array[left];
        int i = left;
        int j = right;
        while(i < j){
            while(j > i && array[j] > temp)
                j--;

            if(i < j){
                array[i] = array[j];
                i++;
            }
            while(i < j && array[i] < temp) {
                i++;
            }

            if(i < j){
                array[j] = array[i];
                j--;
            }
        }
        array[i] = temp;

        quickSort(array,left,i - 1);
        quickSort(array,i + 1,right);
    }

    public static void main(String... args){
        int[] nums = {4,5,1,6,2,7,3,8,9};
        new MinimumK().quickSort(nums,0,nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
