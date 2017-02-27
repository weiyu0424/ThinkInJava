package com.weiyu.thinkinginjava;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * Created by weiyu on 2017/2/6.
 */
public class PriorityQueueTest {
    public static void main(String... args){
        PriorityQueue<GregorianCalendar> pa = new PriorityQueue<>();
        pa.add(new GregorianCalendar(1906, Calendar.DECEMBER,9));
        pa.add(new GregorianCalendar(1815, Calendar.DECEMBER,10));
        pa.add(new GregorianCalendar(1903, Calendar.DECEMBER,3));
        pa.add(new GregorianCalendar(1910, Calendar.DECEMBER,22));

        System.out.println("Iterating over elements");
        for(GregorianCalendar date : pa){
            System.out.println(date.get(Calendar.YEAR));
        }

        System.out.println("Removing elements...");
        while(!pa.isEmpty()){
            System.out.println(pa.remove().get(Calendar.YEAR));
        }
    }
}
