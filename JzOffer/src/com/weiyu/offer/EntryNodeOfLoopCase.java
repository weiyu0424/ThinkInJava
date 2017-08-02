package com.weiyu.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wei Yu on 2017/7/29.
 */
public class EntryNodeOfLoopCase {
    public ListNode EntryNodeOfLoop1(ListNode pHead)
    {
        List<ListNode> nodes = new ArrayList<>();
        if(null == pHead)
            return null;
        ListNode node = pHead;
        while(node != null){
            nodes.add(node);
            if(nodes.contains(node.next))
                return node.next;
            node = node.next;
        }

        return null;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        //1.第一步先找环中的一个点
        ListNode meetingNode = findNodeInLoop(pHead);

        if(null == meetingNode)
            return null;

        //2.第二步环的个数
        int circleCount = 1;
        ListNode node = meetingNode.next;
        while(node != meetingNode){
            circleCount++;
            node = node.next;
        }

        //3.先将第一个节点移动n步
        ListNode first = pHead;
        ListNode second = pHead;
        while(circleCount-- > 0){
            second = second.next;
        }

        while(second != first){
            first = first.next;
            second = second.next;
        }

        return first;
    }

    private ListNode findNodeInLoop(ListNode pHead) {
        if(null == pHead)
            return null;

        ListNode pSlow = pHead.next;
        if(null == pSlow)
            return null;
        ListNode pQuick = pSlow.next;
        while(pSlow != null && pQuick != null){
            if(pSlow == pQuick)
                return pSlow;
            pSlow = pSlow.next;
            pQuick = pQuick.next;
            if(pQuick.next != null){
                pQuick = pQuick.next;
            }
        }
        return null;
    }
}
