package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/9/3.
 */
public class P27_ConvertTreeToDeList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(null == pRootOfTree)
            return null;
        TreeNode lastNode = convertNode(pRootOfTree,null);

        while(lastNode.left != null){
            lastNode = lastNode.left;
        }
        return lastNode;
    }

    private TreeNode convertNode(TreeNode node,TreeNode lastNode) {
        if(null == node)
            return null;
        TreeNode current = node;
        if(current.left != null){
            lastNode = convertNode(current.left,lastNode);
        }
        current.left = lastNode;
        if(null != lastNode)
            lastNode.right = current;

        lastNode = current;

        if(current.right != null)
            lastNode = convertNode(current.right,lastNode);
        return lastNode;
    }

    public static void print(TreeNode node){
        TreeNode preNode = null;
        while(node != null){
            System.out.print(node.val + "->");
            preNode = node;
            node = node.right;
        }
        System.out.println();
        while(preNode != null){
            System.out.print("<-" + preNode.val);
            preNode = preNode.left;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(14);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(16);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.left = node6;
        node5.right = node7;

        TreeNode node = new P27_ConvertTreeToDeList().Convert(node1);
        print(node);
    }
}
