package com.weiyu.thinkinginjava.jzoffer;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Wei Yu on 2017/6/12.
 * 定义一个数据结构实现栈中的最小值
 */
public class MinValueOfStack {

    private int[] elements = new int[10];
    private Stack<Integer> minStack = new Stack<>();
    private int size = 0;

    public void push(int node) {
        ensureCapacity(size + 1);
        elements[size++] = node;
        int min = 0;
        if(!minStack.isEmpty()){
            min = minStack.peek();
        }else{
            min = Integer.MAX_VALUE;
        }
        if (min < node) {
            minStack.push(min);
        } else {
            minStack.push(node);
        }
    }

    /**
     * 如果插入的值比当前数组的总长度还要大，则对当前数组进行扩容
     *
     * @param size
     */
    private void ensureCapacity(int size) {
        int length = elements.length;
        if (size > length)
            length *= 2;
        elements = Arrays.copyOf(elements, length);
    }

    public void pop() {
        Integer top = top();
        //System.out.println("top:" + top);
        if (top != null) {
            //elements[size - 1] = (Integer) null;
        }
        minStack.pop();
        size--;
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public int top() {
        if (!isEmpty()) {
            if(size - 1 >= 0)
                return elements[size - 1];
        }
        return (Integer) null;
    }

    public int min() {
        int min = minStack.peek();
        System.out.println(min);
        return min;
    }

    public static void main(String... args){
        MinValueOfStack stack = new MinValueOfStack();
        stack.push(3);
        stack.min();
        stack.push(4);
        stack.min();
        stack.push(2);
        stack.min();
        stack.push(3);
        stack.min();
        stack.pop();
        stack.min();
        stack.pop();
        stack.min();
        stack.push(0);
        stack.min();
    }
}
