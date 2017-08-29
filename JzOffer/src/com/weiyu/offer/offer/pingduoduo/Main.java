package com.weiyu.offer.offer.pingduoduo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = null;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int length = in.nextInt();
            if(length < 3)
                continue;
            array = new int[length];
            int firstMaximum = Integer.MIN_VALUE;
            int firstIndex = -1;
            for(int i = 0;i < length;i++){
                int temp = in.nextInt();
                if(temp >= firstMaximum){
                    firstMaximum = temp;
                    firstIndex = i;
                }
                array[i] = temp;
            }

            int secondMaximum = Integer.MIN_VALUE;
            int secondIndex = -1;
            for(int i = 0;i < length;i++){
                if(i != firstIndex && array[i] >= secondMaximum) {
                    secondMaximum = array[i];
                    secondIndex = i;
                }
            }

            int thirdMaximum = Integer.MIN_VALUE;
            for(int i = 0;i < length;i++){
                if(i != firstIndex && i != secondIndex && array[i] >= thirdMaximum) {
                    thirdMaximum = array[i];
                }
            }

            int sum = firstMaximum * secondMaximum * thirdMaximum;
            /*for(int i = length - 1;i > length - 4;i--){
                sum *= array[i];
            }*/
            System.out.println(sum);
        }
        in.close();
    }

    public static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}
