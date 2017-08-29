package com.weiyu.offer.offer.three60;

public class PartitionArray {

    public static int minimalSum(int[] array) {
        int total = sum(array);
        int sum = total / 2;
        int n = array.length / 2;

        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;

        for (int k = 1; k <= 2 * n; k++) {
            int val = array[k - 1];
            for (int i = 1; i <= k && i <= n; i++) {
                for (int v = 1; v <= sum; v++) {
                    if (v >= val && dp[i - 1][v - val])
                        dp[i][v] = true;
                }
            }
        }
        for (int i = sum; i > 0; i--) {
            if (dp[n][i])
                return total - 2 * i;
        }
        return -1;
    }

    private static int sum(int[] array) {
        int sum = 0;
        for (int i : array)
            sum += i;
        return sum;
    }
}