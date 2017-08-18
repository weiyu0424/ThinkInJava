package com.weiyu.offer.pingduoduo.second;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xpZhu on 2017/8/17.
 */
public class P4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int k = in.nextInt();
            in.nextLine();
            int[][] nums = new int[k][];
            for(int i = 0;i < k;i++){
                String line = in.nextLine();
                line = line.substring(1,line.length() - 1);
                String[] strs = line.split(",");
                nums[i] = new int[strs.length];
                for(int j = 0;j < strs.length;j++){
                    int num = Integer.parseInt(strs[j]);
                    nums[i][j] = num;
                }
            }

            int[] result = smallestRange(nums);
            System.out.println(Arrays.toString(result));
        }
        in.close();
    }

    static class Node {
        int value;
        int index;
        int row;

        public Node(int row, int index, int value) {
            this.row = row;
            this.index = index;
            this.value = value;
        }
    }

    public static int[] smallestRange(int[][] nums) {
        int rows = nums.length;
        //定义一个优先级队列
        PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.value - b.value;
            }
        });

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            Node node = new Node(i, 0, nums[i][0]);
            queue.add(node);
            max = Math.max(max, nums[i][0]);
        }
        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        while (queue.size() == rows) {
            Node current = queue.remove();
            if (max - current.value < range) {
                range = max - current.value;
                start = current.value;
                end = max;
            }

            if (current.index + 1 < nums[current.row].length) {
                current.index = current.index + 1;
                current.value = nums[current.row][current.index];
                queue.add(current);
                if (current.value > max) {
                    max = current.value;
                }
            }
        }
        return new int[]{ start,end };
    }
}
