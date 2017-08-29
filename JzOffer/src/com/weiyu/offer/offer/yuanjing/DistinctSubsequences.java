package com.weiyu.offer.offer.yuanjing;

/**
 * Created by xpZhu on 2017/8/2.
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        int[][] nums = new int[T.length() + 1][S.length() + 1];

        for(int j = 0; j <= S.length(); j++) {
            nums[0][j] = 1;
        }

        for(int i = 0; i < T.length(); i++) {
            for(int j = 0; j < S.length(); j++) {
                if(T.charAt(i) == S.charAt(j)) {
                    nums[i+1][j+1] = nums[i][j] + nums[i+1][j];
                } else {
                    nums[i+1][j+1] = nums[i+1][j];
                }
            }
        }
        return nums[T.length()][S.length()];
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        String pattern = in.nextLine();
        int result = new DistinctSubsequences().numDistinct("acdabefbc", "abb");
        System.out.println(result);
    }
}
