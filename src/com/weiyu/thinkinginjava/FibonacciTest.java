package com.weiyu.thinkinginjava;

/**
 * Created by weiyu on 2017/3/12.
 * 利用矩阵乘法来实现费布那齐数列类似的问题
 */
public class FibonacciTest {
    public static int fibonacci(int n) {
        if(n < 1)
            return 0;
        if(1 == n || 2 == n)
            return 1;
        int[][] p = {{1,1},{1,0}};
        int[][] result = matrixPow(p,n - 2);
        return result[0][0] + result[1][0];
    }

    public static void main(String... args){
        System.out.println(fibonacci(4));
        //System.out.println(4&1);
        //System.out.println(pow3(3,3));
    }

    public static int[][] matrixPow(int[][] matrix,int n){
        int[][] ans = new int[matrix.length][matrix[0].length];


        //这个地方注意设置成单位阵
        for(int i = 0;i < matrix.length;i++)
            ans[i][i] = 1;

        while(n != 0){
            if((n & 1) == 1)
                ans = matrixMutiple(ans,matrix);
            matrix = matrixMutiple(matrix,matrix);

            n >>= 1;
        }
        return ans;
    }

    /**
     * 快速幂乘思想
     * @param a
     * @param b
     * @return
     */
    public static int pow3(int a,int b){
        int ans = 1,base = a;
        while(b != 0){
            if((b & 1) == 1){
                ans *= base;
            }
            base *= base;
            b >>= 1;
        }
        return ans;
    }

    /**
     * 两个数的矩阵乘法
     * @param m1
     * @param m2
     * @return
     */
    public static int[][] matrixMutiple(int[][] m1,int[][] m2){
        int[][] result = new int[m1.length][m2[0].length];
        for(int i = 0;i < result.length;i++)
            for(int j = 0;j < result[0].length;j++)
                for(int k = 0;k < m2.length;k++){
                    result[i][j] += m1[i][k] * m2[k][j];
                }
        return result;
    }
}
