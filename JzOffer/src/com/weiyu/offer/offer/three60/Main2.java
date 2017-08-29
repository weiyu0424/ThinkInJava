package com.weiyu.offer.offer.three60;

import java.util.Scanner;

public class Main2 {

    public static int sum(int a[],int len)
    {
        int res = 0;
        for(int i=0;i<len;++i)
        {
            res = res + a[i];
        }
        return res;
    }

    public static boolean isXinRangeA(int x,int A)
    {
        if((x < A && x > 0) ||(x > A && x < 0))
            return true;
        return false;
    }

    public static void exchangeAB(int[] a, int[] b,int aLen,int bLen)
    {
        int A = sum(a,aLen) - sum(b,bLen);
        double min = a[0] - b[0] - A / 2.0;
        int ii = 0;
        int jj = 0;
        int flag = 0;
        if(A == 0)
            return ;
        for(int i = 0;i < aLen;++i)
        {
            for(int j = 0;j < bLen;++j)
            {
                int x = a[i] - b[j];
                if( x == 0)
                    continue;
                if(isXinRangeA(x,A))
                {
                    double tmp = x - A/2.0;
                    if(tmp < min)
                    {
                        min = tmp;
                        flag = 1;
                        ii = i;
                        jj = j;
                    }
                }
            }
        }
        if(flag == 1)
        {
            int temp = a[ii];
            a[ii] = b[jj];
            b[jj] = temp;
            exchangeAB(a,b,aLen,bLen);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] nums = new int[length];
        for(int i = 0;i < length;i++){
            nums[i] = in.nextInt();
        }

        int bLength = in.nextInt();
        int[] bNums = new int[bLength];
        for(int i = 0;i < bLength;i++){
            bNums[i] = in.nextInt();
        }
        exchangeAB(nums,bNums,nums.length,bNums.length);
        System.out.println(Math.abs(sum(nums,nums.length) - sum(bNums,bNums.length)));
    }
}
