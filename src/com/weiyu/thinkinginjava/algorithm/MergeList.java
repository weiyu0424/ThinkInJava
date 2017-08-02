package com.weiyu.thinkinginjava.algorithm;

/**
 * Created by weiyu on 2017/3/27.
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class MergeList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode sourceNode = null;
        //ListNode node = sourceNode;
        if(list1 == null && list2 == null) return null;
        else if(list1 == null && list2 != null){
            sourceNode = list2;
            list2 = list2.next;
        }else if(list1 != null && list2 == null){
            sourceNode = list1;
            list1 = list1.next;
        }else{
            if(list1.val <= list2.val){
                sourceNode = list1;
                list1 = list1.next;
            }else{
                sourceNode = list2;
                list2 = list2.next;
            }
        }
        ListNode node = sourceNode;
        //if(list1 != null)

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                node.next = list1;
                list1 = list1.next;
            }else{
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        while(list1 != null){
            node.next = list1;
            list1 = list1.next;
            node = node.next;
        }

        while(list2 != null){
            node.next = list2;
            list2 = list2.next;
            node = node.next;
        }
        return sourceNode;
    }
}
