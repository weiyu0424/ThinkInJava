package com.weiyu.offer.iqyi;

import java.util.Scanner;
import java.util.Stack;

public class SolutionAqy2 {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String ss = in.nextLine();

		char[] chs = ss.toCharArray();

		int depth = findDepth(chs);
		System.out.println(depth);
		in.close();
	}

	private static int findDepth(char[] chs) {
		if (chs == null || chs.length == 0) {
			return 0;
		}
		Stack<Character> stack = new Stack<Character>();
		int max = 0;
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == '(') {
				stack.push('(');
				if (stack.size() > max) {
					max = stack.size();
				}
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}
		}
		return max;
	}
}