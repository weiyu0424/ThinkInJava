package com.weiyu.offer.leetcode;

/**
 * Created by Wei Yu on 2017/8/21.
 */
public class P42_TrappingRainingWater {
    public static void main(String[] args) {
        int [] testcase_1 = {2,5,1,2,3,4,7,7,6};
        int [] testcase_2 = {2,5,1,3,1,2,1,7,7,6};
        int [] testcase_3 = {6,1,4,6,7,5,1,6,4};

        System.out.println("Case testcase_1, total volume :" + calculate(testcase_1));
        System.out.println("Case testcase_2, total volume :" + calculate(testcase_2));
        System.out.println("Case testcase_3, total volume :" + calculate(testcase_3));

        System.out.println("================================");
        System.out.println("Case testcase_1, total volume :" + calculate1(testcase_1));
        System.out.println("Case testcase_2, total volume :" + calculate1(testcase_2));
        System.out.println("Case testcase_3, total volume :" + calculate1(testcase_3));
        System.out.println("================================");
        System.out.println("Case testcase_1, total volume :" + calculate2(testcase_1));
        System.out.println("Case testcase_2, total volume :" + calculate2(testcase_2));
        System.out.println("Case testcase_3, total volume :" + calculate2(testcase_3));
    }

    private static int calculate(int [] testcase){
        int p_l = 0;
        int p_r = testcase.length - 1;
        int max_l = testcase[p_l];
        int max_r = testcase[p_r];

        int volume = 0;
        while (p_r > p_l) {
            if (max_l < max_r){
                p_l++;
                if (testcase[p_l] >= max_l){
                    max_l = testcase[p_l];
                }else{
                    volume += max_l - testcase[p_l];
                }
            }else{
                p_r--;
                if (testcase[p_r] >= max_r){
                    max_r = testcase[p_r];
                }else{
                    volume += max_r - testcase[p_r];
                }
            }
        }

        return volume;
    }


    public static int calculate1(int[] array){
        if(null == array || array.length < 3)
            return 0;
        int maxValue = Integer.MIN_VALUE;
        int secondValue = Integer.MIN_VALUE;
        int maxIndex = 0,secondIndex = 0;
        for(int i = 0;i < array.length;i++){
            if(array[i] > maxValue){
                secondIndex = maxIndex;
                secondValue = maxValue;
                maxValue = array[i];
                maxIndex = i;
            }else if(array[i] > secondValue){
                secondValue = array[i];
                secondIndex = i;
            }
        }

        int leftIndex = 0;
        int rightIndex = 0;
        if(secondIndex < maxIndex){
            leftIndex = secondIndex;
            rightIndex = maxIndex;
        }else{
            leftIndex = maxIndex;
            rightIndex = secondIndex;
        }

        int leftMax = array[0];
        int rightMax = array[array.length - 1];
        int volume = 0;
        for(int i = 1;i < leftIndex;i++){
            if(array[i] >= leftMax){
                leftMax = array[i];
            }else{
                volume += (leftMax - array[i]);
            }
        }

        for(int i = array.length - 2;i > rightIndex;i--){
            if(array[i] >= rightMax){
                rightMax = array[i];
            }else{
                volume += (rightMax - array[i]);
            }
        }

        for(int i = leftIndex + 1;i < rightIndex;i++){
            volume += (secondValue - array[i]);
        }

        return volume;
    }

    public static int calculate2(int[] array){
        if(null == array || array.length < 3){
            return 0;
        }

        int maxLeft = array[0],maxRight = array[array.length - 1];
        int left = 0, right = array.length - 1;
        int volume = 0;
        while(left < right){
            if(maxLeft < maxRight){
                left++;
                if(array[left] >= maxLeft)
                    maxLeft = array[left];
                else
                    volume += (maxLeft - array[left]);
            }else{
                right--;
                if(array[right] >= maxRight)
                    maxRight = array[right];
                else
                    volume += (maxRight - array[right]);
            }
        }
        return volume;
    }
}
