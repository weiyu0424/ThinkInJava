package com.weiyu.offer.proxy;

/**
 * Created by Wei Yu on 2017/7/31.
 */
public class DBQuery implements IDBQuery {
    public DBQuery(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String request() {
        return "Query hello,world";
    }

    public void query(){
        System.out.println("do the query operation!!!");
    }
}
