package com.weiyu.thinkinginjava;

import java.util.BitSet;

/**
 * Created by weiyu on 2017/2/10.
 */
public class BitSetTest {
    public static void main(String... args){
        int n = 2000000;
        long start = System.currentTimeMillis();
        BitSet bits = new BitSet(n + 1);
        int count = 0;
        int i;
        for(i = 2;i <= n;i++){
            bits.set(i);
        }
        System.out.println(bits.get(3));
        i = 2;
        while(i * i <= n){
            if(bits.get(i)) {
                count++;
                int k = 2 * i;
                while (k <= n) {
                    bits.clear(k);
                    k += i;
                }
            }
            i++;
        }

        while(i <= n){
            if(bits.get(i)){
                count++;
            }
            i++;
        }

        long end = System.currentTimeMillis();
        System.out.println("Time consuming:" + (end - start));
        System.out.println("count:" + count);
    }
}
