package com.weiyu.offer.java8.annotation;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Created by Wei Yu on 2017/8/27.
 */
public class AnnoCase {
    public static void main(String[] args) {
        @NonNull Object obj = null;
        obj.toString();
    }
}
