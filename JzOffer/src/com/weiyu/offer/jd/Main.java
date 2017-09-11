package com.weiyu.offer.jd;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String line = in.nextLine();
            char[] tags = line.toCharArray();
            int leftNum = 0;
            int sum = 1;
            for(int i = 0;i < tags.length;i++){
                if('(' == tags[i]){
                    leftNum++;
                }else if(')' == tags[i]){
                    sum *= leftNum;
                    leftNum--;
                }
            }
            System.out.println(sum);
        }
        in.close();
    }
}
