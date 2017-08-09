package com.weiyu.offer.thread.blog;

/**
 * Created by Wei Yu on 2017/8/4.
 */
public class CodeBlockSync implements Runnable{
    static CodeBlockSync instance=new CodeBlockSync();
    static int i=0;
    @Override
    public void run() {
        //省略其他耗时操作....
        //使用同步代码块对变量i进行同步操作,锁对象为instance
        synchronized(CodeBlockSync.class){
            for(int j=0;j<1000000;j++){
                i++;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new CodeBlockSync());
        Thread t2=new Thread(new CodeBlockSync());
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
}
