package com.weiyu.offer.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Wei Yu on 2017/7/2.
 */
public class AtomOperation {
    private AtomicInteger atomicI = new AtomicInteger(0);
    private volatile int i = 0;

    public static void main(String... args) {
        final AtomOperation operation = new AtomOperation();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        operation.count();
                        operation.safeCount();
                    }
                }
            });
            ts.add(t);
        }
        for (Thread t : ts) {
            t.start();
        }


        for(Thread t : ts){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long interval = System.currentTimeMillis() - start;
        System.out.println("i:" + operation.i + "--atomicI:" + operation.atomicI.get() + "=====time:" + interval);

    }

    private void safeCount() {
        for (; ; ) {
            int i = atomicI.get();
            boolean success = atomicI.compareAndSet(i, ++i);
            if (success)
                break;
        }
    }

    private void count() {
        i++;
    }
}
