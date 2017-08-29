package com.weiyu.offer.thread.blog;

/**
 * Created by Wei Yu on 2017/8/27.
 */
public class StaticSynchronized {
    public static int count = 0;
    public synchronized void inc(){
        count++;
    }

    public static synchronized void inc2(){
        count++;
    }

    public static void main(String[] args) {
        for(int i = 0;i < 100000;i++){
            new Thread(() -> {
                StaticSynchronized lock = new StaticSynchronized();
//                lock.inc();
                lock.inc2();
//                StaticSynchronized.inc2();
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
