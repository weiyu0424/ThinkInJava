package com.weiyu.thinkinginjava;

/**
 * Created by weiyu on 2017/3/16.
 */
public class BiArrayTest {
    public static void main(String... args){
        /*float a[][] = new float[6][6];
        float []b[] = new float[6][6];
        float c[][] = new float[][6];
        float [][]d = new float[6][6];
        float [][]e = new float[6][];*/
        System.out.println(RectCover(3));

    }

    public static int RectCover(int n) {
        if(n <= 1){
            return 1;
        }
        int count = 2;
        int i = 1,j = 1;
        while(count <= n){
            j += i;
            i = j - i;
            count++;
        }
        return j;
    }
}
