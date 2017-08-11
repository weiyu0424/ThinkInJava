package com.weiyu.offer.sort;

import java.util.Arrays;

/**
 * Created by Wei Yu on 2017/8/10.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{13,2,8,7,3,9,5,15,14};
        quickSort(array,0,array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array,int start,int end){
        int i = start,j = end;
        if(i < j){
            int temp = array[i];
            while(i < j){
                while(i < j && array[j] > temp){
                    j--;
                }
                if(i < j){
                    array[i] = array[j];
                    i++;
                }
                while(i < j && array[i] < temp)
                    i++;

                if(i < j){
                    array[j] = array[i];
                    j--;
                }
            }
            array[i] = temp;
            quickSort(array,start,i - 1);
            quickSort(array,i + 1,end);
        }
    }
}
