package com.weiyu.offer.dahua;

import java.util.HashMap;

/**
 * Created by Wei Yu on 2017/9/12.
 */
public class Dahua extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run");
    }

    public static void main(String[] args) {
//        Dahua dahua = new Dahua();
//        dahua.run();
//        System.out.println("main");

        HashMap<String,String> map = new HashMap<>();
        map.put("dahua",null);
        map.put("dahua","dahua");
        map.put("dahua1","dahua");
        System.out.println(map.size());
    }

    //while循环实现
    int binarySearch(int array[], int n, int value){
        int left = 0;
        int right = n-1;
        while (left <= right){
            int middle = left + ((right - left) >> 2);
            if (array[middle] > value){
                right = middle - 1;
            }
            else if(array[middle] < value){
                left = middle + 1;
            }
            else{
                return middle;
            }
        }
        return -1;
    }


    //递归实现
    int binarySearchRecursive(int array[], int left, int right, int value){
        if (left > right){
            return -1;
        }
        int middle = left + ((right - left) >> 2);
        if (array[middle] > value){
            return binarySearchRecursive(array, left, middle - 1, value);
        }else if (array[middle] < value){
            return binarySearchRecursive(array, middle + 1, right, value);
        }else{
            return middle;
        }
    }
}
