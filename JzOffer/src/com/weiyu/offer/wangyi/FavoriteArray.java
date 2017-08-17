package com.weiyu.offer.wangyi;

import java.util.Scanner;

public class FavoriteArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] matrix = new int[k + 1][k + 1];
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[1];
        getCountOfSuitableArray(matrix,k,rows,cols,result);
        System.out.println(result[0]);
        in.close();
    }

    private static void getCountOfSuitableArray(int[][] matrix, int k, int rows, int cols,int[] result) {
        for(int i = 1; i < rows;i++)
            for(int j = 1;j < cols;j++){
                if(judge(i,j)){
                    result[0] = (result[0] + 1) % 1000000007;
                }
            }
    }

    private static boolean judge(int i, int j) {
        if(i <= j || i % j != 0)
            return true;
        return false;
    }
}
