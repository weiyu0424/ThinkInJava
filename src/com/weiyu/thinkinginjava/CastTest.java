package com.weiyu.thinkinginjava;

/**
 * Created by weiyu on 2017/3/16.
 */
public class CastTest {
    public static void main(String... args){
        double above = 0.7,below = 0.4;
        float fAbove = 0.7f,fBelow = 0.4f;
        System.out.println("above:" + above);
        System.out.println("below:" + below);
        System.out.println("(int)above:" + (int)above);
        System.out.println("(int)below:" + (int)below);
        System.out.println("(int)above:" + Math.round(above));
        System.out.println("(int)below:" + Math.round(below));
        System.out.println("(int)above:" + (int)fAbove);
        System.out.println("(int)above:" + (int)fBelow);

        byte a = 2,b = 2;
        byte c;
        c = (byte)(a + b);
        System.out.println(c);
        boolean x = false,y = true;
        x = x & y;
        System.out.println("x & y:" + x);
        x = x | y;
        //x = ~y;
        b = (byte)~a;
        System.out.println("b:" + b);
        System.out.println(x);
        System.out.println(y);

        System.out.println("===========char===============");
        char aa = 'a',cc = 'c';
        aa = (char)(aa + cc);
        int ia = aa;
        int ic = cc;
        int iresult;
        iresult = aa + cc;
        char ccc = 295;
        System.out.println("aa:" + (int)aa);
        System.out.println("ia:" + ia + "==========ic:" + ic + "========iresult:" + iresult);
        System.out.println("ccc:" + (char)iresult);

    }
}
