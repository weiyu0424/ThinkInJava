package com.weiyu.designpattern;

/**
 * Created by Wei Yu on 2017/7/10.
 */
public class InstanceFactory {

    private InstanceFactory(){}

    private static class InstanceHolder{
        public static InstanceFactory instance = new InstanceFactory();
    }

    public static InstanceFactory getInstance(){
        return InstanceHolder.instance;
    }

    public void print(){
        System.out.println("Hello");
    }

    public static void main(String... args){
        InstanceFactory instance = InstanceFactory.getInstance();
        instance.print();
    }
}
