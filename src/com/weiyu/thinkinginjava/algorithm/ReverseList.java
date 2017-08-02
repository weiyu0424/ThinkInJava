package com.weiyu.thinkinginjava.algorithm;

import java.util.Stack;

/**
 * Created by weiyu on 2017/3/21.
 */
public class ReverseList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head.next;
        ListNode result = head.next;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        for(int i = 0;i < stack.size();i++){
            ListNode node = stack.pop();
            result.next = node;
            result = result.next;
            System.out.println(node.val);
        }
        return head;
    }
}
