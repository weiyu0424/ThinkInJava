package com.weiyu.offer.dp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main1 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		String[] strs = in.nextLine().split(",");
		solution(strs);
		in.close();
	}

	private static void solution(String[] strs) {
		int number = Integer.parseInt(strs[0]);
		if(number < 3) {
            System.out.println("incorrect data");
        } else {
            String[] beginTime = strs[1].split(" ");
            String[] endTime = strs[2].split(" ");
            String one = beginTime[0];
            String two = beginTime[1];

            String datetwo = endTime[0];
            String timetwo = endTime[1];
            String eL= "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
            Pattern p = Pattern.compile(eL);

            Matcher m = p.matcher(one);
            boolean isDateOne = m.matches();

            m = p.matcher(datetwo);
            boolean isDateTwo = m.matches();

            eL = "(([0-1][0-9])|2[0-3]):[0-5][0-9]:[0-5][0-9]";
            p = Pattern.compile(eL);

            m = p.matcher(two);
            boolean isTimeOne = m.matches();

            m = p.matcher(timetwo);
            boolean isTimeTwo = m.matches();

            if(isDateOne && isDateTwo && isTimeOne && isTimeTwo) {
            } else {
                System.out.println("incorrect data");
            }

        }
	}

}
