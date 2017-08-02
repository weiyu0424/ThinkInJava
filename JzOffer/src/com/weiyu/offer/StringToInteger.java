package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/7/25.
 */
public class StringToInteger {
    public int StrToInt(String str) {
        int length = str.length();
        int sum = 0;
        int temp = 1;
        char[] array = str.toCharArray();
        for(int i = length - 1;i >= 0;i--){
            int item = array[i] - '0';
            if(item >= 0 && item <= 9){
                sum += item * temp;
                if(sum > Integer.MAX_VALUE)
                    return 0;
                temp *= 10;
            }else{
                if(0 == i && (array[i] == '+') || array[i] == '-'){
                    if('+' == array[i]){
                        return sum;
                    }else{
                        return -sum;
                    }
                }else{
                    return 0;
                }
            }
        }
        return sum;
    }

    public static void main(String... args){
        int result = new StringToInteger().StrToInt("123");
        System.out.println(result);
    }
}
