package com.weiyu.offer.offer.toutiao;

import java.util.*;
public class Main2 {
    public static List<List<Integer>> getSubSets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(nums);
        track(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void track(List<List<Integer>> list , List<Integer> temp, int[] nums, int begin){
        list.add(new ArrayList<>(temp));
        for(int i = begin; i < nums.length; i++){
            temp.add(nums[i]);
            track(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

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

            List<List<Integer>> sets = getSubsetss(array);
            System.out.println(sets);
            List<Long> result = new ArrayList<>();
            for(List<Integer> list : sets){
                if(null != list){
                    result.add(getMinOfSet(list) * getSumOfSet(list));
                }
            }

            Long max = Collections.max(result);
            System.out.println(max);
        }
        in.close();

//        List<List<Integer>> result = getSubsetss(new int[]{6, 2, 1});
//        System.out.println(result);
    }

    public static List<List<Integer>> getSubsetss(int[] items){
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<items.length;i++) {
            for(int j=i;j<items.length;j++) {
                List<Integer> temp = new ArrayList<>();
                for(int k=i;k<=j;k++) {
                    //System.out.print(items[k]);
                    temp.add(items[k]);
                }
                //System.out.println();
                list.add(temp);
                //temp.clear();
            }
        }
        return list;
    }

}
