package com.weiyu.offer.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by Wei Yu on 2017/7/12.
 * 线程中Join方法的使用：thread.join()方法表示：等待thread线程终止之后才从thread.join()返回。
 */
public class Join {
    public static void main(String... args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for(int i = 0;i < 10;i++){
            Thread thread = new Thread(new Domino(previous),String.valueOf(i));
            thread.start();
            previous = thread;
        }

        //TimeUnit.SECONDS.sleep(5);

        System.out.println(Thread.currentThread().getName() + " terminated.");
    }

    static class Domino implements Runnable{
        Thread thread = null;
        public Domino(Thread thread){
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() +" terminated");
        }
    }
}
