package com.weiyu.offer.zhaoyin;

import java.util.Scanner;

/**
 * Created by xpZhu on 2017/9/13.
 */
public class Joseff {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int m = in.nextInt();
            int[] heights = new int[m];
            for(int i = 0;i < heights.length;i++){
                heights[i] = in.nextInt();
            }

            int i = 0;
            int sumOfA = 0;
            int sumOfB = 0;
            while(i < m){
                if(i == m - 1){
                    sumOfA += heights[i];
                }else if(i + 1 == m - 1){
                    sumOfA += heights[i] + heights[i + 1];
                }else if(i + 2 == m - 1){
                    if(heights[i] > heights[i + 1] + heights[i + 2]){
                        sumOfA += heights[i];
                    }else if(heights[i] + heights[i + 1] > heights[i + 2]){
                        sumOfA += heights[i] + heights[i + 1];
                    }
                }

            }

        }

        in.close();
    }
}
