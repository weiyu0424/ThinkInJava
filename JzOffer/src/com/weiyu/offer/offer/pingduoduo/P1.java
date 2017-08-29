package com.weiyu.offer.offer.pingduoduo;

import java.util.ArrayList;

public class P1 {
    /*
	 * 算法思想：step1：找出所有行中最多1的个数max
	 * 具体做法：从右上角开始找，如果是1，则向左+1，1的个数max+1，否则向下+1.
	 * step2：根据这个数字确定列，遍历该列的所有行，如果该位置为1，则是其中一个结果。
	 */
	public static ArrayList<ArrayList<Integer>> solve(int[][] matrix, int m, int n) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int i = 0, j = n - 1;
		int max = 0;
		while (i < m && j >= 0) {
			if (matrix[i][j] == 1) {
				j--;
				max++;
			} else {
				i++;
			}
		}
		if(max == 0) {
			return result;
		}
		int index = n - max;
		for(int k = 0; k < m; k++) {
			if(matrix[k][index] == 1) {
				ArrayList<Integer> ans = new ArrayList<Integer>();
				ans.add(k+1);
				ans.add(max);
				result.add(ans);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] maxtrix = {{0,0,0,1,1,1}, {0,1,1,1,1,1}, {0,0,0,0,1,1}, {0,1,1,1,1,1}};
		System.out.println(solve(maxtrix, 4, 6));
	}

}