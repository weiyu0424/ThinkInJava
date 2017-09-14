package com.weiyu.offer.zhaoyin;

/**
 * Created by xpZhu on 2017/9/13.
 */
class A{
    static {
        System.out.print("A");
    }
    public A(){
        System.out.print("a");
    }
}

class B extends A{
    static{
        System.out.print("B");
    }

    public B(){
        System.out.print("b");
    }
}
public class Hello {
    public static void main(String[] args) {
        A ab = new B();
        ab = new B();
    }

}
