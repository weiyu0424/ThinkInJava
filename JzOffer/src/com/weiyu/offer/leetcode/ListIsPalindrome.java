package com.weiyu.offer.leetcode;

import com.weiyu.offer.ListNode;

/**
 * Created by Wei Yu on 2017/8/22.
 */
public class ListIsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        if(null == head)
            return false;
        int length = 0;
        ListNode node = head;
        while(node != null){
            length++;
            node = node.next;
        }
        if(1 == length)
            return true;

        boolean flag = (length % 2 == 0);
        int halfLength = length / 2;
        ListNode pre = null;
        ListNode next = null;
        node = head;
        while(halfLength != 0){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
            halfLength--;
        }
        if(false == flag){
            node = node.next;
        }
        while(pre != null && node != null){
            if(pre.val == node.val){
                pre = pre.next;
                node = node.next;
            }else{
                return false;
            }
        }

        if(null == pre && null == node)
            return true;

        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        boolean flag = isPalindrome(head);
        System.out.println(flag);
    }
}
