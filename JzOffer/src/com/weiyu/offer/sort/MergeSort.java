package com.weiyu.offer.sort;

import java.util.Arrays;

/**
 * Created by Wei Yu on 2017/8/10.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{13,5,2,8,7,3,9,5,15,14};
//        int[] result = mergeSort(array,0,array.length - 1);
//        System.out.println(Arrays.toString(result));

        int[] result = new int[array.length];
        mergeSort_without_result(array,result,0,array.length - 1);
        System.out.println(Arrays.toString(result));
    }


    /**
     * 通过返回值来进行归并排序，增加了空间复杂度
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] mergeSort(int[] array,int start,int end){
        if(start == end)
            return new int[]{array[start]};
        int mid = (start + end) >> 1;
        int[] left = mergeSort(array,start,mid);
        int[] right = mergeSort(array,mid + 1, end);

        int[] copy = new int[left.length + right.length];
        int i = 0,j = 0;
        int index = 0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                copy[index++] = left[i++];
            }else{
                copy[index++] = right[j++];
            }
        }

        while(i < left.length){
            copy[index++] = left[i++];
        }

        while(j < right.length){
            copy[index++] = right[j++];
        }
        return copy;
    }


    /**
     * 将结果数组作为参数传进来，merger需要一个额外的数组大小的数组
     * @param array
     * @param result
     * @param start
     * @param end
     */
    public static void mergeSort_without_result(int[] array,int[] result,int start,int end){
        if(start >= end)
            return ;
        int mid = (start + end) >> 1;
        mergeSort_without_result(array,result,start,mid);
        mergeSort_without_result(array,result,mid + 1, end);

        int i = start;
        int j = mid + 1;
        int index = start;
        while(i <= mid && j <= end){
            if(array[i] < array[j]){
                result[index++] = array[i++];
            }else{
                result[index++] = array[j++];
            }
        }

        while(i <= mid){
            result[index++] = array[i++];
        }

        while(j <= end){
            result[index++] = array[j++];
        }

        for(i = start;i <= end;i++){
            array[i] = result[i];
        }
    }
}


