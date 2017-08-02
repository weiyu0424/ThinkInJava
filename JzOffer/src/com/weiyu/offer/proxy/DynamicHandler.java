package com.weiyu.offer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Wei Yu on 2017/7/31.
 */
public class DynamicHandler implements InvocationHandler {
    private Object proxied;

    public DynamicHandler(Object proxied){
        System.out.println("dynamic proxy handler constructor:" + proxied.getClass());
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamic proxy name:" + proxy.getClass());
        System.out.println("method:" + method.getName());
        System.out.println("args:" + Arrays.toString(args));

        Object invokeObject = method.invoke(proxied, args);
        if(null != invokeObject){
            System.out.println("invoke object:" + invokeObject.getClass());
        }else{
            System.out.println("invoke object is null");
        }
        return invokeObject;
    }
}
