package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/9/7.
 */
public class P8_MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (null == array)
            return -1;
        int left = 0;
        int right = array.length - 1;
        int minIndex = left;


        while (array[left] >= array[right]) {
            int midIndex = (left + right) >> 1;
            if (right == 1 + left) {
                minIndex = right;
                break;
            }

            //如果array[left] == array[right]并且array[left] == array[midIndex]的话，得重头开始找
            if(array[left] == array[right] && array[left] == array[midIndex]){
                return getMinValue(array,left,right);
            }

            if (array[midIndex] >= array[left]) {
                left = midIndex;
            }

            if (array[midIndex] <= array[right]) {
                right = midIndex;
            }
        }
        return array[minIndex];
    }

    private int getMinValue(int[] array,int left,int right) {
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < array[i - 1]) {
                return array[i];
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int result = new P8_MinNumberInRotateArray().minNumberInRotateArray(new int[]{1, 1, 2, 1, 1, 1});
        System.out.println(result);
    }
}
