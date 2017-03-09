package com.weiyu.thinkinginjava;

/**
 * Created by weiyu on 2017/2/27.
 */
class A{
    private int i;
    private int j;
    /*public A(int i,int j){
        this.i = i;
        this.j = j;
    }*/
}
abstract class Person extends A{
    public abstract void print();
    public void hello(){
        System.out.println("hello,world");
    }
}


public class AbstractTest {
    public static void main(String... args){
        new Person(){

            @Override
            public void print() {
                System.out.println("hello,print");
            }
        }.print();
    }
}
