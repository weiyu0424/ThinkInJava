package com.weiyu.offer.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Wei Yu on 2017/8/10.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{13,2,8,7,3,9,5,15,14};
        quickSort(array,array.length,0,array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array,int length,int start,int end){
        if(start == end)
            return;
        int index = partition(array,length,start,end);
        if(index > start)
            quickSort(array,length,start,index - 1);

        if(index < end)
            quickSort(array,length,index + 1,end);
    }

    public static int partition(int[] array,int length,int start,int end){
        if(length < 0 || null == array || start > end || end > length || start < 0)
            throw new RuntimeException("非法数组");
        Random random = new Random();
        int index = start + random.nextInt(end - start + 1);
        swap(array,index,end);

        int item = start - 1;
        for(int i = start;i < end;i++){
            if(array[i] < array[end]){
                item++;
                if(i != item){
                    swap(array,i,item);
                }
            }
        }

        item++;
        swap(array,item,end);
        return item;
    }


    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
