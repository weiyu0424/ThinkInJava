package com.weiyu.offer.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Wei Yu on 2017/7/21.
 * RecursiveAction:用于没有返回结果的任务
 * RecursiveTask:用于有返回结果的任务
 *
 * Fork/Join的原理
 * Fork将一个比较大的任务分成几个小任务执行，然后通过join()方法将每个小任务的执行结果进行汇总。每个小任务则由单独的线程来执行。
 * Fork/Join模式的采用了工作窃取算法，这里通过fork方法分成每个小任务之后，每个小任务由一个单独的线程来执行，每个线程跟一个双端队列一一对应，如果一个线程将队列上的任务执行完成之后
 * 可以帮着其他没有执行完的线程来执行。
 *
 * 每个分割出的子任务会添加到当前工作线程所维护的双端队列中，进入队列的头部。当一个工作线程的队列里暂时没有任务时，他会随机从其他工作线程的队列的尾部获取一个任务。
 */
public class CountTask extends RecursiveTask<Integer> {
    public static final int THRESHOLD = 2;//阈值
    private int start;
    private int end;

    public CountTask(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        boolean canCompute = (end - start) <= THRESHOLD;
        if(canCompute){
            for(int i = start;i <= end;i++){
                sum += i;
            }
        }else{
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start,middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            leftTask.fork();
            rightTask.fork();

            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String... args){
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1,4);

        Future<Integer> result = forkJoinPool.submit(countTask);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
