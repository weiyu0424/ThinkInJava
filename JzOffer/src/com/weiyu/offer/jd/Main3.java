package com.weiyu.offer.jd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<>();
        while(in.hasNext()){
            int num = in.nextInt();
            long sum = 0;
            for(int i = 1;i <= num;i++)
                for(int j = 1;j <= num;j++)
                    for(int k = 1;k <= num;k++)
                        for(int s = 1;s <= num;s++){
                            if(me(i,j) == me(k,s)){
                                sum++;
                            }
                        }
            System.out.println(sum % 1000000007);
        }
        in.close();
    }

    private static int me(int i, int j) {
        int sum = 1;
        for(int k = 0;k < j;k++){
            sum *= i;
        }
        return sum;
    }
}
