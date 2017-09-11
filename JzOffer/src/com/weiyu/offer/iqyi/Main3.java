package com.weiyu.offer.iqyi;

import java.util.Scanner;

/**
 * Created by xpZhu on 2017/9/10.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int a = in.nextInt();
            int b = in.nextInt();
            int count = 0;
            for(int i = 1;i <= a;i++)
                for(int j = 1;j <= b;) {
                    double result = Math.sqrt(i * j);
                    if (result % 1 == 0) {
                        count++;
                        if ((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)){
                            j += 2;
                        }else{
                            j++;
                        }
                    }

                }
            System.out.println(count);
        }
        in.close();
    }
}
