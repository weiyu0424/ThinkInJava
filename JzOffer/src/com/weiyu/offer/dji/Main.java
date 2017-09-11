package com.weiyu.offer.dji;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int H = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			int h = in.nextInt();
			int s = in.nextInt();

			float result = getWaterLevel(H, x, y, h, s);
			System.out.println(Math.round(result));
		}
		in.close();
	}

	private static float getWaterLevel(int h, int x, int y, int h2, int s) {
		double threshold = h2 * 1.0/x;
		float result = 0;

		if(s >= threshold){
			if(x <= y){
				result = h2;
			}else{
				result = (float) (h2 + (x - y) * (s - threshold));
				if(result >= h)
					result = h;
			}
        }else{
			result = s*x;
        }
		return result;
	}

}
