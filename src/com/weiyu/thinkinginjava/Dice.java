package com.weiyu.thinkinginjava;

import java.util.Scanner;

/**
 * Created by weiyu on 2017/4/6.
 * 华为机试题：掷骰子
 */
public class Dice {
    public static void main(String... args){
        String value = "123456";
        Scanner in = new Scanner(System.in);
        String operation = in.nextLine();
        if(operation.length() > 50){
            System.out.println("操作过长");
        }else{
            System.out.println(operate(operation,value));
        }
    }

    public static String operate(String operation,String value){
        char[] array = value.toCharArray();
        char temp1,temp2;
        for(int i = 0;i < operation.length();i++){
            char c = operation.charAt(i);
            switch(c) {
                case 'L':
                    temp1 = array[0];
                    temp2 = array[1];
                    array[0] = array[4];
                    array[1] = array[5];
                    array[4] = temp2;
                    array[5] = temp1;
                    break;
                case 'R':
                    temp1 = array[0];
                    temp2 = array[0];
                    array[0] = array[5];
                    array[1] = array[4];
                    array[4] = temp1;
                    array[5] = temp2;
                    break;
                case 'F':
                    temp1 = array[2];
                    temp2 = array[3];
                    array[2] = array[4];
                    array[3] = array[5];
                    array[4] = temp2;
                    array[5] = temp1;
                    break;
                case 'B':
                    temp1 = array[2];
                    temp2 = array[3];
                    array[2] = array[5];
                    array[3] = array[4];
                    array[4] = temp1;
                    array[5] = temp2;
                    break;
                case 'A':
                    temp1 = array[0];
                    temp2 = array[1];
                    array[0] = array[3];
                    array[1] = array[2];
                    array[2] = temp1;
                    array[3] = temp2;
                    break;
                case 'C':
                    temp1 = array[0];
                    temp2 = array[1];
                    array[0] = array[2];
                    array[1] = array[3];
                    array[2] = temp2;
                    array[3] = temp1;
                    break;
            }
        }
        return new String(array);
    }
}
