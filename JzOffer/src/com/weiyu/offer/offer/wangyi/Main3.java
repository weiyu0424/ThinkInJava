package com.weiyu.offer.offer.wangyi;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] matrix = new int[k + 1][k + 1];
        int rows = matrix.length;
        int cols = matrix[0].length;
        int result = getCountOfSuitableArray(matrix,k,rows,cols);
        System.out.println(result);
        in.close();
    }

    private static int getCountOfSuitableArray(int[][] matrix, int k, int rows, int cols) {
        int result = 0;
        for(int i = 1; i < rows;i++)
            for(int j = 1;j < cols;j++){
                if(judge(i,j)){
                    result = (result + 1) % 1000000007;
                }
            }
        return result;
    }

    private static boolean judge(int i, int j) {
        if(i <= j || i % j != 0)
            return true;
        return false;
    }
}
