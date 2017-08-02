package com.weiyu.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wei Yu on 2017/7/28.
 */
public class RepetitionNum {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(null == numbers || 0 == numbers.length)
            return false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : numbers){
            if(map.containsKey(num)){
                duplication[0] = num;
                map.put(num,map.get(num) + 1);
                return true;
            }else{
                map.put(num,1);
            }
        }
        return false;
    }
}
