package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/8/4.
 */
public class P17_MergeList {

    /**
     * 非递归的方式，合并时需要先确定头节点，
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }
        ListNode sourceNode = null;
        ListNode node = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                //在循环中每次都需要做类似的判断，性能会有影响
                if (null == sourceNode) {
                    node = sourceNode = list1;
                } else {
                    node.next = list1;
                    node = node.next;
                }
                list1 = list1.next;
            } else {
                if (null == sourceNode) {
                    sourceNode = node = list2;
                } else {
                    node.next = list2;
                    node = node.next;
                }
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            node.next = list1;
        }
        if (list2 != null)
            node.next = list2;
        return sourceNode;
    }


    /**
     * 第二种方式，一开始就确定合并后链表的头节点
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }
        ListNode sourceNode = null;

        //先确定头结点，这样不用在循环中每次都进行判断
        if (list1.val < list2.val) {
            sourceNode = list1;
            list1 = list1.next;
        } else {
            sourceNode = list2;
            list2 = list2.next;
        }

        ListNode node = sourceNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                node = node.next;
                list1 = list1.next;
            } else {
                node.next = list2;
                node = node.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            node.next = list1;
        }
        if (list2 != null)
            node.next = list2;
        return sourceNode;
    }


    /**
     * 第三种是通过递归的方式来合并两个链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if(null == list1)
            return list2;
        else if(null == list2)
            return list1;

        ListNode head = null;
        if(list1.val < list2.val){
            head = list1;
            head.next = Merge2(list1.next,list2);
        }else{
            head = list2;
            head.next = Merge2(list1,list2.next);
        }
        return head;
    }
}
