package com.weiyu.offer.thread;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Wei Yu on 2017/7/23.
 */
public class BankWaterService implements Runnable{
    private CyclicBarrier barrier = new CyclicBarrier(4,this);
    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String,Integer> sheetWaterBankCount = new ConcurrentHashMap<>();

    public void count(){
        for(int i = 0;i < 4;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    sheetWaterBankCount.put(Thread.currentThread().getName(),1);
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    @Override
    public void run() {
        int result = 0;
        for(Map.Entry<String,Integer> sheet : sheetWaterBankCount.entrySet()){
            result += sheet.getValue();
        }

        sheetWaterBankCount.put("result",result);
        System.out.println(result);
    }

    public static void main(String... args){
        BankWaterService service = new BankWaterService();
        service.count();
    }
}

