package com.weiyu.thinkinginjava.pattern;

/**
 * Created by Wei Yu on 2017/6/8.
 * 基于线程安全的双重检验锁单例模式
 */
public class SingleInstanceWithDoubleCheck {
    private volatile static SingleInstanceWithDoubleCheck instance;

    private SingleInstanceWithDoubleCheck(){}

    public static SingleInstanceWithDoubleCheck getInstance(){
        if(null == instance) {
            synchronized (SingleInstanceWithDoubleCheck.class){
                if(null == instance)
                    instance = new SingleInstanceWithDoubleCheck();
            }
        }
        return instance;
    }
}
