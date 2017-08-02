package com.weiyu.offer.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Wei Yu on 2017/7/17.
 * Condition对象是由Lock对象创建出来的，所以可以说，condition对象是依赖Lock对象的
 */
public class ConditionUseCase {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException{
        lock.lock();
        try{
            //等待之前，当前线程必须先获得锁
            condition.await();
        }finally {
            lock.unlock();
        }
    }

    public void conditionSignal(){
        lock.lock();
        try{
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

}
