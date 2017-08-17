package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/8/11.
 */
public class P67_MovingCount {
    public int movingCount(int threshold, int rows, int cols)
    {
        if(rows < 1 || cols < 1)
            return 0;
        int[] visited = new int[rows * cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols, int i, int j, int[] visited) {
        int count = 0;
        if(check(threshold,rows,cols,i,j,visited)){
            visited[i * cols + j] = 1;
            count = 1 + movingCountCore(threshold,rows,cols,i - 1,j,visited)
                        + movingCountCore(threshold,rows,cols,i, j - 1,visited)
                        + movingCountCore(threshold,rows,cols,i + 1, j, visited)
                        + movingCountCore(threshold,rows,cols,i,j + 1,visited);
        }
        return count;
    }

    private boolean check(int threshold, int rows, int cols, int i, int j, int[] visited) {
        if(i >= 0 && i < rows && j >= 0 && j < cols && visited[i * cols + j] == 0 && getDigitNum(i,j) <= threshold)
            return true;
        return false;
    }

    private int getDigitNum(int i, int j) {
        int sum = 0;
        while(i != 0){
            sum += (i % 10);
            i /= 10;
        }

        while(j != 0){
            sum += (j % 10);
            j /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int result = new P67_MovingCount().movingCount(5, 10, 10);
        System.out.println(result);
    }

}
