package com.weiyu.offer.thread;

import com.weiyu.offer.utils.SleepUtils;

/**
 * Created by Wei Yu on 2017/7/11.
 */
public class Deamon {

    public static void main(String... args){
        Thread thread = new Thread(new DeamonRunner(),"DeamonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DeamonRunner implements Runnable{
        @Override
        public void run() {
            try{
                SleepUtils.second(10);
            }finally {
                System.out.println("DeamonThread finally run");
            }
        }
    }
}


