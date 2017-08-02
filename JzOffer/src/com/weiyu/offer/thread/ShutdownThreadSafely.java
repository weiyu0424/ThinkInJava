package com.weiyu.offer.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by Wei Yu on 2017/7/11.
 */
public class ShutdownThreadSafely {
    public static void main(String... args) throws InterruptedException {
        Thread countThread = new Thread(new Runner(),"One");
        countThread.start();
        //默认情况下是一直在执行i++的，只有调用了interrupt()方法或者调用cancel()方法之后才会终止

        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two,"Two");
        countThread.start();

        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    private static class Runner implements Runnable{
        private long i = 0;
        private volatile boolean on = true;
        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + thread.isInterrupted());
            while(on && !thread.isInterrupted()){
                i++;
            }

            System.out.println("Count i:" + i);
        }

        public void cancel(){
            on = false;
        }
    }
}
