package com.weiyu.offer.jd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<>();
        while(in.hasNext()){
            int num = in.nextInt();
            for(int i = 1;i <= num;i++)
                for(int j = 1;j <= num;j++){
                    int result = me(i,j);
                    if(map.containsKey(result)){
                        map.put(result,map.get(result) + 4);
                    }else{
                        map.put(result,4);
                    }
                }
            long sum = 0;
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                if(entry.getValue() % 4 == 0){
                    sum += (entry.getValue() / 4);
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
