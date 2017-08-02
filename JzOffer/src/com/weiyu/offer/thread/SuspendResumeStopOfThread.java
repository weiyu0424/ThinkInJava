package com.weiyu.offer.thread;

import com.weiyu.offer.utils.SleepUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Wei Yu on 2017/7/11.
 */
public class SuspendResumeStopOfThread {

    static class Runner implements Runnable{

        public static void main(String... args) throws InterruptedException {
            DateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            Thread printThread = new Thread(new Runner(),"PrintThread");
            printThread.setDaemon(true);
            printThread.start();


//            TimeUnit.SECONDS.sleep(3);
//            printThread.suspend();
//            System.out.println("Main thread suspends at: " + format.format(new Date()));
//            TimeUnit.SECONDS.sleep(3);
//            printThread.resume();
//
//            System.out.println("Main thread resumes at: " + format.format(new Date()));
//            TimeUnit.SECONDS.sleep(3);
//            printThread.stop();
//            System.out.println("Main thread stops at: " + format.format(new Date()));
//            TimeUnit.SECONDS.sleep(3);
        }
        @Override
        public void run() {
            DateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            while(true){
                System.out.println(Thread.currentThread().getName() + "Run at " + format.format(new Date()));
                SleepUtils.second(1);
            }
        }
    }
}
