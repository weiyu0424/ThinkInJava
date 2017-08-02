package com.weiyu.offer.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Wei Yu on 2017/7/23.
 */
public class CountDownLatchTest {
    static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String... args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"hello,world1").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"hello,world2").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"hello,world3").start();

        System.out.println("hi,how are you?");
        latch.countDown();
        Thread.sleep(100);
        System.out.println("beginning!");
    }
}
