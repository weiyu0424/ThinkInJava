package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/7/7.
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 输入描述:
 题目保证输入的数组中没有的相同的数字
 数据范围：
 对于%50的数据,size<=10^4
 对于%75的数据,size<=10^5
 对于%100的数据,size<=2*10^5
 */
public class ReversePair {
    public int InversePairs(int [] array) {
        if(null == array || 0 == array.length)
            return 0;
        int[] copy = new int[array.length];
        for(int i = 0;i < array.length;i++){
            copy[i] = array[i];
        }

        int count = merge(array,copy,0,array.length - 1);
        return count;
    }

    private int merge(int[] array, int[] copy, int start, int end) {
        if(start >= end)
            return 0;

        int mid = start + ((end - start) >> 1);
        int leftCount = merge(array,copy,start,mid);
        int rightCount = merge(array,copy,mid + 1,end);
        int count = 0;
        int i = mid;
        int j = end;
        int index = end;
        while(i >= start && j > mid){
            if(array[i] > array[j]){
                copy[index--] = array[i--];
                count += (j - mid);
                if(count >= 1000000007){
                    count %= 1000000007;
                }
            }else{
                copy[index--] = array[j--];
            }
        }

        for(;i >= start;i--){
            copy[index--] = array[i];
        }

        for(; j > mid;j--){
            copy[index--] = array[j];
        }

        for(int k = start;k <= end;k++)
            array[k] = copy[k];

        return count + leftCount + rightCount;
    }

    public static void main(String... args){
        int[] array = {5,9,3,2,7,5,6};
        int result = new ReversePair().InversePairs(array);
        System.out.println(result);
        /*int start = 2;
        int end = 3;
        int mid = (end - start) >> 1;
        mid += start;
        System.out.println(mid);*/
    }
}
