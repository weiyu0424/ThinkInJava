package com.weiyu.offer.dp;

/**
 * Created by Wei Yu on 2017/8/12.
 */
public class MinimumPathOfMatrix {
    /**
     * 没有进行空间压缩的方法
     *
     * @param matrix
     * @return
     */
    public static int minimumPathSum(int[][] matrix) {
        if (null == matrix || 0 == matrix.length || null == matrix[0] || 0 == matrix[0].length) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] sum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (0 == i) {
                sum[i][0] = matrix[i][0];
            } else {
                sum[i][0] = sum[i - 1][0] + matrix[i][0];
            }
        }

        for (int j = 1; j < cols; j++) {
            sum[0][j] = sum[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++) {
                sum[i][j] = matrix[i][j] + Math.min(sum[i - 1][j], sum[i][j - 1]);
            }

        return sum[rows - 1][cols - 1];
    }

    /**
     * 进行了空间压缩的方法
     *
     * @param matrix
     * @return
     */
    public static int minimumPathSumWithCondense(int[][] matrix) {
        if (null == matrix || 0 == matrix.length || null == matrix[0] || 0 == matrix[0].length) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int more = Math.max(rows, cols);
        int less = Math.min(rows, cols);

        boolean rowsMore = more == rows;

        int[] sum = new int[less];
        sum[0] = matrix[0][0];
        for (int i = 1; i < less; i++) {
            sum[i] = sum[i - 1] + (rowsMore ? matrix[0][i] : matrix[i][0]);
        }

        for (int i = 1; i < more; i++)
            for (int j = 0; j < less; j++) {
                int matrixValue = rowsMore ? matrix[i][j] : matrix[j][i];
                if (0 == j) {
                    sum[j] += matrixValue;
                } else {
                    sum[j] = matrixValue + Math.min(sum[j - 1], sum[j]);
                }
            }

        return sum[less - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 9, 3}, {8, 1, 3, 4, 0}, {5, 0, 6, 1, 4}, {8, 8, 4, 0, 1}};
        int result = minimumPathSumWithCondense(matrix);
//        int result = minimumPathSum(matrix);
        System.out.println(result);
    }
}
