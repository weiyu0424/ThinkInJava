package com.weiyu.offer.dji;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2{
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int rows = in.nextInt();
            int cols = in.nextInt();
            int startX = in.nextInt();
            int startY = in.nextInt();
            int endX = in.nextInt();
            int endY = in.nextInt();
            int[][] matrix = new int[rows][cols];
            for(int i = 0;i < rows;i++)
                for(int j = 0;j < cols;j++)
                    matrix[i][j] = in.nextInt();


            init(rows, cols, matrix);

            if(matrix[startX][startY] >0 || matrix[startX][startY] == -1 || matrix[endX][endY] > 0 || matrix[endX][endY] == -1) {
                System.out.println(-1);
            }else{
                int pathCount = bfs1(matrix,startX,startY,endX,endY,rows,cols);
                if(pathCount < Integer.MAX_VALUE) {
                    System.out.println(pathCount);
                }else {
                    System.out.println(-1);
                }
            }
        }
        in.close();
    }

    private static void init(int rows, int cols, int[][] matrix) {
        boolean[][] isVisited = new boolean[rows][cols];
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(isVisited[i][j] == false){
                    if(matrix[i][j] == 0)
                        continue;
                    if(matrix[i][j] == 1 && isVisited[i][j] == true){
                        continue;
                    }

                    isVisited[i][j] = true;
                    int radiationLevel = matrix[i][j] - 1;
                    for(int k = Math.max(i - radiationLevel,0); k >= 0 && k <= Math.min(i + radiationLevel, rows - 1);k++) {
                        if (isVisited[k][j] == false) {
                            if (matrix[k][j] != 0)
                                continue;
                            isVisited[k][j] = true;
                            matrix[k][j] = -1;
                        }
                    }

                    for(int s = Math.max(j - radiationLevel, 0); s >= 0 && s <= Math.min(j + radiationLevel, cols - 1);s++){
                        if(isVisited[i][s] == false){
                            if(matrix[i][s] != 0)
                                continue;
                            isVisited[i][s] = true;
                            matrix[i][s] = -1;
                        }
                    }
                }
            }
        }
    }



    private static int bfs(int[][] matrix,int startX,int startY,int endX,int endY,int rows,int cols){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX,startY});
        int[][] vis = new int[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                vis[i][j] = Integer.MAX_VALUE;
        vis[startX][startY] = 0;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int i=0;
            for(i=0;i<4;i++){
                int ni = current[0] + dx[i];
                int nj = current[1] + dy[i];
                if(ni >= 0 && ni<rows && nj >=0 && nj < cols && vis[ni][nj] == Integer.MAX_VALUE && matrix[ni][nj] == 0){
                    q.offer(new int[]{ni,nj});
                    vis[ni][nj] = vis[current[0]][current[1]]+1;
                    if(ni == endX && nj == endY)
                        break;
                }
            }
            if(i!=4)
                break;
        }
        return vis[endX][endY];
    }


    private static int bfs1(int[][] matrix,int startX,int startY,int endX,int endY,int rows,int cols){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX,startY));
        int[][] vis = new int[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                vis[i][j] = Integer.MAX_VALUE;
        vis[startX][startY] = 0;
        while(!q.isEmpty()){
            Point current = q.poll();
            int i = 0;
            for(i = 0;i < 4;i++){
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && vis[newX][newY] == Integer.MAX_VALUE && matrix[newX][newY] == 0){
                    q.offer(new Point(newX,newY));
                    vis[newX][newY] = vis[current.x][current.y]+1;
                    if(newX == endX && newY == endY)
                        break;
                }
            }
            if(i != 4)
                break;
        }
        return vis[endX][endY];
    }


    static class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

}
