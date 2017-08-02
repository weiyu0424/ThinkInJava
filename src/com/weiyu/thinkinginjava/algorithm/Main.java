package com.weiyu.thinkinginjava.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String... args){
//        double[] a = {0.5,0.6,0.7,0.8};
//        List<List<Double>> combine = combine(a, 3);
//        System.out.println(combine.size());
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        double[] problems = new double[length];
        for(int i = 0;i < length;i++){
            problems[i] = in.nextDouble();
            problems[i] /= 100;
        }

        int preciseNum = (int)Math.ceil(length * 0.6);
        double possibility = 0;
        for(int i = preciseNum;i <= length;i++){
            List<List<Double>> list = combine(problems, i);
            //System.out.println("size:" + list.size());
            double sum = 0;
            for(List<Double> nums : list){
                double count = 1;
                for(Double num : nums){
                    count *= num;
                }
                sum += count;
            }
            possibility += sum;
        }
        System.out.println(possibility);
    }

    private static List<List<Double>> combine(double[] a, int num) {
        List<List<Double>> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        String[] b = new String[a.length];
        for (int i = 0; i < b.length; i++) {
            if (i < num) {
                b[i] = "1";
            } else
                b[i] = "0";
        }

        int point = 0;
        int nextPoint = 0;
        int count = 0;
        int sum = 0;
        String temp = "1";
        while (true) {
            List<Double> nums = new ArrayList<>();
            for (int i = b.length - 1; i >= b.length - num; i--) {
                if (b[i].equals("1"))
                    sum += 1;
            }
            for (int i = 0; i < b.length; i++) {
                if (b[i].equals("1")) {
                    point = i;
                    nums.add(a[point]);
                    count++;
                    if (count == num)
                        break;
                }
            }
            list.add(nums);

            if (sum == num) {
                break;
            }
            sum = 0;

            for (int i = 0; i < b.length - 1; i++) {
                if (b[i].equals("1") && b[i + 1].equals("0")) {
                    point = i;
                    nextPoint = i + 1;
                    b[point] = "0";
                    b[nextPoint] = "1";
                    break;
                }
            }

            for (int i = 0; i < point - 1; i++)
                for (int j = i; j < point - 1; j++) {
                    if (b[i].equals("0")) {
                        temp = b[i];
                        b[i] = b[j + 1];
                        b[j + 1] = temp;
                    }
                }
            sb.setLength(0);
            count = 0;
        }
        return list;

    }
}
