package com.weiyu.offer.offer.pingduoduo;

import java.util.Scanner;

/**
 * Created by Wei Yu on 2017/8/16.
 */
public class P1_MaxMultiple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int length = in.nextInt();
            int[] array = new int[length];
            for(int i = 0;i < length;i++){
                array[i] = in.nextInt();
            }
            long result = getMaxValue(array);
            System.out.println(result);
        }
        in.close();
    }

    private static long getMaxValue(int[] array) {
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE,max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE,min2 = Integer.MAX_VALUE;
        for(int item : array){
            if(item > max1){
                max3 = max2;
                max2 = max1;
                max1 = item;
            }else if(item > max2){
                max3 = max2;
                max2 = item;
            }else if(item > max3){
                max3 = item;
            }

            if(item < min2){
                min1 = min2;
                min2 = item;
            }else if(item < min1){
                min1 = item;
            }
        }

        //这里要考虑三个数同时相乘的话会有溢出问题
        return Math.max((long)min1 * min2 * max1,(long)max1 * max2 * max3);
    }
}
