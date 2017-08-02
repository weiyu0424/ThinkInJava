package com.weiyu.effectivejava;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Wei Yu on 2017/6/13.
 * 避免创建不必要的对象，经过改进后的
 */
public class AvoidUnessaryObjectRefined {
    private final Date birthDate;

    private final static Date BOOM_START;
    private final static Date BOOM_END;

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946,Calendar.JANUARY,1,0,0,0);

        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965,Calendar.JANUARY,1,0,0,0);
        BOOM_END = gmtCal.getTime();
    }

    public boolean isBabyBoomer(){
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
    }

    public AvoidUnessaryObjectRefined(Date birthDate){
        this.birthDate = birthDate;
    }

    public static void main(String... args){
        long startTime = System.currentTimeMillis();
        for(int i = 0;i < 10000000;i++){
            Date date = new Date();
            new AvoidUnessaryObjectRefined(date).isBabyBoomer();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time:" + (endTime - startTime));
    }

}
