package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/9/1.
 */
public class P15_FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(null == head || k <= 0)
            return null;
        ListNode slowNode = head;
        ListNode fastNode = head;
        int item = 0;
        while(item < k - 1){
            fastNode = fastNode.next;
            if(null == fastNode)
                return null;
            item++;
        }

        while(fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        return slowNode;
    }
}
