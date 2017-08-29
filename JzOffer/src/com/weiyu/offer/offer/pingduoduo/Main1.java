package com.weiyu.offer.offer.pingduoduo;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        int min1 = 0,min2 = 0;
        int max1 = 0, max2 = 0, max3 = 0;
        int length;
        int temp;
        int result;
        Scanner cin=new Scanner(System.in);
        length = cin.nextInt();
        for (int i = 0; i < length; i++) {
            temp = cin.nextInt();
            if(temp < 0){
                if(temp < min2){
                    if(temp < min1){
                        min2 = min1;
                        min1 = temp;
                    }
                    else{
                        min2 = temp;
                    }
                }
            }
            else{
                if(temp > max3){
                    if(temp>max2){
                        if(temp>max1){
                            max3=max2;
                            max2=max1;
                            max1=temp;
                        }
                        else{
                            max3=max2;
                            max2=temp;
                        }
                    }
                    else
                        max3=temp;
                }
            }

        }
        if(min1*min2>max2*max3){
            result=min1*min2*max1;
        }
        else {
            result=max2*max3*max1;
        }
        System.out.println(result);
    }

}
