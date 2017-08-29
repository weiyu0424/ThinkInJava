package com.weiyu.offer.thread.blog;

/**
 * Created by Wei Yu on 2017/8/27.
 */
public class SynchronizedBlock implements Runnable{
    public synchronized void f(){
        System.out.println("f()");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        while(true)
//            Thread.yield();
    }

    public SynchronizedBlock(){
        /*new Thread(){
            @Override
            public void run() {
                f();
            }
        }.start();*/
    }

    @Override
    public void run() {
        while(true){
            if(Thread.interrupted()){
                System.out.println("线程中断");
                break;
            }else{
                f();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedBlock lock = new SynchronizedBlock();
        Thread thread = new Thread(new SynchronizedBlock());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
