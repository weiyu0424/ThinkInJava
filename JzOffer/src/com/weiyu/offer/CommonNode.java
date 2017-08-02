package com.weiyu.offer;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Wei Yu on 2017/7/7.
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class CommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(null == pHead1 || null == pHead2){
            return null;
        }
        Map<ListNode,Integer> map = new LinkedHashMap<>();
        while(pHead1 != null){
            map.put(pHead1,null == map.get(pHead1) ? 1 : map.get(pHead1) + 1);
            pHead1 = pHead1.next;
        }
        while(pHead2 != null){
            map.put(pHead2,null == map.get(pHead2) ? 1 : map.get(pHead2) + 1);
            pHead2 = pHead2.next;
        }

        Iterator<Map.Entry<ListNode,Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<ListNode,Integer> entry = iterator.next();
            if(2 == entry.getValue()){
                return entry.getKey();
            }
        }

        return null;
    }
}
