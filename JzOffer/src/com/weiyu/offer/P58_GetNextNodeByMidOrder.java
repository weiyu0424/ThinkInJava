package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/8/2.
 */
public class P58_GetNextNodeByMidOrder {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //1.如果为空，直接返回空
        if (null == pNode)
            return null;

        //2.如果该节点存在右子节点，则它的第一个右子节点的左节点就是它的下一个节点
        if (pNode.right != null) {
            TreeLinkNode rightNode = pNode.right;
            while (rightNode.left != null)
                rightNode = rightNode.left;
            return rightNode;
        } else if (pNode.next != null) {
            TreeLinkNode parent = pNode.next;

            if(parent != null){
                if(pNode == parent.left){
                    //3.1 如果节点是父节点的左子节点，那么它的下一个节点就是父节点
                    return parent;
                }else{
                    //3.2 如果节点是父节点的右子节点，则需要沿着指针向上遍历，找到一个是它父节点的左子节点的节点，这个节点的父节点就是下一个节点
                    TreeLinkNode pparent = parent.next;
                    while(pparent != null && parent != pparent.left)
                        pparent = pparent.next;
                    return pparent;
                }
            }
        }
        return null;
    }

    /**
     * 剑指offer中的简易写法
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext1(TreeLinkNode pNode){
        //1.如果为空，直接返回空
        if (null == pNode)
            return null;

        //2.如果该节点存在右子节点，则它的第一个右子节点的左节点就是它的下一个节点
        if (pNode.right != null) {
            TreeLinkNode rightNode = pNode.right;
            while (rightNode.left != null)
                rightNode = rightNode.left;
            return rightNode;
        } else if (pNode.next != null) {
            //3.如果节点是父节点的左子节点，那么它的下一个节点就是父节点
            TreeLinkNode pCurrent = pNode;
            TreeLinkNode parent = pNode.next;
            while (parent != null && pCurrent == parent.right) {
                pCurrent = parent;
                parent = parent.next;
            }
            return parent;
        }
        return null;
    }
}
