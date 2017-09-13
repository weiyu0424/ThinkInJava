package com.weiyu.offer;

import java.util.Random;

/**
 * Created by Wei Yu on 2017/9/13.
 */
public class P29_MoreThanHalfNUm {
    public static void main(String[] args) {
//        int[] array = {1,2,3,2,2,2,5,4,2};
        int[] array = {1,2,3,2,4,2,5,2,3};
        /*int result = new P29_MoreThanHalfNUm().getNumMoreThanHalf(array, array.length, 0, array.length - 1);
        if(checkIfMoreThanHalf(array,result))
            System.out.println(result);
        else
            System.out.println(0);*/

        int result = new P29_MoreThanHalfNUm().getNumMoreThanHalf(array);
        System.out.println(result);
    }

    private static boolean checkIfMoreThanHalf(int[] array, int result) {
        int count = 0;
        for(int i = 0;i < array.length;i++){
            if(array[i] == result){
                ++count;
            }
        }
        return count > array.length / 2 ? true : false;
    }

    public int getNumMoreThanHalf(int[] array,int length,int left,int right){
        int midIndex = (length - 1) / 2;
        while(left <= right){
            int index = partition(array,array.length,left,right);
            if(index == midIndex){
                return array[index];
            }else if(index > midIndex){
                right = index - 1;
            }else if(index < midIndex){
                left = index + 1;
            }
        }
        return -1;
    }


    /**
     * 打擂的方法
     * @param array
     * @return
     */
    public int getNumMoreThanHalf(int[] array){
        int temp = array[0];
        int count = 1;
        for(int i = 1;i < array.length;i++){
            if(array[i] == array[i - 1])
                count++;
            else
                count--;
            if(0 == count){
                temp = array[i];
                count = 1;
            }
        }
        if(!checkIfMoreThanHalf(array,temp))
            temp = 0;
        return temp;
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
