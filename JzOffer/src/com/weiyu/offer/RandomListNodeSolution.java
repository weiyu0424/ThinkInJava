package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/6/28.
 * 题目：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 1、复制节点A->A1->B->B1
 * 2、遍历链表：A->random=A->random->next
 * 3、将链表拆分成原链表跟复制后的链表
 */
public class RandomListNodeSolution {
    public RandomListNode Clone(RandomListNode pHead) {
        if(null == pHead)
            return null;
        RandomListNode currentNode = pHead;

        //1、复制节点
        while(currentNode != null){
            RandomListNode node = new RandomListNode(currentNode.label);
            node.random = currentNode.random;
            node.next = currentNode.next;
            currentNode.next = node;
            currentNode = node.next;
        }


        //2、设置节点中的random的值
        currentNode = pHead;
        while(currentNode.next != null){
            RandomListNode node = currentNode.next;
            node.random = node.random.next;
            currentNode = node.next;
        }

        //3、将链表拆分成原链表跟复制后的链表
        RandomListNode duplicateNode = pHead.next;
        currentNode = pHead;
        while(currentNode.next != null){
            RandomListNode node = currentNode.next;
            currentNode.next = node.next;
            currentNode = node;
        }

        return duplicateNode;
    }
}
