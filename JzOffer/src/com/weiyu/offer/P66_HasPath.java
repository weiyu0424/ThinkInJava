package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/8/11.
 */
public class P66_HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(null == matrix || rows < 1 || cols < 1 || null == str)
            return false;
        int[] visited = new int[matrix.length];
        for(int i = 0;i < rows;i++)
            for(int j = 0;j < cols;j++){
                if(hasCorePath(matrix,rows,cols,i,j,str,0,visited)){
                    return true;
                }
            }
        return false;
    }

    boolean hasCorePath(char[] matrix,int rows,int cols,int row,int col,char[] str,int pathLength,int[] visited){
        if(pathLength == str.length)
            return true;
        boolean hasPath = false;
        if(row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLength] && visited[row * cols + col] == 0){
            ++pathLength;
            visited[row * cols + col] = 1;
            hasPath = hasCorePath(matrix,rows,cols,row - 1,col,str,pathLength,visited)
                    || hasCorePath(matrix,rows,cols,row,col - 1,str,pathLength,visited)
                    || hasCorePath(matrix,rows,cols,row + 1,col,str,pathLength,visited)
                    || hasCorePath(matrix,rows,cols,row,col + 1,str,pathLength,visited);

            if(!hasPath){
                visited[row * cols + col] = 0;
                pathLength--;
            }
        }
        return hasPath;
    }
}
