package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/8/4.
 *
 */
public class P16_ReverseList {
    public static ListNode ReverseList(ListNode head) {
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

    public static ListNode ReverseListIterator(ListNode head){
        if(null == head || null == head.next)
            return head;
        ListNode nextNode = head.next;
        head.next = null;
        ListNode node = ReverseListIterator(nextNode);
        nextNode.next = head;
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode root = ReverseListIterator(node1);
        printNode(root);

    }

    private static void printNode(ListNode root) {
        while(null != root){
            System.out.print(root.val + "->");
            root = root.next;
        }
    }
}
