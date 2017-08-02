package com.weiyu.thinkinginjava.pattern;

/**
 * Created by Wei Yu on 2017/6/8.
 * 标准的饿汉式单例模式
 */
public class SingleInstance {
    private static SingleInstance instance;

    private SingleInstance(){}

    public static SingleInstance getInstance(){
        if(null == instance){
            instance = new SingleInstance();
        }
        return instance;
    }
}
