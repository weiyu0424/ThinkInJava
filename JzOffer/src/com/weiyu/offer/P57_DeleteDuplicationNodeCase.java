package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/8/1.
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class P57_DeleteDuplicationNodeCase {
    public ListNode deleteDuplication(ListNode pHead){
        //这里最好的思路是加一个头节点
        ListNode first = new ListNode(-1);
        first.next = pHead;

        ListNode last = first;
        ListNode p = pHead;
        while(p != null && p.next != null){
            if(p.val == p.next.val){
                int val = p.val;
                while(p != null && p.val == val)
                    p = p.next;
                last.next = p;
            }else{
                last = p;
                p = p.next;
            }
        }

        return first.next;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(1);
        ListNode fifth = new ListNode(1);
        ListNode sixth = new ListNode(1);
        ListNode seventh = new ListNode(1);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        ListNode head = new P57_DeleteDuplicationNodeCase().deleteDuplication(first);
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
