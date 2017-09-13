package com.weiyu.offer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Wei Yu on 2017/9/13.
 */
public class P30_GetLeastNumbers {
    public static void main(String[] args) {
        int[] array = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> result = new P30_GetLeastNumbers().GetLeastNumbers_Solution(array, 4);
        System.out.println(result);
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(null == input || k > input.length || k <= 0)
            return result;
        int start = 0;
        int end = input.length - 1;
        int index = 0;
        while(start <= end){
            index = partition(input,input.length,start,end);
            if(index == k -1){
                break;
            }else if(index > k - 1){
                end = index - 1;
            }else{
                start = index + 1;
            }
        }
        for(int i = 0;i <= index;i++){
            result.add(input[i]);
        }
        return result;
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
}
