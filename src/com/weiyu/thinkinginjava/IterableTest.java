package com.weiyu.thinkinginjava;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Wei Yu on 2017/7/5.
 */
public class IterableTest implements Iterable<String>{
    String[] words = ("This is southeast university, a world famous university!").split(" ");


    public IterableTest(){
        Arrays.sort(words);
    }
    @Override
    public Iterator<String> iterator() {

        Iterator<String> iterator =  new Iterator<String>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        };
        return iterator;
    }

    public static void main(String... args){
        IterableTest test = new IterableTest();
        for(String str : test){
            System.out.println(str);
        }
    }
}
