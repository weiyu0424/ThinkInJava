package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/8/4.
 *
 */
public class P16_ReverseList {
    public ListNode ReverseList(ListNode head) {
        ListNode preNode = null;
        ListNode nextNode = null;
        ListNode current = head;
        while(current != null){
            //先保存当前结点的下一个结点
            nextNode = current.next;

            current.next = preNode;
            preNode = current;
            current = nextNode;
        }
        return preNode;
    }
}
