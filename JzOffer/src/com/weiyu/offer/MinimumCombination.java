package com.weiyu.offer;

import java.util.*;

/**
 * Created by Wei Yu on 2017/7/6.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class MinimumCombination {
    public String PrintMinNumber(int [] numbers) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for(int num : numbers){
            list.add(num);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                String str1 = String.valueOf(num1) + String.valueOf(num2);
                String str2 = String.valueOf(num2) + String.valueOf(num1);
                return str1.compareTo(str2);
            }
        });

        for(int num : list){
            sb.append(num);
        }
        return sb.toString();
    }

    public void sort(String[] array){
        Arrays.sort(array);
    }

    public static void main(String... args){
        String[] nums = {"3","32","321"};
        new MinimumCombination().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
