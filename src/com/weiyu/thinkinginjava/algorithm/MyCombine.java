package com.weiyu.thinkinginjava.algorithm;

import java.util.ArrayList;
import java.util.List;

public class MyCombine {
    public static void main(String[] args) {
        Double[] a = { 0.6,0.3,0.5};
        int num = 2;
        MyCombine tp = new MyCombine();
        for (List<Double> obj : tp.combine(a, num)) {
            for (Double d : obj){
                System.out.print(d + ";");
            }
            System.out.println();
        }
    }

    /**
     * 实现的算法
     * @param a 数据数组
     * @param num M选N中 N的个数
     * @return
     */
    private List<List<Double>>  combine(Double[] a, int num) {
        List<List<Double>> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        String[] b = new String[a.length];
        for (int i = 0; i < b.length; i++) {
            if (i < num) {
                b[i] = "1";
            } else
                b[i] = "0";
        }

        int point = 0;
        int nextPoint = 0;
        int count = 0;
        int sum = 0;
        String temp = "1";
        while (true) {
            List<Double> nums = new ArrayList<>();
            // 判断是否全部移位完毕
            for (int i = b.length - 1; i >= b.length - num; i--) {
                if (b[i].equals("1"))
                    sum += 1;
            }
            // 根据移位生成数据
            for (int i = 0; i < b.length; i++) {
                if (b[i].equals("1")) {
                    point = i;
                    nums.add(a[point]);
//                    sb.append(a[point]);
//                    sb.append(" ");
                    count++;
                    if (count == num)
                        break;
                }
            }
            // 往返回值列表添加数据
            list.add(nums);

            // 当数组的最后num位全部为1 退出
            if (sum == num) {
                break;
            }
            sum = 0;

            // 修改从左往右第一个10变成01
            for (int i = 0; i < b.length - 1; i++) {
                if (b[i].equals("1") && b[i + 1].equals("0")) {
                    point = i;
                    nextPoint = i + 1;
                    b[point] = "0";
                    b[nextPoint] = "1";
                    break;
                }
            }
            // 将 i-point个元素的1往前移动 0往后移动
            for (int i = 0; i < point - 1; i++)
                for (int j = i; j < point - 1; j++) {
                    if (b[i].equals("0")) {
                        temp = b[i];
                        b[i] = b[j + 1];
                        b[j + 1] = temp;
                    }
                }
            // 清空 StringBuffer
            sb.setLength(0);
            count = 0;
        }
        //
        System.out.println("数据长度 " + list.size());
        return list;

    }

}
