package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/9/1.
 */
public class P13_DeleteNodeWithO1 {
    public static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        //1.如果链表为空，删除节点为空
        if(null == head || null == toBeDeleted)
            return null;
        //2.删除节点的下一个节点不为空
        if(toBeDeleted.next != null){
            ListNode nextNode = toBeDeleted.next;
            toBeDeleted.val = nextNode.val;
            toBeDeleted.next = nextNode.next;
        }else if(toBeDeleted == head){
            //3. 如果要删除的点是头节点
            head = null;
        }else{
            //4. 如果要删除的点是尾节点
            ListNode node = head;
            while(node.next != toBeDeleted){
                node = node.next;
            }
            node.next = null;
        }
        return head;
    }
}
