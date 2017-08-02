package com.weiyu.thinkinginjava.pattern;

/**
 * Created by Wei Yu on 2017/6/8.
 * 基于线程安全的饿汉式单例模式
 */
public class SingleInstanceWithThreadSafety {
    private static SingleInstanceWithThreadSafety instance;

    private SingleInstanceWithThreadSafety(){}

    public static synchronized SingleInstanceWithThreadSafety getInstance(){
        if(null == instance)
            instance = new SingleInstanceWithThreadSafety();
        return instance;
    }
}
