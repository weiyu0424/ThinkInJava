package com.weiyu.offer;

import java.util.HashMap;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.nextLine();
		HashMap<String,String> map = new HashMap<String,String>();
		for(int i = 0; i < num; i++){
			String[] s = in.nextLine().split(" ");
			map.put(s[0],s[1]);
		}
		String[] str = in.nextLine().split(" ");
		String start = str[0];
		int size = map.size();
		int i = 0;
		while(!map.get(start).equals(str[1]) && i < size){
			start = map.get(start);
			i++;
		}
		if(!map.get(start).equals(str[1])){
			System.out.println("F");
			return;
		}
		start = str[1];
		i = 0;
		while(!map.get(start).equals(str[0]) && i < size){
			start = map.get(start);
			i++;
		}
		if(map.get(start).equals(str[0])){
			System.out.println("T");
		}else{
			System.out.println("F");
		}
	}

}