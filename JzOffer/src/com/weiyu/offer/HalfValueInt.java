package com.weiyu.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wei Yu on 2017/6/30.
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class HalfValueInt {
    public int solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i < array.length;i++){
            if(null == map.get(array[i])){
                map.put(array[i],1);
            }else{
                map.put(array[i],map.get(array[i]) + 1);
            }
        }

        int rule = array.length / 2;
        for(Integer key : map.keySet()){
            Integer value = map.get(key);
            if(value > rule){
                return key;
            }
        }
        return 0;
    }

    public static void main(String... args){
        int[] array = {1,2,3,2,2,2,5,4,2};
        int result = new HalfValueInt().solution(array);
        System.out.println(result);
    }
}
