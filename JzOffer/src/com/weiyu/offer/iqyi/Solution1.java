package com.weiyu.offer.iqyi;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String x1 = String.valueOf(in.nextInt());
			int k1 = in.nextInt();
			String x2 = String.valueOf(in.nextInt());
			int k2 = in.nextInt();

			String result = repeat(x1, k1, x2, k2);
            System.out.println(result);
        }
		in.close();
	}

	private static String repeat(String x1, int k1, String x2, int k2) {
		int length1 = x1.length() * k1;
		int length2 = x2.length() * k2;
		String result = null;
		if(length1 < length2) {
			result = "Less";
		}else if(length1 > length2) {
			result = "Greater";
		} else {
            String result1 = "";
            String result2 = "";
            for(int i = 0; i < k1; i++) {
                result1 += x1;
            }
            for(int i = 0; i < k2; i++) {
                result2 += x2;
            }
            int temp = result1.compareTo(result2);
            if(temp < 0) {
				result = "Less";
            }else if(temp == 0) {
				result = "Equal";
            }else if(temp > 0) {
				result = "Greater";
            }
        }
        return result;
	}
}
