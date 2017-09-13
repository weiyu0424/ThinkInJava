package com.weiyu.offer.dahua;

/**
 * Created by Wei Yu on 2017/9/12.
 */
public class Find {
    public static int binarySearch(int[] array, int data) {
        int start = 0;
        int end = array.length - 1;
        while ((start <= end) && (start <= array.length - 1) && (end <= array.length - 1)) {
            int midIndex = (start + end) / 2;
            if (data == array[midIndex]) {
                return midIndex;
            } else if (data < array[midIndex]) {
                end = midIndex - 1;
            } else {
                start = midIndex + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int data, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        if (data < array[start] || data > array[end] || start > end) {
            return -1;
        }
        if (data < array[midIndex]) {
            return binarySearch(array, data, start, midIndex - 1);
        } else if (data > array[midIndex]) {
            return binarySearch(array, data, midIndex + 1, end);
        } else {
            return midIndex;
        }
    }
}
