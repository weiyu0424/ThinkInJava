package com.weiyu.offer.offer.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Third {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			int[] array1 = new int[n];
			for(int i = 0; i < n; i++) {
				array1[i] = in.nextInt();
			}
			int m = in.nextInt();
			int[] array2 = new int[m];
			for(int i = 0; i < m; i++) {
				array2[i] = in.nextInt();
			}
			Arrays.sort(array1);
			Arrays.sort(array2);
			int indexFirst = n - 1;
			int indexSecond = m - 1;

			int cnt = 0;
			while(indexFirst >= 0 && indexSecond >= 0) {
				if(array2[indexSecond] >= array1[indexFirst]) {
					cnt++;
					indexFirst--;
					indexSecond--;
				} else {
					indexFirst--;
				}
			}
			System.out.println(cnt);
		}
		in.close();
	}

}
