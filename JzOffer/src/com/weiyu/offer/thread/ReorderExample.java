package com.weiyu.offer.thread;

/**
 * Created by Wei Yu on 2017/7/4.
 * 重排序对多线程的影响
 */
public class ReorderExample {
    int a = 0;
    boolean flag = false;
    public synchronized void writer(){
        a = 1;
        //System.out.println("A:" + a);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
    }

    public synchronized void reader(){
        if(flag){
            int i = a * a;
            System.out.println(i);
        }
    }

    public static void main(String... args){
        ReorderExample reorder = new ReorderExample();
        new Thread(new Runnable() {
            @Override
            public void run() {
                reorder.writer();
            }
        }).start();

        /*try {
            new Thread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                reorder.reader();
            }
        }).start();
    }
}
