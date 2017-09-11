package com.weiyu.offer.dji;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main4 {
    static int count = 0;
    private static void solution(int n, int m, int r,PriorityQueue<Integer> queue) {
        if(n < m) {
            return;
        }
        if(m==0 || r==0 || n==0) {
            return;
        }
        if(queue.size()<m) {
            return;
        }
        while(true){
            int flag = m;
            List<Integer> list = new ArrayList<>();
            while(flag!=0){
                if(queue.size() < flag)
                    return;
                Integer xInteger = queue.poll();
                if(xInteger < r){
                    return;
                }
                flag--;
                if(xInteger>r)
                    list.add(xInteger-r);
            }
            count++;
            for (Integer integer : list) {
                queue.add(integer);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int r = in.nextInt();
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for(int i = 0;i < n;i++){
                int x = in.nextInt();
                if(x >= r)
                    queue.add(x);
            }
            solution(n,m,r,queue);
            System.out.println(count);
        }
        in.close();
    }
}

