package com.weiyu.offer.offer.three60;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Wei Yu on 2017/8/26.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] nums = new int[length];
        for(int i = 0;i < length;i++){
            nums[i] = in.nextInt();
        }
        if(1 == length){
            Arrays.toString(nums);
            return;
        }
        int result[] = getHigherThanMe(nums);

        in.close();
    }

    private static int[] getHigherThanMe(int[] nums) {
        return null;
    }
}
