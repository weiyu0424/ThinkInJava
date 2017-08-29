package com.weiyu.offer.offer.wangyi;

import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] xCoords = new int[n];
		int[] yCoords = new int[n];
		for (int i = 0; i < n; i++) {
			xCoords[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			yCoords[i] = in.nextInt();
		}
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Math.abs(xCoords[i] - xCoords[j]) + Math.abs(yCoords[i] - yCoords[j]);
			}
		}
		int[] x1 = getResult(matrix, n);
		for (int i = 0; i < n - 1; i++) {
			System.out.print(x1[i] + " ");
		}
		System.out.print(x1[n - 1]);
		in.close();
	}

	public static int[] getResult(int[][] x_y, int n) {
		int[] x = new int[n];
		int[][] x_y1 = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				x[j] = x_y[i][j];
			}
			sort(x);
			for (int k = 1; k < n; k++) {
				x_y1[i][k] += x_y1[i][k - 1] + x[k];
			}
		}
		//int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if (x_y1[j][i] < min) {
					min = x_y1[j][i];
				}
			}
			x[i] = min;
		}
		return x;
	}

	public static int[] sort(int[] x) {
		int temp;
		for (int i = x.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (x[j] > x[j + 1]) {
					temp = x[j];
					x[j] = x[j + 1];
					x[j + 1] = temp;
				}
			}
		}
		return null;
	}

}
