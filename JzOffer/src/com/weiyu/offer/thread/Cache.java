package com.weiyu.offer.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Wei Yu on 2017/8/9.
 * 利用一个非线程安全的HashMap跟可重入读写锁实现一个缓存机制
 */
public class Cache {
    static Map<String,Object> map = new HashMap<String,Object>();
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static final Object get(String key){
        readLock.lock();
        try{
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public static final void put(String key, Object obj){
        writeLock.lock();
        try{
            map.put(key,obj);
        }finally {
            writeLock.unlock();
        }
    }

    public static final void clear(){
        writeLock.lock();
        try{
            map.clear();
        }finally {
            writeLock.unlock();
        }
    }
}
