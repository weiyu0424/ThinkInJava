package com.weiyu.offer.thread;

import com.weiyu.offer.utils.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Wei Yu on 2017/7/12.
 */
public class ProducerConsumer {
    static boolean flag = true;
    static int count = 10;
    static Object producer = new Object();
    static Object consumer = new Object();


    public static void main(String... args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(),"WaitThread");
        waitThread.start();
//        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(),"NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable{
        @Override
        public void run() {
            synchronized(consumer){
                while(count > 0){
                    try {
                        System.out.println(Thread.currentThread() + " 消费者正在消费：i=" + count--);
                        if(count < 1){
                            consumer.wait();
                            producer.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    static class Notify implements Runnable{
        @Override
        public void run() {
            synchronized(producer){
                while(count < 10){
                    System.out.println(Thread.currentThread() + " 生产者正在生产：count:" + (++count));

                    if(count >= 10){
                        try {
                            consumer.notify();
                            producer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            /*synchronized (producer){
                System.out.println(Thread.currentThread() + " hold producer again. sleep @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }*/
        }
    }
}
