package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/7/5.
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
public class NumberOfOne {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        int i = 1;
        while((n / i) != 0){
            int before = n / (i * 10);
            int after = n - (n / i) * i;
            int current = (n / i) % 10;
            if(0 == current){
                count += before * i;
            }else if(1 == current){
                count += (before * i + (after + 1));
            }else if(current > 1){
                count += (before + 1) * i;
            }
            i *= 10;
        }
        return count;
    }


    public int getNumberOfIntBetween1AndN(int n, int num){
        int count = 0;
        int i = 1;
        while((n / i) != 0){
            int before = n / (i * 10);
            int after = n - (n / i) * i;
            int current = (n / i) % 10;
            if(current < num){
                count += before * i;
            }else if(num == current){
                count += (before * i + (after + 1));
            }else if(current > num){
                count += (before + 1) * i;
            }
            i *= 10;
        }
        return count;
    }

    public static void main(String... args){
//        int result = new NumberOfOne().NumberOf1Between1AndN_Solution(12013);
        int result = new NumberOfOne().getNumberOfIntBetween1AndN(12013,2);
        System.out.println(result);
    }
}
