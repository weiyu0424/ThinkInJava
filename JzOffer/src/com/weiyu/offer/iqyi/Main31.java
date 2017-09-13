package com.weiyu.offer.iqyi;
import java.util.Scanner;

public class Main31{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int a = in.nextInt();
            int b = in.nextInt();
            int count = 0;
            for(int i = 1;i <= a;i++){
                int j = 1;
                while(j <= b){
                    double result = Math.sqrt(i * j);
                    if(result % 1 == 0){
                        count++;
                    }
                    j++;
                }
            }
            System.out.println(count);
        }
        in.close();
    }
}
