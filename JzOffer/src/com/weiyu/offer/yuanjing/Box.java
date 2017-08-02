package com.weiyu.offer.yuanjing;

public class Box {
    public int getHeight(int[] w, int[] l, int[] h, int n) {
        for(int i = n - 1;i >= 0;i--){
            for(int j = 0;j < i;j++){
                if(w[j] < w[j + 1]){
                    swap(w,j,j + 1);
                    swap(l,j,j + 1);
                    swap(h,j,j + 1);
                }
            }
        }
        int[] maxH = new int[n];

        maxH[0] = h[0];
        int result = maxH[0];
        for(int i = 1; i < n; i++){
            maxH[i] = h[i];
            int tmax = 0;
            for(int j = i - 1; j >= 0; j--){
                if(w[j] > w[i] && l[j] > l[i]){
                    tmax = (tmax > maxH[j]) ? tmax : maxH[j];
                }
            }
            maxH[i] += tmax;
            result = result > maxH[i] ? result : maxH[i];
        }
        return result;
    }
    public void swap(int[] array,int indexI,int indexJ){
        int t = array[indexI];
        array[indexI] = array[indexJ];
        array[indexJ] = t;
    }
}