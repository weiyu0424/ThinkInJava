package com.weiyu.offer;

import java.util.Stack;

/**
 * Created by Wei Yu on 2017/9/6.
 */
public class P7_TwoStacksToQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void offer(int num){
        stack1.push(num);
    }

    public int poll(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }


    public static void main(String[] args) {
        P7_TwoStacksToQueue queue = new P7_TwoStacksToQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        while(!queue.isEmpty()){
            int poll = queue.poll();
            System.out.print(poll + "->");
        }
    }
}
