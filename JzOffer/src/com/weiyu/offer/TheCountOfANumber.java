package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/7/7.
 * 统计一个数字在排序数组中出现的次数。
 */
public class TheCountOfANumber {
    public int GetNumberOfK(int [] array , int k) {
        if(null == array || 0 == array.length)
            return -1;

        int firstIndex = firstSearch(array,k,0,array.length - 1);
        int lastIndex = lastSearch(array,k,0,array.length - 1);
        System.out.println("lastIndex:" + lastIndex + ":firstIndex:" + firstIndex);
        return lastIndex - firstIndex + 1;
    }

    private int lastSearch(int[] array, int k, int start, int end) {
        if(start > end)
            return -1;
        int mid = (end + start) >> 1;
        if(array[mid] > k){
            return lastSearch(array,k,start,mid - 1);
        }else if(array[mid] < k){
            return lastSearch(array,k,mid + 1,end);
        }else if((mid + 1) <= end && array[mid + 1] == k){
            return lastSearch(array,k,mid + 1,end);
        }else{
            return mid;
        }
    }

    private int firstSearch(int[] array, int k, int start, int end) {
        if(start > end)
            return -1;
        int mid = (end + start) >> 1;
        if(array[mid] > k){
            return firstSearch(array,k,start,mid - 1);
        }else if(array[mid] < k){
            return firstSearch(array,k,mid + 1,end);
        }else if((mid - 1) >= start && array[mid - 1] == k){
            return firstSearch(array,k,start,mid - 1);
        }else{
            return mid;
        }
    }

    public static void main(String... args){
        int[] array = {1,3,3,3,3,4,5};
        int result = new TheCountOfANumber().GetNumberOfK(array, 2);
        System.out.println(result);
    }
}
