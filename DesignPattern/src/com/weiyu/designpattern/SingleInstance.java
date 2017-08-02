package com.weiyu.designpattern;

/**
 * Created by Wei Yu on 2017/7/10.
 * 单例模式
 * 使用懒加载模式，即恶汉模式时，如果是多线程下的单例模式，则需要进行线程同步
 *
 * 出现的问题：
 * instance = new SingleInstance();时，正常情况下，编译器的处理步骤是：
 * 1. 分配内存空间
 * 2. 初始化对象
 * 3. 设置instance值指向刚分配的内存地址
 * 但是会出现2跟3重排的现象。这时候如果线程A中2跟3重排了，当线程A执行到第三个步骤时，这时步骤2还没有执行，这时候如果线程B再去执行的时候，instance就不为空，
 * 但是实际上这时候instance还没有被真正的初始化，所以会出现问题。这时候的解决方案就是：禁止步骤2跟3进行重排
 *
 * 一般情况下有两种方法：
 * 1）将instance变量设置为volatile类型
 * 2）基于类初始化的解决方案
 */
public class SingleInstance {
    private volatile static SingleInstance instance = null;
    private SingleInstance(){}

    public static SingleInstance getInstance(){
        if(null == instance){
            synchronized (SingleInstance.class){
                if(null == instance) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }

    public void print(){
        System.out.println("hello,world");
    }

    public static void main(String... args){
        for(int i = 0;i < 1000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingleInstance instance = SingleInstance.getInstance();
                    instance.print();
                }
            }).start();
        }
    }

}
