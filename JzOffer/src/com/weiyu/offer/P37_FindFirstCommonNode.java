package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/9/2.
 */
public class P37_FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(null == pHead1 || null == pHead2)
            return null;
        int len1 = length(pHead1);
        int len2 = length(pHead2);
        int gap = len1 - len2;
        ListNode nodeLong = pHead1;
        ListNode nodeShort = pHead2;
        if(len1 < len2){
            gap = len2 - len1;
            nodeLong = pHead2;
            nodeShort = pHead1;
        }

        for(int i = 0;i < gap;i++){
            nodeLong = nodeLong.next;
        }

        while(nodeLong != null && nodeShort != null && nodeLong.val != nodeShort.val){
            nodeLong = nodeLong.next;
            nodeShort = nodeShort.next;
        }
        return nodeLong;
    }

    public int length(ListNode node){
        int length = 0;
        while(node != null){
            length++;
            node = node.next;
        }
        return length;
    }
    public static void main(String[] args) {

    }
}
