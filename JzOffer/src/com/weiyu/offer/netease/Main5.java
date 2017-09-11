package com.weiyu.offer.netease;

import java.util.List;
import java.util.Scanner;

public class Main5 {
	static int result = Integer.MIN_VALUE;
    public static void solution(int[][] num, int j, int length, int count, int l){
		if(l < count){
			return;
		}else{
			result = Math.max(result, count);
		}
		int end = length - 1;
		for(int i = j; i < end; i++){
			for(int p = 0; p < end; p++){
				if(num[i][p] != 0)
					solution(num,p,length,count+1,l);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int length = in.nextInt(), right = in.nextInt();

			int[][] flags = new int[length][length];
			int[] parent = new int[length - 1];

			for (int i = 0; i < length - 1; i++) {
				parent[i] = in.nextInt();
			}

			for (int i = 0; i < length - 1; i++) {
				flags[parent[i]][i + 1] = i + 1;
			}

			int end = length - 1;
			for (int i = 0; i < end; i++) {
				for (int j = 0; j < end; j++) {
					if (flags[i][j] != 0) {
						solution(flags, j, length, 1, right + 1);
					}
				}
			}
			System.out.println(result);
		}
		in.close();
	}

	public static int maxValue(List<Integer> parent, int L){
		int n = parent.size() + 1;
		// Find d, maximum distance from root to a leaf:
		int d = 0;
		for (int i = 1; i < n; i++) {
			int c = 1;
			int x = i;
			while (parent.get(x -1) != 0) {
				x = parent.get(x - 1);
				c++;
			}
			d = Math.max(d, c);
		}
		if (d >= L) {
			return L + 1;
		}
		return Math.min(n, 1 + d + (L - d) / 2);
	}
}