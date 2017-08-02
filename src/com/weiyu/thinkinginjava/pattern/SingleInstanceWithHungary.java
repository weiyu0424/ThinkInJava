package com.weiyu.thinkinginjava.pattern;

/**
 * Created by Wei Yu on 2017/6/8.
 */
public class SingleInstanceWithHungary {
    private static final SingleInstanceWithHungary instance = new SingleInstanceWithHungary();

    private SingleInstanceWithHungary(){

    }

    public static SingleInstanceWithHungary getInstance(){
        return instance;
    }

}
