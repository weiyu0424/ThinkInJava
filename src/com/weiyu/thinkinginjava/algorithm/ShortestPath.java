package com.weiyu.thinkinginjava.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by weiyu on 2017/4/6.
 * 采用Dijkstra算法实现查找一个结点到剩余所有结点的最短路径
 */
public class ShortestPath {
    private static int[] dist = null;
    private static int[] pre = null;

    /**
     * Dijkstra算法
     * @param graph
     * @param nodes
     * @param sourceNode
     */
    public static void dijkstra(int[][] graph,int nodes,int sourceNode){
//        int[] dist = new int[nodes];
        boolean[] isVisited = new boolean[nodes];
//        int[] pre = new int[nodes];

        //sourceNode到各节点的初始距离赋值给dest数组
        for(int i = 0;i < nodes;i++){
            dist[i] = graph[sourceNode][i];
            if(graph[sourceNode][i] == Integer.MAX_VALUE)
                pre[i] = 0;
            else
                pre[i] = sourceNode;
        }
        isVisited[sourceNode] = true;

        //由于原点已经访问过了，所以剩下的只用访问nodes-1个结点
        int u = sourceNode;
        for(int i = 0;i < nodes - 1;i++){
            //采用贪心的思路找出没有访问的数组中离当前结点最近的一个结点，并将它赋值给u
            int min = Integer.MAX_VALUE;
            for(int j = 0;j < nodes;j++){
                if(!isVisited[j] && dist[j] < min){
                    min = dist[j];
                    u = j;
                }
            }
            isVisited[u] = true;

            //进行松弛
            for(int k = 0;k < nodes;k++){
                if(!isVisited[k] && graph[u][k] < Integer.MAX_VALUE){
                    int temp = dist[u] + graph[u][k];
                    if(temp < dist[k]){
                        dist[k] = temp;
                        pre[k] = u;
                    }
                }
            }
        }
    }


    /**
     * 回溯存储的最短路径
     * @param pre
     * @param node
     */
    public static void traverse(int[] pre,int node){
        int[] path = new int[pre.length];
        int count = 0;
        path[count++] = node;
        int temp = pre[node];
        while(temp != 0){
            path[count++] = temp;
            temp = pre[temp];
        }

        path[count] = 0;
        System.out.println("count:" + count);
        for(int i = count;i >= 0;i--){
            if(i != 0) {
                System.out.print(path[i] + "->");
            }else{
                System.out.print(path[i]);
            }
        }
        System.out.println();
    }

    public static void main(String... args){
        Scanner in = new Scanner(System.in);
        int nodes = in.nextInt();
        int edges = in.nextInt();
        dist = new int[nodes];
        pre = new int[nodes];
        int[][] graphs = new int[nodes][nodes];
        for(int i = 0;i < graphs.length;i++)
            for(int j = 0;j < graphs[0].length;j++){
                graphs[i][j] = Integer.MAX_VALUE;
            }

        for(int i = 0;i < edges;i++){
            int source = in.nextInt();
            int dest = in.nextInt();
            int distance = in.nextInt();
            graphs[source][dest] = distance;
            graphs[dest][source] = distance;
        }


        int source = in.nextInt();
        int dest = in.nextInt();

        dijkstra(graphs,nodes,source);

        //visitPath(pre,dest);

        //System.out.println(source + "到" + dest + "的最短路径长度为：" + dist[dest]);
        if(dist[dest] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(dist[dest]);
        }

    }
}
