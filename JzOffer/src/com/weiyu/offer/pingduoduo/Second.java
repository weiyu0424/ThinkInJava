package com.weiyu.offer.pingduoduo;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String num1 = in.next();
			String num2 = in.next();
			System.out.println(multiply(num1, num2));
		}
		in.close();
	}
	
	public static String multiply(String num1, String num2) {
	    int length1 = num1.length();
	    int length2 = num2.length();
	    int[] answer = new int[length1 + length2];
	    for (int i = length1 - 1; i >= 0; i--) {
	        for (int j = length2 - 1; j >= 0; j--) {
	            int index = length1 + length2 - i - j - 2;
	            answer[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
	            answer[index + 1] += answer[index] / 10;
	            answer[index] %= 10;
	        }
	    }
	    StringBuilder stringBuilder = new StringBuilder();
	    for (int i = answer.length - 1; i > 0; i--) {
	        if (stringBuilder.length() == 0 && answer[i] == 0)
	            continue;
	        stringBuilder.append(answer[i]);
	    }
	    stringBuilder.append(answer[0]);
	    return stringBuilder.toString();
	}
}