package com.weiyu.offer.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Wei Yu on 2017/7/23.
 * 让一组线程到达一个屏障时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续运行
 */
public class CyclicBarrierTest {
    static CyclicBarrier barrier = new CyclicBarrier(2,new A());

    public static void main(String... args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();

        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(2);
    }

    static class A implements Runnable{
        @Override
        public void run() {
            System.out.println("到达屏障的时候，先执行...");
        }
    }
}
