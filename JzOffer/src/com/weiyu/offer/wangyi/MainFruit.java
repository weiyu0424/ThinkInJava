package com.weiyu.offer.wangyi;

import java.util.Scanner;

public class MainFruit {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int charges = in.nextInt();
		int hasFruits = in.nextInt();
		int hasMoney = in.nextInt();
		int fruitPrice = in.nextInt();

		int survivorDays = 0;
		if (hasMoney / charges >= hasFruits) {
			survivorDays = hasFruits;
			hasMoney = hasMoney - charges * survivorDays;

			int cost = charges + fruitPrice;
			survivorDays += hasMoney / cost;
		} else {
			survivorDays = hasMoney / charges;
		}
		System.out.println(survivorDays);
		in.close();
	}
}
