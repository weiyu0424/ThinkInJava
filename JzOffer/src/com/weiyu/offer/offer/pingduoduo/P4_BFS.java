package com.weiyu.offer.offer.pingduoduo;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 假设一个探险家被困在了地底的迷宫之中，要从当前位置开始找到一条通往迷宫出口的路径。迷宫可以用一个二维矩阵组成，有的部分是墙，有的部分是路。
 * 迷宫之中有的路上还有门，每扇门都在迷宫的某个地方有与之匹配的钥匙，只有先拿到钥匙才能打开门。请设计一个算法，帮助探险家找到脱困的最短路径。如前所述，迷宫是通过一个二维矩阵表示的，
 * 每个元素的值的含义如下 0-墙，1-路，2-探险家的起始位置，3-迷宫的出口，大写字母-门，小写字母-对应大写字母所代表的门的钥匙
 输入描述:
 迷宫的地图，用二维矩阵表示。第一行是表示矩阵的行数和列数M和N
 后面的M行是矩阵的数据，每一行对应与矩阵的一行（中间没有空格）。M和N都不超过100, 门不超过10扇。

 输出描述:
 路径的长度，是一个整数

 输入例子1:
 5 5
 02111
 01a0A
 01003
 01001
 01111

 输出例子1:
 7
 */
public class P4_BFS {
    // 四个方向  
    private static int[] xx = new int[] { 0, 0, 1, -1 };  
    private static int[] yy = new int[] { 1, -1, 0, 0 };  
  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
  
        while (scanner.hasNext()) {  
            int m = scanner.nextInt();  
            int n = scanner.nextInt();  
            scanner.nextLine();  
  
            char[][] datas = new char[m][n];  
            for (int i = 0; i < m; i++) {  
                datas[i] = scanner.nextLine().toCharArray();  
            }  
  
            int x0 = 0, y0 = 0;  
            int xd = 0, yd = 0;  
  
            for (int i = 0; i < m; i++) {  
                for (int j = 0; j < m; j++) {  
                    if (datas[i][j] == '2') {  
                        x0 = i;  
                        y0 = j;  
                        continue;  
                    }  
  
                    if (datas[i][j] == '3') {  
                        xd = i;  
                        yd = j;  
                        break;  
                    }  
                }  
            }  
  
            System.out.println(bfs(datas, m, n, x0, y0, xd, yd));  
        }  
  
    }  
  
    private static int bfs(char[][] datas, int m, int n, int x0, int y0, int xd, int yd) {  
        LinkedList<Node> queue = new LinkedList<>();  
  
        int[][][] keys = new int[m][n][1024];  
  
        /*for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {  
                for (int s = 0; s < 1024; s++) {  
                    keys[i][j][s] = Integer.MAX_VALUE;  
                }  
            }  
        }*/
  
        queue.add(new Node(x0, y0, 0, 0));
        //keys[x0][y0][0] = 0;
  
        Node node = null;  
        int x = 0;  
        int y = 0;  
        int key = 0;  
  
        while (queue.size() > 0) {  
            node = queue.poll();  
            x = node.x;  
            y = node.y;  
            //key = node.key;
  
            if (x == xd && y == yd)  
                return node.step;
  
            for (int i = 0; i < 4; i++) {  
                x = node.x + xx[i];  
                y = node.y + yy[i];  
                key = node.key;  
  
                if (!isValid(x, y, m, n, datas))  
                    continue;  
                // 最多10把钥匙  
                if (datas[x][y] >= 'a' && datas[x][y] <= 'j') {  
                    key = key | (0x1 << (datas[x][y] - 'a'));  
                }  
                // 有对应的钥匙继续往下走，没有则跳过  
                if (datas[x][y] >= 'A' && datas[x][y] <= 'J') {// door
                    int temp = key & (0x1 << (datas[x][y] - 'A'));
                    if(0 == temp)
                        continue;
                    /*if ((key & (0x1 << (datas[x][y] - 'A'))) > 0) {// haskey
                        // key = key | ~(0x1 << (datas[x][y] - 'A'));  
                    } else {  
                        continue;  
                    }  */
                }  
                // keys[x][y][key] 钥匙数  
                if (keys[x][y][key] == 0) {
                    keys[x][y][key] = 1;
                    queue.add(new Node(x, y, key, node.step + 1));
                }

                /*if (keys[x][y][key] > keys[node.x][node.y][node.key] + 1) {
                    keys[x][y][key] = keys[node.x][node.y][node.key] + 1;
                    queue.add(new Node(x, y, key, node.step + 1));
                }*/

            }  
        }  
        return Integer.MAX_VALUE;
    }  
  
    private static boolean isValid(int x, int y, int m, int n, char[][] data) {  
        if (x >= 0 && x < m && y >= 0 && y < n && data[x][y] != '0')  
            return true;  
        return false;  
    }  
  
    private static class Node {  
        int x;  
        int y;  
        int key;
        int step;
  
        public Node(int x, int y, int key, int step) {
            this.x = x;  
            this.y = y;  
            this.key = key;
            this.step = step;
        }  
    }  
  
} 