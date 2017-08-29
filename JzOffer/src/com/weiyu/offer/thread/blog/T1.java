package com.weiyu.offer.thread.blog;

public class T1 implements Runnable{
    @Override  
    public void run() {  
        Walk walk = new Walk();  
        //Walk walk = Walk.walk;  
        // 这里我依然用的new  
        Walk.run();
    }  
}  