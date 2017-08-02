package com.weiyu.offer.pingduoduo;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int length = in.nextInt();
            if(length < 3)
                continue;
            long max1 = Long.MIN_VALUE;
            long max2 = Long.MIN_VALUE;
            long max3 = Long.MIN_VALUE;
            long min1 = Long.MAX_VALUE;
            long min2 = Long.MAX_VALUE;
            for(int i = 0;i < length;i++){
                int temp = in.nextInt();
                if (temp > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = temp;
                } else if (temp > max2) {
                    max3 = max2;
                    max2 = temp;
                } else if (temp > max3) {
                    max3 = temp;
                }

                if (temp < min1) {
                    min2 = min1;
                    min1 = temp;
                } else if (temp < min2) {
                    min2 = temp;
                }
            }
            System.out.println(Math.max(max1 * max2 * max3, max1 * min1 * min2));
        }
        in.close();
    }

    public static int getLargestThreeMultiples(int[] array) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int temp : array) {
            if (temp > max1) {
                max3 = max2;
                max2 = max1;
                max1 = temp;
            } else if (temp > max2) {
                max3 = max2;
                max2 = temp;
            } else if (temp > max3) {
                max3 = temp;
            }

            if (temp < min1) {
                min2 = min1;
                min1 = temp;
            } else if (temp < min2) {
                min2 = temp;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
