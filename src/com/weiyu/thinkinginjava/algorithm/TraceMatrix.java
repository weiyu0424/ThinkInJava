package com.weiyu.thinkinginjava.algorithm;

import java.util.ArrayList;

/**
 * Created by Wei Yu on 2017/6/7.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class TraceMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int layers = (rows < cols ? rows : cols - 1) / 2 + 1;
        ArrayList<Integer> values = new ArrayList<>();
        for(int i = 0;i < layers;i++){
            //先打印从左到右的
            for(int j = i; j < cols - i;j++){
                values.add(matrix[i][j]);
            }

            //打印从上到下的
            for(int k = i + 1;k < rows - i;k++)
                values.add(matrix[k][cols - 1 - i]);

            //打印从右到左的
            for(int m = cols - 2 - i;(m >= i && rows - 1 - i != i);m--)
                values.add(matrix[rows - 1 - i][m]);

            //再打印从下到上的
            for(int n = rows - 2 - i;n > i && cols - 1 - i != i;n--)
                values.add(matrix[n][i]);
        }
        return values;
    }

    public static void main(String... args){
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
        ArrayList arrays = new TraceMatrix().printMatrix(matrix);
        System.out.println(arrays);
    }
}
