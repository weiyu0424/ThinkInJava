package com.weiyu.offer;

import com.weiyu.offer.thread.TwinsLock;
import com.weiyu.offer.utils.SleepUtils;

import java.util.concurrent.locks.Lock;

/**
 * Created by Wei Yu on 2017/7/17.
 */
public class TwinsLockTest {
    public static void main(String... args){
        Lock lock = new TwinsLock();
        class Worker extends Thread{
            @Override
            public void run() {
                while(true){
                    lock.lock();
                    try{
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }

        for(int i = 0;i < 10;i++){
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }

        for(int i = 0;i < 10;i++){
            SleepUtils.second(1);
            System.out.println();
        }
    }
}
