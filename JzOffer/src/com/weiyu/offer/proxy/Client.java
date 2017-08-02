package com.weiyu.offer.proxy;

/**
 * Created by Wei Yu on 2017/7/31.
 */
public class Client {
    public static void main(String[] args) {
        IDBQuery query = new DBQueryProxy();
        String result = query.request();
        System.out.println("result:" + result);
    }
}
