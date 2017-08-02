package com.weiyu.thinkinginjava;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Wei Yu on 2017/7/20.
 */
public class ConcurrentLinkedQueueTest {
    public static void main(String... args){
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.offer("Hello");
        queue.offer("World");
        Iterator<String> iterator = queue.iterator();
        while(iterator.hasNext()){
            String text = iterator.next();
            System.out.println(text);
        }
    }
}
