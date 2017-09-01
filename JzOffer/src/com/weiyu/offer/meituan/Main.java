package com.weiyu.offer.meituan;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = in.nextInt();
		}
		if (judge(array, length))
			System.out.println("Yes");
		else
			System.out.println("No");
		in.close();
	}

	private static boolean judge(int[] array, int n) {
		boolean flag = false;
		Arrays.sort(array);
		int max = array[n - 1];
		int sum = 0;
		for (int i = 0; i < n - 1; i++) {
			sum += array[i];
		}
		if (max <= sum)
			flag = true;
		return flag;
	}
}
