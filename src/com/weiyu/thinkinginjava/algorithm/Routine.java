package com.weiyu.thinkinginjava.algorithm;

import java.util.*;

public class Routine {
    private static String time[][] = {{"0","2","10","5","3","M"},{"M","0","12","M","M","10"},{"M","M","0","M","7","M"},
            {"2","M","M","0","2","M"},{"4","M","M","1","0","M"},{"3","M","1","M","2","0"}};
    private static int[] count = new int[6];
    private static List<Integer> path = new ArrayList<>();
    public static void main(String... args){
        System.out.println("hello,world");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        if(x < 1 || x > 6) return;
        if(y < 0 || y > 6) return;
        if(y != 0){
            for(int i = 0;i < 6;i++) {
                time[y - 1][i] = "M";
                time[i][y - 1] = "M";
            }
        }

        path.add(x);
        for(int i = 0;i < 6;i++){
            if(!time[x - 1][i].equals("M")){
                travel(i,i,x - 1);
                count[i] += Integer.parseInt(time[x - 1][i]);
                path.add(i + 1);
            }
        }
//        int flag = x - 1;
        //while(flag != 5)
//        for(int i = 0;i < 6;i++){
//            System.out.println(count[i]);
////            count[i] = 0;
//        }
        System.out.println(Arrays.toString(count));
    }

    public static void travel(int pos,int index,int des){
        while(pos != des){
            for(int i = 0;i < 6;i++){
                if(!time[i][pos].equals("M")){
                    count[index] += Integer.parseInt(time[i][pos]);
                    path.add(i + 1);
                    travel(i,index,des);
                }
            }
        }
    }
}
