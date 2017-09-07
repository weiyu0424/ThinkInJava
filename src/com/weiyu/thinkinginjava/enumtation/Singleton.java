package com.weiyu.thinkinginjava.enumtation;

/**
 * Created by Wei Yu on 2017/9/4.
 */
public enum Singleton{
    INSTANCE;

    public Singleton getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        System.out.println(singleton.name());
    }
}
