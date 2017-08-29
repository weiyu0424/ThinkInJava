package com.weiyu.offer.offer.lianjia;

import java.util.*;

public class Main1 {
    static class Stick implements Comparable<Stick>{
        public int length;
        public int quality;

        @Override
        public int compareTo(Stick stick) {
            if(this.length > stick.length)
                return 1;
//            else if(this.length < stick.length)
//                return -1;
            return -1;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            Stick[] sticks = new Stick[num];
            for(int i = 0;i < num;i++){
                sticks[i] = new Stick();
                sticks[i].length = in.nextInt();
                sticks[i].quality = in.nextInt();
            }

            Arrays.sort(sticks);
            if(1 == num)
                System.out.println(1);

            int[] quality = new int[num];
            for(int i = 0;i < sticks.length;i++){
                quality[i] = sticks[i].quality;
            }
            List<Integer> result = getLongestDecreaseSubSequence(quality);
            System.out.println(result);
            System.out.println(result.size());

//            int[] dp = new int[num];
//            for(int i = 0;i <= sticks.length - 1;i++){
//                dp[i] = 1;
//                for(int j = 0;j < i - 1;j++)
//                    if(sticks[j].quality > sticks[i].quality && dp[j] + 1 > dp[i])
//                        dp[i] = dp[j] + 1;
//            }
//
//
//            int count = 0;
//            for(int i = 0;i <= sticks.length - 1;i++)
//                count = Math.max(count,dp[i]);

//            System.out.println(count);
        }
        in.close();
    }

    public static List<Integer> getLongestDecreaseSubSequence(int[] nums) {
        int[] dp = new int[nums.length];
        int[] priors = new int[nums.length];//用于记录当前以该元素为最小元素的递减序列中该元素的前驱节点，用于打印序列
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        List<Integer> result = new ArrayList<>();//存储递减子序列
        int max = 0;//存储子序列的长度
        int endIndex = 0;//存储子序列的最后一个元素的下标
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {//说明连续
                dp[i] = dp[i - 1] + 1;
                priors[i] = i - 1;
            } else {//不连续的话要从第一个开始比较，取最长的一个
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i] && (dp[j] + 1) > dp[i]) {
                        dp[i] = dp[j] + 1;
                        priors[i] = j;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                endIndex = i;
            }
        }

        //将子序列取出加入链表，作为结果返回
        while (max > 0) {
            result.add(0, nums[endIndex]);
            endIndex = priors[endIndex];//priors数组中依次存储的是以当前元素作为子序列的前一个节点的下标
            max--;
        }
        return result;
    }
}
