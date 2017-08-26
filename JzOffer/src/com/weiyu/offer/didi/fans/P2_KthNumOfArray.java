package com.weiyu.offer.didi.fans;

import java.util.Scanner;

public class P2_KthNumOfArray {
    private static void bumpSort(int[] array,int length, int k) {
        int tag = 0;
        for(int i = 0 ;i < length;i++){
            tag++;
            for(int j = 0;j < length - i - 1;j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if(tag == k){
                System.out.println(array[length - k]);
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strs = line.split(" ");
        int[] array = new int[strs.length];
        for(int i = 0;i < strs.length;i++){
            array[i] = Integer.parseInt(strs[i]);
        }
        int k = in.nextInt();
        if(k > array.length)
            System.out.println(-1);

        bumpSort(array, array.length, k);
        in.close();
    }


}
