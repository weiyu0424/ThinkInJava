package com.weiyu.offer.wangyi;

import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int count =0;
        for(int i=1;i<n;i++){
            for(int a=1;a<=k;a++){
                for(int b=a-1;b>=1;b--){
                    if(a % b==0)
                        count++;
                }
            }
        }
        int x = (int)Math.pow(2.0, 2.0);
        System.out.println(x-count);
    }
}
