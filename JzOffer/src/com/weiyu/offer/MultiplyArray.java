package com.weiyu.offer;

import java.util.Arrays;

/**
 * Created by Wei Yu on 2017/7/28.
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class MultiplyArray {
    public int[] multiply(int[] A) {
        if(null == A || 0 == A.length)
            return null;
        int length = A.length;
        int[] B = new int[length];
        B[0] = 1;
        for(int i = 1;i < length;i++){
            B[i] = B[i - 1] * A[i - 1];
        }

        int temp = 1;
        for(int j = length - 2;j >= 0;j--){
            temp *= A[j + 1];
            B[j] *= temp;
        }

        return B;
    }

    public static void main(String... args){
        int[] array = new int[5];
        for(int i = 0;i < 5;i++){
            array[i] = i + 1;
        }
        System.out.println("array:" + Arrays.toString(array));
        int[] result = new MultiplyArray().multiply(array);
        System.out.println(Arrays.toString(result));
    }
}
