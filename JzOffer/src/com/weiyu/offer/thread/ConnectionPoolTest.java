package com.weiyu.offer.thread;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Wei Yu on 2017/7/12.
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;


    public static void main(String... args) throws InterruptedException {
        int threadCount = 50;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for(int i = 0;i < threadCount;i++){
            Thread thread = new Thread(new ConnectionRunner(count,got,notGot),"ConnectionRunnerThread");
            thread.start();
        }
        //执行完start.countDown()之后，所有线程开始操作
        start.countDown();

        //等待所有线程执行结束，然后返回主线程
        end.await();
        System.out.println("total invoke:" + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("notGot connection: " + notGot);
    }


    static class ConnectionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count,AtomicInteger got,AtomicInteger notGot){
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                //每个线程这时都处于等待状态，只有等主线程的start.countDown()执行完之后他们才能统一开始
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while(count > 0){
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if(null != connection){
                        try{
                            connection.createStatement();
                            connection.commit();
                        }finally{
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else{
                        notGot.incrementAndGet();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}
