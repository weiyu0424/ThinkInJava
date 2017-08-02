package com.weiyu.thinkinginjava.jzoffer;

import java.util.Stack;

/**
 * Created by Wei Yu on 2017/6/12.
 */
public class PushPopWithStack {
    /**
     * 一般代码判断push/pop顺序基本上采用辅助栈跟辅助队列的方法来判断
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0;i < pushA.length;i++){
            stack.push(pushA[i]);
            while(j < pushA.length && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
