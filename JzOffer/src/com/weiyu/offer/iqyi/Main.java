package com.weiyu.offer.iqyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String line = in.nextLine();
            if(line.isEmpty()){
                System.out.println(0);
                return;
            }

            char[] tags = line.toCharArray();
            int leftNum = 0;
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i < tags.length;i++){
                if('(' == tags[i]){
                    leftNum++;
                }else if(')' == tags[i]){
                    map.put(i,leftNum);
                    leftNum--;
                }
            }

            int max = Integer.MIN_VALUE;
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                if(entry.getValue() > max)
                    max = entry.getValue();
            }
            System.out.println(max);
        }
        in.close();
    }
}
