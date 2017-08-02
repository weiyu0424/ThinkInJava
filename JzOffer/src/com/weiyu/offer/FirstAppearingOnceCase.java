package com.weiyu.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wei Yu on 2017/7/29.
 */
public class FirstAppearingOnceCase {
    private List<Character> chars = new ArrayList<>();
    private Map<Character,Integer> map = new HashMap<>();
    public void Insert(char ch)
    {
        map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        chars.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(char ch : chars){
            if(map.get(ch) == 1)
                return ch;
        }
        return '#';
    }
}
