package com.weiyu.offer.java8.java8.interf;

/**
 * Created by Wei Yu on 2017/8/27.
 */
public class SubDefaultInterface implements DefaultInterface {

    @Override
    public void print() {
        System.out.println("hello,print()");
    }

    public static void main(String[] args) {
        DefaultInterface interf = new SubDefaultInterface();
        interf.count();
        DefaultInterface.helloworld();
        interf.print();
    }
}
