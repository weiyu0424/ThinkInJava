package com.weiyu.offer.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Wei Yu on 2017/8/16.
 */
public class P3_Greedy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] h = new int[n];
            for(int i = 0;i < n;i++){
                h[i] = in.nextInt();
            }

            int m = in.nextInt();
            int[] w = new int[m];
            for(int i = 0;i < m;i++){
                w[i] = in.nextInt();
            }

            Arrays.sort(h);
            Arrays.sort(w);

            int count = 0;
            int hIndex = n - 1;
            int wIndex = m - 1;
            while(hIndex >= 0 && wIndex >= 0){
                if(w[wIndex] >= h[hIndex]){
                    count++;
                    hIndex--;
                    wIndex--;
                }else{
                    hIndex--;
                }
            }
            System.out.println(count);
        }
        in.close();
    }
}
