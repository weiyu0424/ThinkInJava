package com.weiyu.thinkinginjava.algorithm;

import java.util.Scanner;

public class DateTimeTest {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        String datetime = in.next();
        String[] dates = datetime.split("-");
        int sum = 0;
        int leap = 0;
        if (3 != dates.length) {
            System.out.println("invalid input");
            return;
        }
        try {
            int year = Integer.parseInt(dates[0]);
            int month = Integer.parseInt(dates[1]);
            int day = Integer.parseInt(dates[2]);
            switch (month) {
                case 1:
                    sum = 0;
                    break;
                case 2:
                    sum = 31;
                    break;
                case 3:
                    sum = 59;
                    break;
                case 4:
                    sum = 90;
                    break;
                case 5:
                    sum = 120;
                    break;
                case 6:
                    sum = 151;
                    break;
                case 7:
                    sum = 181;
                    break;
                case 8:
                    sum = 212;
                    break;
                case 9:
                    sum = 243;
                    break;
                case 10:
                    sum = 273;
                    break;
                case 11:
                    sum = 304;
                    break;
                case 12:
                    sum = 334;
                    break;
                default:
                    System.out.println("invalid input");
                    return;
            }
            sum = sum + day;
            if(year%400==0||(year%4==0&&year%100!=0))
                leap = 1;
            else
                leap = 0;
            if(leap == 1 && month > 2)
                sum++;
            System.out.println(datetime + " is the No." + sum + " day of " + year + ".");
        } catch (NumberFormatException e) {
            System.out.println("invalid input");
        }
    }
}
