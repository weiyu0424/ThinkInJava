package com.weiyu.offer.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Wei Yu on 2017/7/23.
 */
public class SemaPhoreTest {
    public static final int THREAD_COUNT = 30;
    private static ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(10);

    public static void main(String... args){
        for(int i = 0;i < THREAD_COUNT;i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data");
                        s.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        service.shutdown();
    }
}
