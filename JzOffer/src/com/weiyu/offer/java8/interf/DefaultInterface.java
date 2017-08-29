package com.weiyu.offer.java8.interf;

/**
 * Created by Wei Yu on 2017/8/27.
 */
public interface DefaultInterface {
    void print();

    static void helloworld(){
        System.out.println("hello,world");
    }

    default int count(){
        int count = 1;
        System.out.println(count);
        return count;
    }
}
