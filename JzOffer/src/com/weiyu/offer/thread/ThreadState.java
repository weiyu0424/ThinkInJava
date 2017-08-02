package com.weiyu.offer.thread;

import com.weiyu.offer.utils.SleepUtils;

/**
 * Created by Wei Yu on 2017/7/11.
 */
public class ThreadState {
    public static void main(String[] args){
        new Thread(new TimeWaiting(),"TimeWaitingThread").start();
        new Thread(new Waiting(),"WaitingThread").start();
        new Thread(new Blocked(),"BlockedThread-1").start();
        new Thread(new Blocked(),"BlockedThread-2").start();
    }

    //该线程不断进行睡眠
    static class TimeWaiting implements Runnable{
        @Override
        public void run() {
            while(true){
                SleepUtils.second(100);
            }
        }
    }

    //该线程在Waiting.class上等待
    static class Waiting implements Runnable{
        @Override
        public void run() {
            while(true){
                synchronized (Waiting.class){
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //该线程在Blocked实例上加锁之后，不会释放锁
    static class Blocked implements Runnable{
        @Override
        public void run() {
            synchronized (Blocked.class){
                SleepUtils.second(100);
                /*try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }
}
