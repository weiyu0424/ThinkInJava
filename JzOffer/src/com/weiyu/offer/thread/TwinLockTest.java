package com.weiyu.offer.thread;

import com.weiyu.offer.utils.SleepUtils;

import java.util.concurrent.locks.Lock;

/**
 * Created by Wei Yu on 2017/8/9.
 */
public class TwinLockTest {
    public static void main(String[] args) {
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

        for(int i = 0; i < 10;i++){
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        for(int i = 0;i < 10;i++){
            SleepUtils.second(1);
            System.out.println();
        }
    }
}
