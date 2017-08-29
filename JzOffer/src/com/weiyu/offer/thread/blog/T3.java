package com.weiyu.offer.thread.blog;

// 先建立两个测试类，这里我们默认循环10次
public class T3 implements Runnable {  
    @Override  
    public void run() {  
        Walk walk = new Walk();  
        //Walk walk = Walk.walk;  
        walk.walk();  
    }  
} 