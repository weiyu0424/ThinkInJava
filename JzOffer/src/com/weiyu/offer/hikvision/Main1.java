package com.weiyu.offer.hikvision;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by xpZhu on 2017/9/14.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String line = in.nextLine();
            String[] strs = line.split(",");
            int num = Integer.parseInt(strs[0]);
            if(num < 3){
                System.out.println("incorrect data");
                return;
            }
            String enterDate = strs[1];
            String currentDate = strs[2];

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date begin = format.parse(enterDate);
                Date end = format.parse(currentDate);
                long beginTime = begin.getTime();
                long endTime = end.getTime();
                long inteval = endTime - beginTime;
                long minute = inteval / 1000 / 60;
                long circles = minute / 45 + 1;
                long temp = circles % 45;
                if(temp % 15 == 0) {
                    temp /= 15;
                    System.out.println(circles + ";" + (temp + 1) + "-" + (temp + 1));
                }else{
                    temp /= 15;
                    System.out.println(circles + ";" + (temp + 1) + "-" + (temp + 2));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }
        in.close();
    }
}
