package com.weiyu.thinkinginjava;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by weiyu on 2017/1/3.
 */
public class TreeSetDemo {
    public static void main(String... args){
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widget",4562));
        parts.add(new Item("Modem",9912));
        parts.add(new Item("Modem",9912));
        System.out.println(parts);


        SortedSet<Item> sortedByDescription = new TreeSet<>(new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                String desc1 = item1.getDescription();
                String desc2 = item2.getDescription();
                return desc1.compareTo(desc2);
            }
        });

        sortedByDescription.addAll(parts);

        System.out.println(sortedByDescription);

    }
}
