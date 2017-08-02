package com.weiyu.thinkinginjava.thread;

/**
 * Created by Wei Yu on 2017/6/7.
 * volatile关键字的作用：1、可见性；2、禁止指令重排
 * synchronized关键字的作用：1、可见性；2、原子性
 */
public class Mythread extends Thread {
    private volatile boolean isStop = false;

    @Override
    public void run() {
        while(!isStop){
            System.out.println("do something!");
        }
    }
    public void setStop(){
        isStop = true;
    }

    public static void main(String... args){
        Mythread mythread = new Mythread();
        mythread.start();
        try {
            mythread.sleep(10000);
            mythread.setStop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
