package com.weiyu.offer.toutiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static long getMinOfSet(List<Integer> nums){
        long min = Long.MAX_VALUE;
        for(long num : nums){
            if(num < min)
                min = num;
        }
        return min;
    }

    public static long getSumOfSet(List<Integer> nums){
        long sum = 0;
        for(long num : nums){
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int length = in.nextInt();
            int[] array = new int[length];
            for(int i = 0; i < length;i++){
                array[i] = in.nextInt();
            }

            List<List<Integer>> sets = getSubsets(array);
            long max = Long.MIN_VALUE;
            //System.out.println(sets);
            //List<Long> result = new ArrayList<>();
            for(List<Integer> list : sets){
                long temp = getMinOfSet(list) * getSumOfSet(list);
                if(temp > max)
                    max = temp;
                /*if(null != list){
                    result.add(getMinOfSet(list) * getSumOfSet(list));
                }*/
            }

            //Long max = Collections.max(result);
            System.out.println(max);
        }
        in.close();

    }

    public static List<List<Integer>> getSubsets(int[] items){
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i < items.length;i++) {
            for(int j = i;j < items.length;j++) {
                List<Integer> temp = new ArrayList<>();
                for(int k = i;k <= j;k++) {
                    temp.add(items[k]);
                }
                list.add(temp);
            }
        }
        return list;
    }

}
