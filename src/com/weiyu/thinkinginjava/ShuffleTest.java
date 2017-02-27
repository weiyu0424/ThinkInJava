package com.weiyu.thinkinginjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by weiyu on 2017/2/10.
 */
public class ShuffleTest {
    public static void main(String... args){
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0;i < 49;i++){
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> winningCombination = numbers.subList(0,6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);
    }
}
