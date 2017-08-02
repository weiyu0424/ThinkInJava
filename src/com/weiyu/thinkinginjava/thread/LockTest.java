package com.weiyu.thinkinginjava.thread;

/**
 * Created by Wei Yu on 2017/6/8.
 * 生产者消费者
 */
class Producer implements Runnable{
    @Override
    public void run() {
        int count = LockTest.count;
        while(count <= 10) {
            synchronized (LockTest.obj) {
                LockTest.count++;
                System.out.println("生产者生产产品：" + LockTest.count + "个");
                if (LockTest.count >= 10) {
                    System.out.println("生产了足够的产品，待消费...");
                    LockTest.obj.notify();

                    try {
                        LockTest.obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


class Consumer implements Runnable{

    @Override
    public void run() {
        int count = LockTest.count;
        while(count > 0){
            synchronized (LockTest.obj){
                LockTest.count--;
                System.out.println("消费者正在消费商品，现在有" + LockTest.count  + "个");
                if(LockTest.count <= 0){
                    System.out.println("商品正缺货，待生产");
                    LockTest.obj.notify();
                    try {
                        LockTest.obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
public class LockTest{
    public static final Object obj = new Object();
    public static int count = 0;
    public static void main(String... args){
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

}
