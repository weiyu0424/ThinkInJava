package com.weiyu.offer.utils;

import java.util.concurrent.TimeUnit;

/**
 * Created by Wei Yu on 2017/7/11.
 */
public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
