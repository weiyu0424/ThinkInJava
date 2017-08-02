package com.weiyu.thinkinginjava;

/**
 * Created by weiyu on 2017/3/20.
 * 静态代码块、非静态代码块，构造函数的执行顺序
 */

class Father{
    private static int hello = 1;
    static{
        System.out.println("I am the father!");
    }
    static {
        System.out.println("hello:" + hello);
    }
    {
        System.out.println("I am dynamic style father!");
    }
    public Father(){
        System.out.println("I am the father constructor!");
    }
}
public class PriorityTest extends Father{
    static{
        System.out.println("I am the son!");
    }
    {
        System.out.println("I am dynamic style son!");
    }

    public PriorityTest(){
        System.out.println("I am son ocnstructor!");
    }

    public static void main(String... args){
        PriorityTest test = new PriorityTest();
    }
}
