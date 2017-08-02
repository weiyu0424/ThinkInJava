package com.weiyu.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wei Yu on 2017/7/11.
 */
public class LastRemainingSolution {
    public int lastRemaining3(int n,int m){
        if(n < 1 || m < 1)
            return -1;
        int lasting = 0;
        for(int i = 2;i <= n;i++){
            lasting = (lasting + m) % i;
        }
        return lasting;
    }

    public int lastRemaining2(int n, int m) {
        if(m <= 0 || n <= 0)
            return -1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = -1;
        while (list.size() > 1) {
            index = (index + m) % list.size();
            list.remove(index);
            index--;
        }
        return list.get(0);
    }

    public int lastRemaining(int n,int m){
        if(n < 1 || m < 1)
            return -1;
        int[] flag = new int[n];
        int count = n,step = 0,i = -1;
        while(count > 0){
            i++;
            if(i >= n)
                i = 0;
            if(-1 == flag[i])
                continue;
            step++;
            if(m == step){
                step = 0;
                flag[i] = -1;
                count--;
            }
        }
        return i;
    }

    public static void main(String... args) {
//        int result = new LastRemainingSolution().LastRemaining_Solution(6, 7);
        int result = new LastRemainingSolution().lastRemaining3(5, 3);
        System.out.println(result);
    }
}
