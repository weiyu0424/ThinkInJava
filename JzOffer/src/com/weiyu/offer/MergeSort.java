package com.weiyu.offer;

import java.util.Arrays;

/**
 * Created by xpZhu on 2017/7/29.
 */
public class MergeSort {
    public static int[] merge(int[] A,int[]B){
        int aLength = A.length;
        int bLength = B.length;
        int[] arr = new int[aLength + bLength];
        int i = 0;
        int j = 0;
        int cnt = 0;
        while(i < aLength && j < bLength){
            if(A[i] > B[j]){
                arr[cnt++] = A[i++];
            }else{
                arr[cnt++] = B[j++];
            }
        }

        while(i < aLength){
            arr[cnt++] = A[i++];
        }

        while(j < bLength){
            arr[cnt++] = B[j++];
        }
        return arr;
    }
    public static void main(String... args){

        int[] merge = new MergeSort().merge(new int[]{99, 92, 87, 0}, new int[]{98, 90, 82});
        System.out.println(Arrays.toString(merge));

    }
}
