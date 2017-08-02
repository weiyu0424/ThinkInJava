package com.weiyu.thinkinginjava.pattern;

/**
 * Created by Wei Yu on 2017/6/8.
 */
public class SingleInstanceWithHungaryStatic {
    private static class SingleInstanceHolder{
        private static final SingleInstanceWithHungaryStatic INSTANCE = new SingleInstanceWithHungaryStatic();
    }

    private SingleInstanceWithHungaryStatic(){

    }

    public static SingleInstanceWithHungaryStatic getInstance(){
        return SingleInstanceHolder.INSTANCE;
    }

    public void hello(){
        System.out.println("hello");
    }

    public static void main(String... args){
        SingleInstanceWithHungaryStatic instance = SingleInstanceWithHungaryStatic.getInstance();
        instance.hello();
    }
}
