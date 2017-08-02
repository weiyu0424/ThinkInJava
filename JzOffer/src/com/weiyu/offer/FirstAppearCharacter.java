package com.weiyu.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Wei Yu on 2017/7/6.
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class FirstAppearCharacter {
    public int firstNotRepeatingChar(String str) {
        char[] array = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < array.length;i++){
            char c = array[i];
            int repeat = map.get(c) == null ? 1 : map.get(c) + 1;
            map.put(c,repeat);
        }

        for(int i = 0;i < array.length;i++){
            if(1 == map.get(array[i]))
                return i;
        }
        /*Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Character,Integer> entry = iterator.next();
            if(1 == entry.getValue()){
                return str.indexOf(entry.getKey());
            }
        }*/
        return -1;
    }

    public static void main(String... args){
        int index = new FirstAppearCharacter().firstNotRepeatingChar("google");
        System.out.println(index);
    }
}
