package com.weiyu.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Wei Yu on 2017/8/11.
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class P65_MaxInWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(null == num || size < 1)
            return list;
        if(num.length >= size){
            Deque<Integer> deque = new LinkedList<>();
            //1、先找size窗口内的最大值
            for(int i = 0;i < size;i++){
                while(!deque.isEmpty() && num[i] > num[deque.getLast()]){
                    deque.removeLast();
                }
                deque.addLast(i);
            }

            //2、再依次将窗口中最大的值加入ArrayList中
            for(int i = size;i < num.length;i++){
                list.add(num[deque.element()]);

                while(!deque.isEmpty() && num[i] > num[deque.getLast()]){
                    deque.removeLast();
                }

                //3、当队列中第一个值已经不再窗口中了，应该将它remove掉
                if(!deque.isEmpty() && deque.element() + size <= i){
                    deque.removeFirst();
                }

                deque.addLast(i);
            }
            list.add(num[deque.element()]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = new int[]{10,14,12,11};
//        int[] array = new int[]{2,3,4,2,6,2,5,1};
        ArrayList<Integer> result = new P65_MaxInWindow().maxInWindows(array, 4);
        System.out.println(result);
    }
}
