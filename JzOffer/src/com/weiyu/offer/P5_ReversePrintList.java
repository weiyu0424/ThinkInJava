package com.weiyu.offer;

import java.util.ArrayList;

/**
 * Created by Wei Yu on 2017/9/1.
 */
public class P5_ReversePrintList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(null == listNode){
            return list;
        }

        getListFromTail(list,listNode);
        return list;
    }

    private void getListFromTail(ArrayList<Integer> list, ListNode listNode) {
        if(null != listNode){
            if(null != listNode.next){
                getListFromTail(list,listNode.next);
            }
            list.add(listNode.val);
        }
    }
}
