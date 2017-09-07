package com.weiyu.offer.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Wei Yu on 2017/9/6.
 */
public class RandomCase {
    public static void main(String[] args) {
        int num = (int)(Math.random() * 4);
        System.out.println(num);


        Random random = new Random(10);
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            list.add(random.nextInt(10));
        }

        System.out.println(list);
        list.clear();

        random = new Random(10);
        for(int i = 0;i < 10;i++){
            list.add(random.nextInt(10));
        }
        System.out.println(list);
    }
}
