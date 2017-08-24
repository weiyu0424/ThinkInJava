package com.weiyu.offer.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wei Yu on 2017/8/22.
 */
public class P1_TwoSum {
    static class Num implements Comparable<Num>{
        public int value;
        public int index;
        public Num(int value,int index){
            this.value = value;
            this.index = index;
        }
        @Override
        public int compareTo(Num o) {
            if(this.value > o.value)
                return 1;
            else if(this.value < o.value)
                return -1;
            return 0;
        }
    }

    /**
     * 第一种方案
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Num[] array = new Num[nums.length];
        for(int i = 0;i < nums.length;i++){
            array[i] = new Num(nums[i],i);
        }
        Arrays.sort(array);
        int i = 0, j = nums.length -1;
        int[] result = new int[2];
        while(i < j){
            int temp = array[i].value + array[j].value;
            if(temp == target){
                break;
            }else if(temp > target)
                j--;
            else
                i++;
        }
        result[0] = array[i].index;
        result[1] = array[j].index;
        return result;
    }

    /**
     * 第二种方案
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(target - nums[i])){
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = twoSum1(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));
    }
}
