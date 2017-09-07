package com.weiyu.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Wei Yu on 2017/9/6.
 */
public class P7_TwoQueuesToStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int num){
        if(null == queue1 && null == queue2)
            queue1.offer(num);
        if(!queue1.isEmpty()){
            queue1.offer(num);
        }else{
            queue2.offer(num);
        }
    }

    public int pop(){
        if(!queue1.isEmpty()){
            while(1 != queue1.size()){
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }else if(!queue2.isEmpty()){
            while(1 != queue2.size()){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }else{
            throw new NullPointerException("该队列为空");
        }
    }

    public boolean isEmpty(){
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        P7_TwoQueuesToStack stack = new P7_TwoQueuesToStack();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        stack.push(6);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }


}
