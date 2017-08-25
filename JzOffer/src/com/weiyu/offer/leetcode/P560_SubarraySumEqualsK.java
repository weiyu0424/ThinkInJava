package com.weiyu.offer.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wei Yu on 2017/8/22.
 */
public class P560_SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        if (null == nums)
            return 0;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (k == sum) {
                    count++;
                    break;
                } else if (sum > k)
                    break;
            }
        }
        return count;
    }

    public static int subarraySum1(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    public static int subarraySum2(int[] nums, int k) {
        if (null == nums)
            return 0;
        Map<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int sum = 0;
        int count = 0;
        for(int num : nums){
            sum += num;
            count += preSum.getOrDefault(sum - k,0);
            preSum.put(sum,preSum.getOrDefault(sum,0) + 1);
        }
        return count;
    }



    public static void main(String[] args) {
        //int result = subarraySum1(new int[]{1, 2, 3, 4, 5, 6, 7, 1, 23, 21, 3, 1, 2, 1, 1, 1, 1, 1, 12, 2, 3, 2, 3, 2, 2}, 1);
        //int result = subarraySum(new int[]{3,1,2,3,4,5,6,7}, 10);
        int result = subarraySum2(new int[]{1,2,1,2,1}, 3);
        System.out.println(result);
    }
}
