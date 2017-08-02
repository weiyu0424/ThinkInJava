package com.weiyu.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Wei Yu on 2017/6/30.
 * 求一个数和一个字符串的全排列
 */
public class QuanPaiLie {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(null == str || str.length() == 0)
            return list;
        list.add(str);
        if(1 == str.length()){
            return list;
        }
        char[] array = str.toCharArray();
        while(true){
            int length = array.length;
            int item = length - 2;

            //1.从字符串从右往左找到第一个非增的位置i
            while(item >= 0 && array[item] >= array[item + 1]){
                item--;
            }

            //如果item的位置小于0，则跳出循环
            if(item < 0)
                break;

            //2.再从右往左找到第一个比str.charAt(i)大的数
            int i = length - 1;
            while(i >= 0){
                if(array[i] > array[item])
                    break;
                else
                    i--;
            }

            //3.交换两个位置的值
            swap(array,item,i);

            //4.从i+1开始，将数组逆置
            reverse(array,item + 1);
            list.add(new String(array));
        }
        return list;
    }


    /**
     * 将数组从i+1的位置逆置
     *
     * @param array
     * @param i
     */
    private void reverse(char[] array, int i) {
        int j = array.length - 1;
        while (i <= j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

    /**
     * 交换数组中两个位置的值
     *
     * @param array
     * @param item
     * @param i
     */
    private void swap(char[] array, int item, int i) {
        char temp = array[item];
        array[item] = array[i];
        array[i] = temp;
    }


    public static void main(String... args) {
        String str = "aabc";
        ArrayList<String> list = new QuanPaiLie().Permutation(str);
        System.out.println(list);
    }
}
