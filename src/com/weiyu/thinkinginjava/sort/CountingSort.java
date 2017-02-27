package com.weiyu.thinkinginjava.sort;

/**
 * Created by weiyu on 2017/2/25.
 */
public class CountingSort {
    public static int findMaxDivision(int[] A, int n) {
        // write code here
        if(n < 2 || n > 500)
            return 0;

        int max = A[0];
        int min = A[0];
        for(int i = 0;i < n;i++){
            if(A[i] > max) max = A[i];
            else if(A[i] < min) min = A[i];
        }
        int length = max - min + 1;
        int[] C = new int[length];
        for(int i = 0;i < n;i++){
            C[A[i] - min]++;
        }

        for(int i = 1;i < length;i++){
            C[i] += C[i - 1];
        }

        int[] B = new int[n];
        for(int i = 0;i < n;i++){
            B[C[A[i] - min] - 1] = A[i];
            C[A[i] - min]--;
        }

        int result = B[1] - B[0];
        for(int i = 1;i < n;i++){
            if((B[i] - B[i - 1]) > result)
                result = B[i] - B[i - 1];
        }
        return result;
    }

    public static void main(String... args){
        int[] a = {138,591};
        System.out.println(findMaxDivision(a,a.length));
    }
}
