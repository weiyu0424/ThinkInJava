package com.weiyu.offer.jd;
import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            HashMap<Double, Integer> pair = new HashMap<>();
            long sum = 0;
            int num = in.nextInt();
            for (int i = 1; i <= num; i++) {
                for (int j = 1; j <= num; j++) {
                    if (pair.containsKey(Math.pow(i, j))) {
                        pair.put(Math.pow(i, j), pair.get(Math.pow(i, j)) + 1);
                    }else{
                        pair.put(Math.pow(i, j), 1);
                    }
                }
            }
            for (Double key : pair.keySet()) {
                int k = pair.get(key);
                if (k >= 2) {
                    sum += k * (k - 1);
                }
            }
            sum = num * num + sum;
            System.out.println(sum % 1000000007);
        }
        in.close();
    }
}
