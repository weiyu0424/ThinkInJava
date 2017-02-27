package com.weiyu.thinkinginjava;

import java.util.*;

/**
 * Created by weiyu on 2017/2/13.
 */
public class GregorianCalendarTest {
    public static void main(String... args){
        Locale.setDefault(Locale.ITALY);
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR,2017);
        calendar.set(Calendar.MONTH,Calendar.FEBRUARY);
        calendar.set(Calendar.DAY_OF_MONTH,13);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(year + ":" + month + ":" + day + ":" + dayOfWeek);
    }
}
