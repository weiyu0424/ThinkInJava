package com.weiyu.thinkinginjava;

/**
 * Created by weiyu on 2017/2/17.
 */
public class ThreadTest {
    public static void main(String... args){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("2");
            }
        });
        t.start();

        /*try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("1");

    }
}
