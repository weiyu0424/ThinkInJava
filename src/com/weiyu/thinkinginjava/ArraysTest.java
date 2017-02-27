package com.weiyu.thinkinginjava;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by weiyu on 2017/2/12.
 */
public class ArraysTest {
    public static void main(String... args){
        //copyOfArray();
        pickNumbers();
    }

    private static void copyOfArray() {
        int[] luckyNumbers = {1,2,3,4,5,6,7};
        int[] luckyNumbers1 = new int[]{1,2,3,4};
        System.out.println("Original array:" + Arrays.toString(luckyNumbers));

        int[] copiedLuckyNumbers = luckyNumbers;
        copiedLuckyNumbers[3] = 122;
        int[] copiedLuckyNumbers1 = Arrays.copyOf(luckyNumbers,luckyNumbers.length);
        copiedLuckyNumbers1[4] = 333;
        System.out.println("Original array1:" + Arrays.toString(luckyNumbers));
        System.out.println("CopiedLuckyNumbers:" + Arrays.toString(copiedLuckyNumbers));
        System.out.println("CopiedLuckyNumbers1:" + Arrays.toString(copiedLuckyNumbers1));
    }

    private static void pickNumbers(){
        Scanner in =  new Scanner(System.in);
        System.out.println("Please enter the length of the array");
        int n = in.nextInt();
        int[] numbers = new int[n];
        for(int i = 0;i < n;i++){
            numbers[i] = i;
        }

        System.out.println("Please enter the length of the lucky array");
        int length = in.nextInt();
        int[] luckyNumbers = new int[length];
        for(int i = 0;i < length;i++){
            //int v = new Random(n).nextInt();
            int v = (int) (Math.random() * n);
            luckyNumbers[i] = numbers[v];
            numbers[v] = numbers[n - 1];
            n--;
        }

        Arrays.sort(luckyNumbers);
        System.out.println("luckyNumbers:" + Arrays.toString(luckyNumbers));
    }
}
