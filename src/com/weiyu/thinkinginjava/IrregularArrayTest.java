package com.weiyu.thinkinginjava;

/**
 * Created by weiyu on 2017/2/12.
 */
public class IrregularArrayTest {
    /**
     * 不规则数组
     * Java数组中可以只声明行而无需声明列
     */

    static final int NMAX = 10;

    public static void main(String... args){
        int[][] odds = new int[NMAX][];
        for(int i = 0;i < NMAX;i++){
            odds[i] = new int[i + 1];
        }


        for(int i = 0; i < odds.length;i++)
            for(int j = 0;j < odds[i].length;j++){
                odds[i][j] = i * j;
            }

        for(int i = 0;i < odds.length;i++) {
            for (int j = 0; j < odds[i].length; j++) {
                System.out.print(odds[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
