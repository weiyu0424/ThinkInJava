package com.weiyu.thinkinginjava.algorithm;

import java.util.Scanner;

public class DateTimeTest1 {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        String datetime = in.next();
        String[] dates = datetime.split("-");
        int sum = 0;
        int flag = 0;
        if (3 != dates.length) {
            System.out.println("invalid input");
            return;
        }
        try {
            int[] months = {0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1};
            int year = Integer.parseInt(dates[0]);
            int month = Integer.parseInt(dates[1]);
            int day = Integer.parseInt(dates[2]);

            int leap = 0;
            if (year >= 10000 || year < 0)
                flag = 1;
            else{
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    leap = 1;
                    if (month == 2 && day > 29) {
                        flag = 1;
                    }
                } else {
                    leap = 0;
                    if (month == 2 && day > 28) {
                        flag = 1;
                    }
                }

                if (month > 12 || month < 1)
                    flag = 1;
                else{
                    if (1 == months[month]) {
                        if (day > 31)
                            flag = 1;
                    } else {
                        if (day > 30)
                            flag = 1;
                    }
                }
            }

            if (1 == flag) {
                System.out.println("invalid input");
                return;
            }

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
            }
            if (leap == 1 && month > 2) {
                sum++;
            }
            sum = sum + day;
            System.out.println(datetime + " is the No." + sum + " day of " + year + ".");
        } catch (NumberFormatException e) {
            System.out.println("invalid input");
        }
    }
}
