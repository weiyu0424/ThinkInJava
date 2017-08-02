package com.weiyu.thinkinginjava.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Wei Yu on 2017/6/7.
 * 创建线程总共有三种方式：1、new Thread().start();2、new Runnable().start();3、实现Callable接口
 */
public class CallableTest implements Callable<Integer>{
    private int upperBounds;
    public CallableTest(int upperBounds){
        this.upperBounds = upperBounds;
    }
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 0;i < upperBounds;i++){
            sum += i;
        }
        return sum;
    }

    public static void main(String... args){
        List<Future<Integer>> list = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i = 0;i < 10;i++){
            list.add(service.submit(new CallableTest((int)(Math.random() * 100))));
        }

        for(Future<Integer> future : list){
            int sum = 0;
            while(!future.isDone())
                try {
                    sum += future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            System.out.println(sum);
        }
    }
}
