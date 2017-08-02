package com.weiyu.thinkinginjava.pattern;

/**
 * Created by Wei Yu on 2017/6/8.
 */
public class SingleInstanceWithHungaryEnum {
    private static class SingleInstanceHolder{
        private static final SingleInstanceWithHungaryEnum INSTANCE = new SingleInstanceWithHungaryEnum();
    }

    private SingleInstanceWithHungaryEnum(){

    }

    public static SingleInstanceWithHungaryEnum getInstance(){
        return SingleInstanceHolder.INSTANCE;
    }

    public void hello(){
        System.out.println("hello");
    }

    public static void main(String... args){
        SingleInstanceWithHungaryEnum instance = SingleInstanceWithHungaryEnum.getInstance();
        instance.hello();
    }
}
