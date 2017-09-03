package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/9/3.
 */
public class P26_RandomListNodeClone {
    public RandomListNode Clone(RandomListNode pHead){
        //1. 将原始的A->B->C->D链表克隆成A->A'->B->B'->C->C'->D->D'
        cloneNode(pHead);

        //2. 复制原链表的random指针
        cloneRandomPointer(pHead);
        print(pHead);

        //3. 将原始链表跟克隆的链表拆开
        RandomListNode clonedHead = splitConnectedList(pHead);
        return clonedHead;
    }

    private RandomListNode splitConnectedList(RandomListNode pHead) {
        RandomListNode node = pHead;
        RandomListNode clonedHead = null;
        RandomListNode clonedNode = null;
        if(pHead != null){
            clonedHead = pHead.next;
        }
        /*if(node != null){
            clonedHead = clonedNode = node.next;
            node.next = clonedNode.next;
            node = node.next;
        }*/
        while(node != null){
            //clonedNode.next = node.next;
            clonedNode = node.next;
            node.next = clonedNode.next;
            node = node.next;
            //执行最后一次循环的时候node已经是空了，所以最后一条指令是不能执行的
            if(node != null)
                clonedNode.next = node.next;
        }
        return clonedHead;
    }

    private void cloneRandomPointer(RandomListNode pHead) {
        RandomListNode node = pHead;
        while(node != null){
            RandomListNode clonedNode = node.next;
            if(null != node.random){
                clonedNode.random = node.random.next;
            }
            node = clonedNode.next;
        }
    }

    private void cloneNode(RandomListNode pHead) {
        RandomListNode node = pHead;
        while(node != null){
            RandomListNode clonedNode = new RandomListNode(node.label);
            clonedNode.next = node.next;
            clonedNode.random = null;
            node.next = clonedNode;
            node = clonedNode.next;
        }
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = node3;
        node2.random = node5;
        node3.random = null;
        node4.random = node2;
        node5.random = null;
        RandomListNode clonedNode = new P26_RandomListNodeClone().Clone(node1);
        System.out.println();
        print(clonedNode);
    }

    public static void print(RandomListNode pHead){
        RandomListNode node = pHead;
        while(node != null){
            System.out.print(node.label + "->");
            node = node.next;
        }

        node = pHead;
        while(null != node){
            if(null != node.random){
                System.out.print(node.random.label + "->");
            }
            node = node.next;
        }
    }
}
