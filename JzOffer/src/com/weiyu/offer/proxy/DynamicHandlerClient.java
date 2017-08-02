package com.weiyu.offer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Wei Yu on 2017/7/31.
 */
public class DynamicHandlerClient {
    public static void main(String[] args) {
        DBQuery query = new DBQuery();
        System.out.println(query.request());
        System.out.println("===========");

        ClassLoader classLoader = IDBQuery.class.getClassLoader();
        Class<?>[] interfaces = new Class[]{IDBQuery.class};

        InvocationHandler handler = new DynamicHandler(query);

        IDBQuery proxy = (IDBQuery) Proxy.newProxyInstance(classLoader, interfaces, handler);
        System.out.println(proxy.request());

        System.out.println("===========================");
        proxy.query();
    }

}
