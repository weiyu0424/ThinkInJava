package com.weiyu.offer.zhaoyin;

/**
 * Created by xpZhu on 2017/9/13.
 */
public class DemoThread extends Thread{
    public static void main(String[] args) {
        /*DemoThread thread1 = new DemoThread();
        DemoThread thread2 = new DemoThread();
        thread1.start();
        System.out.print("thread one");
        thread2.start();
        System.out.print("thread two");*/

        int i = 0;
        while(i < (i++) + 1);
        System.out.println(i);

    }

    @Override
    public void run() {

        System.out.print("Thread.");
    }
}
