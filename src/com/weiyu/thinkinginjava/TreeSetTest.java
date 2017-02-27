package com.weiyu.thinkinginjava;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by weiyu on 2017/1/3.
 */
public class TreeSetTest {
    public static void main(String... args){
       /* TreeSet set = new TreeSet<String>();
        set.add("hello");
        set.add("love");
        set.add("weiyu");
        set.add("envy");

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            String value = (String) iterator.next();
            System.out.println(value);
        }

        System.out.println(set);*/


       int[] array = {-1,-1,-1,-1,-2};
        int max = findMaxDivision(array,array.length);
        System.out.println("max:" + max);
    }


    public static int findMaxDivision(int[] A, int n) {
        // write code here
        if(A == null)
            return 0;
        if(n < 2 || n > 500)
            return 0;
        Set<Integer> data = new TreeSet<Integer>();
        for(int i = 0;i < n; i++){
            data.add(A[i]);
        }

        int max = 0;
        Iterator<Integer> results = data.iterator();
        int previous = results.next();
        while(results.hasNext()){
            int item = results.next();
            if(max < (item - previous)){
                max = item - previous;
            }
            previous = item;
        }
        return max;
    }
}
