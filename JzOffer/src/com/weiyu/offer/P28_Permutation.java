package com.weiyu.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Wei Yu on 2017/6/30.
 * 求一个数和一个字符串的全排列
 */
public class P28_Permutation {

    public ArrayList<String> permutation(String str){
        char[] array = str.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        permutationHelper(array,0,result);
        Collections.sort(result);
        return result;
    }

    private void permutationHelper(char[] array, int i, List<String> result) {
        if(i == array.length - 1){
            String value = String.valueOf(array);
            if(!result.contains(value))
                result.add(value);
        }else{
            for(int j = i;j < array.length;j++){
                swap(array,i,j);
                permutationHelper(array,i + 1,result);
                swap(array,i,j);
            }
        }
    }


    //求组合数 C(m,n)
    public static int C(int m,int n){
        int c = 1;
        int k = 1;
        for (int i = 1;i <= m;i++){
            c = c * (n + 1 - i);
            k = k * i;
        }
        return (c / k);
    }

    //获取str中所有长度为m的子串
    //递归方法
    public static String[] getSubString(String str,int m){
        String[] s;//保存子串
        int count = 0;//子串计数器
        int n = str.length();//原字符串长度
        if (m > n || m <= 0){
            s = new String[]{};
            return s;//如果子串长度大于字符串长度，或子串长度小于等于0，则不会有满足要求的子串
        }else{
            s = new String[C(m,n)];//保存子串，子串个数为C(m,n)
        }
        if (m == 1){//若子串长度为1，则返回字符串的每个字符即可
            int i;
            for (i = 0;i < str.length();i++){
                count++;
                s[count - 1] = "" + str.charAt(i);
            }
        }else{//否则，长度为m的子串由长度为m-1的子串再加一个字符组成
            for (int j = m - 1;j < str.length();j++){
                String[] ss = getSubString(str.substring(0, j),m - 1);
                for (int k = 0;k < ss.length;k++){
                    count++;
                    s[count - 1] = ss[k] + str.charAt(j);
                }
            }
        }
        return s;
    }

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
        String str = "abcd";
        ArrayList<String> list = new P28_Permutation().permutation(str);
        System.out.println(list);

        String[] results = getSubString(str, 3);
        System.out.println(Arrays.toString(results));
    }
}
