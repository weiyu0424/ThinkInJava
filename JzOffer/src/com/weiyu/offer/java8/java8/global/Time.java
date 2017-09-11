package com.weiyu.offer.java8.java8.global;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

/**
 * Created by Wei Yu on 2017/8/27.
 */
public class Time {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("today" + localDate.toString());
        localDate = LocalDate.ofYearDay(2017,300);
        System.out.println(localDate.toString());

        localDate = LocalDate.of(2017, Month.OCTOBER,12);
        System.out.println(localDate.toString());

        LocalTime time = LocalTime.now();
        System.out.println(time.toString());

        time = LocalTime.of(10,20,50);
        System.out.println(time.toString());

        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);
    }
}
