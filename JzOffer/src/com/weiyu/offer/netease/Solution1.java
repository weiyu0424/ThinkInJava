package com.weiyu.offer.netease;

import java.util.*;

public class Solution1 {
	public static Stack<Character> getResult(int n) {
		Stack<Character> answer = new Stack<Character>();
		while (n != 0) {
			if (n == 1) {
				answer.push('1');
				break;
			}
			if (n == 2) {
				answer.push('2');
				break;
			}
			if (n % 2 == 0) {
				answer.push('2');
				n = (n - 2) / 2;
			} 
			if(n % 2 != 0){
				answer.push('1');
				n = (n - 1) / 2;
			}
		}
		return answer;
	}
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in 

);
		while (cin.hasNext()) {
			int n = cin.nextInt();
			Stack<Character> answer = getResult(n);
			while (!answer.empty()) {
				System.out.print(answer.pop());
			}
		}
		cin.close();
	}


}
