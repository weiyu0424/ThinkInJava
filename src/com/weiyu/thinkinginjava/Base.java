package com.weiyu.thinkinginjava;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by weiyu on 2017/2/17.
 */
public class Base {
    private String baseName = "base";
    public Base(){
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }

    static class Sub extends Base{
        private String baseName = "sub";
        public void callName(){
            System.out.println(baseName);
        }
    }

    public static void main(String... args){
       // Base base = new Sub();
        for( int i = 4 ; i > 0 ; i-- ) {
            int j = 0;
            do {
                j++;
                if (j == 2) {
                    break;
                }
            } while (j < i);
            System.out.print(j);
        }
    }
}
