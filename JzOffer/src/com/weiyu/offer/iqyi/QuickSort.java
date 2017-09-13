package com.weiyu.offer.iqyi;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Wei Yu on 2017/9/12.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {13,2,7,5,9,4,6};
        new QuickSort().quickSort(array,array.length,0,array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public void quickSort(int[] array,int length,int start,int end){
        if(start == end)
            return;
        int index = partition(array, length, start, end);
        if(index > start)
            quickSort(array,length,start,index - 1);
        if(index < end)
            quickSort(array,length,index + 1,end);
    }

    public int partition(int[] array,int length,int start,int end){
        if(null == array || length < 0 || start > end || start < 0 || end > length)
            throw new RuntimeException("非法数组");
        int index = new Random().nextInt(end - start + 1) + start;
        swap(array,index,end);

        int small = start -1;
        for(int i = start;i < end;i++){
            if(array[i] < array[end]){
                small++;
                if(i != small){
                    swap(array,i,small);
                }
            }
        }
        small++;

        swap(array,small,end);
        return small;
    }

    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
