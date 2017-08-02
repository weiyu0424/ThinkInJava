package com.weiyu.thinkinginjava.huawei;

import java.util.Scanner;
public class Solution {
    private static int[] dist = null;
    private static int[] pre = null;

    public static void dijkstra(int[][] graph,int nodes,int sourceNode){
        boolean[] isVisited = new boolean[nodes];

        for(int i = 0;i < nodes;i++){
            dist[i] = graph[sourceNode][i];
            if(graph[sourceNode][i] == 1000)
                pre[i] = 0;
            else
                pre[i] = sourceNode;
        }
        isVisited[sourceNode] = true;

        int u = sourceNode;
        for(int i = 0;i < nodes - 1;i++){
            int min = 1000;
            for(int j = 0;j < nodes;j++){
                if(!isVisited[j] && dist[j] < min){
                    min = dist[j];
                    u = j;
                }
            }
            isVisited[u] = true;

            for(int k = 0;k < nodes;k++){
                if(!isVisited[k] && graph[u][k] < 1000){
                    int temp = dist[u] + graph[u][k];
                    if(temp < dist[k]){
                        dist[k] = temp;
                        pre[k] = u;
                    }
                }
            }
        }
    }


    public static void traverse(int[] pre,int node,int source){
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
        dist = new int[nodes];
        pre = new int[nodes];
        int[][] graphs = {{0,2,10,5,3,1000},{1000,0,12,1000,1000,10},{1000,1000,0,1000,7,1000},
                {2,1000,1000,0,2,1000},{4,1000,1000,1,0,1000},{3,1000,1,1000,2,0}};

        int source = 4;
        int dest = in.nextInt();
        int fogCity = in.nextInt();
        if(dest < 1 || dest > 6){
            System.out.println(1000);
            System.out.println("[]");
            return;
        }
        if(fogCity < 0 || dest > 6) {
            System.out.println(1000);
            System.out.println("[]");
            return;
        }

        if(dest == fogCity){
            System.out.println(1000);
            System.out.println("[]");
            return;
        }

        if(5 == fogCity){
            System.out.println(1000);
            System.out.println("[]");
            return;
        }

        dest -= 1;
        if(0 != fogCity){
            fogCity -= 1;
            for(int i = 0;i < 6;i++){
                graphs[fogCity][i] = 1000;
            }
        }

        dijkstra(graphs,nodes,source);
        if(dist[dest] == 1000){
            System.out.println(1000);
        }else{
            System.out.println(dist[dest]);
        }
        traverse(pre,dest,source);

    }
}
