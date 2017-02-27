package com.weiyu.thinkinginjava.sort;

import java.util.Arrays;

/**
 * Created by weiyu on 2017/2/25.
 */
public class BubbleSort {
    //private static int[] a = {10,9,8,17,66,5,41,13,23,19};
    /**
     * 冒泡排序
     * @param a
     */
    public static void bubbleSort(int[] a){
        long start = System.currentTimeMillis();
        for(int i = 0;i < a.length;i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("bubbleSort:" + (end - start));
    }

    /**
     * 改进后的冒泡排序
     * @param a
     */
    public static void improvedBubbleSort(int[] a){
        long start = System.currentTimeMillis();
        boolean flag;
        for(int i = 0;i < a.length - 1;i++) {
            flag = true;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] < a[j + 1]) {
                    flag = false;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            if(flag)
                break;
        }

        long end = System.currentTimeMillis();
        System.out.println("improvedBubbleSort:" + (end - start));
    }

    /**
     * 选择排序
     * @param a
     */
    public static void selectSort(int[] a){
        for(int i = 0;i < a.length;i++)
            for(int j = i;j < a.length;j++){
                if(a[i] < a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
    }

    public static void quickSort(int[] a,int left,int right){
        if(left > right)
            return;
        int i,j,temp;
        temp = a[left];
        i = left;
        j = right;
        while(i != j){
            while(a[j] >= temp && j > i)
                j--;
            while(a[i] <= temp && i < j)
                i++;
            if(i < j){
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        a[left] = a[i];
        a[i] = temp;
        quickSort(a,left,i - 1);
        quickSort(a,i+1,right);
    }

    public static void main(String... args){
        /*int[] a = new int[100000];
        for(int i = 100000 - 1;i >= 0;i--){
            a[100000 - 1 - i] = i;
        }*/
        int[] a = {10,9,8,17,66,5,41,13,23,19};
//        int[] a = {10,9,8,7,6,5,4,3,2,1};
        System.out.println("Original array:" + Arrays.toString(a));
        //bubbleSort(a);
        //System.out.println("Bubble array:" + Arrays.toString(a));
        //selectSort(a);
        //System.out.println("Select array:" + Arrays.toString(a));
//        improvedBubbleSort(a);
//        System.out.println("improvedBubbleSort:" + Arrays.toString(a));

//        quickSort(a,0,a.length - 1);
//        System.out.println("quickSort:" + Arrays.toString(a));
        int[] b = new int[100];
        System.out.println(Arrays.toString(b));
    }
}
