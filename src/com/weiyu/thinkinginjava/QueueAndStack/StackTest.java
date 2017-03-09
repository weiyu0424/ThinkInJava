package com.weiyu.thinkinginjava.QueueAndStack;

import java.util.Stack;

/**
 * 通过两个栈实现一个队列的功能
 * Created by weiyu on 2017/3/3.
 */
public class StackTest {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        /*while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }*/
        stack1.push(node);
    }

    public int pop(){
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String... args){
        StackTest stack = new StackTest();
        stack.push(1);
        stack.push(2);
        stack.push(3);

    }
}
