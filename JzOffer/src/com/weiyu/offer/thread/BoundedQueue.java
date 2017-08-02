package com.weiyu.offer.thread;

import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Wei Yu on 2017/7/17.
 */
public class BoundedQueue<T> {
    private Object[] items;
    private int addIndex, removeIndex, count;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public BoundedQueue(int size){
        items = new Object[size];
    }


    //添加元素，如果数组满了，则添加线程进入等待状态
    public void add(T t) throws InterruptedException {
        lock.lock();
        try{
            while(count == items.length){
                notFull.await();
            }
            items[addIndex++] = t;

            if(addIndex == items.length)
                addIndex = 0;
            ++count;

            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    //从头部删除一个元素，如果数组为空，则删除线程进入等待状态
    public T remove(T t) throws InterruptedException {
        lock.lock();
        try{
            while(0 == count)
                notEmpty.await();

            Object x = items[removeIndex++];
            if(removeIndex == items.length)
                removeIndex = 0;

            --count;
            notFull.signal();
            return (T)x;
        }finally {
            lock.unlock();
        }
    }
}
