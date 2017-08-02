package com.weiyu.effectivejava;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Wei Yu on 2017/6/13.
 * 避免创建不必要的对象
 */
public class AvoidUnessaryObject {
    private final Date birthDate;

    public boolean isBabyBoomer(){
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946,Calendar.JANUARY,1,0,0,0);

        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965,Calendar.JANUARY,1,0,0,0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }

    public AvoidUnessaryObject(Date birthDate){
        this.birthDate = birthDate;
    }

    public static void main(String... args){
        long startTime = System.currentTimeMillis();
        for(int i = 0;i < 10000000;i++){
            Date date = new Date();
            new AvoidUnessaryObject(date).isBabyBoomer();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time:" + (endTime - startTime));
    }

}
