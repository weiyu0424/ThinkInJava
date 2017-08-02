package com.weiyu.thinkinginjava.huawei;

import java.util.Scanner;

public class Main {
    private static int[] distance = null;
    private static int[] pre = null;

    public static void minPath(int[][] array, int nodes, int sourcenode){
        boolean[] visit = new boolean[nodes];

        for(int i = 0;i < nodes;i++){
            distance[i] = array[sourcenode][i];
            if(array[sourcenode][i] == 1000)
                pre[i] = 0;
            else
                pre[i] = sourcenode;
        }
        visit[sourcenode] = true;

        int u = sourcenode;
        for(int i = 0;i < nodes - 1;i++){
            int min = 1000;
            for(int j = 0;j < nodes;j++){
                if(!visit[j] && distance[j] < min){
                    min = distance[j];
                    u = j;
                }
            }
            visit[u] = true;

            for(int k = 0;k < nodes;k++){
                if(!visit[k] && array[u][k] < 1000){
                    int temp = distance[u] + array[u][k];
                    if(temp < distance[k]){
                        distance[k] = temp;
                        pre[k] = u;
                    }
                }
            }
        }
    }


    public static void visitPath(int[] pre, int node, int source){
        int[] path = new int[pre.length];
        int count = 0;
        path[count++] = node;
        int temp = pre[node];
        while(temp != source){
            path[count++] = temp;
            temp = pre[temp];
        }

        path[count] = source;
        System.out.print("[");
        for(int i = count;i >= 0;i--){
            if(i != 0) {
                System.out.print((path[i] + 1) + ", ");
            }else{
                System.out.print((path[i] + 1));
            }
        }
        System.out.println("]");
    }

    public static void main(String... args){
        Scanner in = new Scanner(System.in);
        int nodes = 6;
        distance = new int[nodes];
        pre = new int[nodes];
        int[][] graphs = {
                {0,2,10,5,3,1000},
                {1000,0,12,1000,1000,10},
                {1000,1000,0,1000,7,1000},
                {2,1000,1000,0,2,1000},
                {4,1000,1000,1,0,1000},
                {3,1000,1,1000,2,0}
        };

        int source = 4;
        int x = in.nextInt();
        int y = in.nextInt();
        if(x < 1 || x > 6){
            return;
        }
        if(y < 0 || x > 6) {
            return;
        }

        if(x == y){
            System.out.println(1000);
            System.out.println("[]");
            return;
        }

        if(5 == y){
            System.out.println(1000);
            System.out.println("[]");
            return;
        }

        x -= 1;
        if(0 != y){
            y -= 1;
            for(int i = 0;i < 6;i++){
                graphs[y][i] = 1000;
            }
        }

        minPath(graphs,nodes,source);
        if(distance[x] == 1000){
            System.out.println(1000);
        }else{
            System.out.println(distance[x]);
        }
        visitPath(pre,x,source);

    }
}
