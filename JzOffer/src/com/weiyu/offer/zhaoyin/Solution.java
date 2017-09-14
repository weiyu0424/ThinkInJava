package com.weiyu.offer.zhaoyin;


class TreeNode {
    public TreeNode left = null;
    public TreeNode right = null;
    public Integer data;
}
public class Solution {
    public boolean hasSubTree(TreeNode node1, TreeNode node2) {
        if(null == node1 || null == node2) {
            return false;
        }
        return subTree(node1,node2) || hasSubTree(node1.left,node2) || hasSubTree(node1.right,node2);
    }
    
    public boolean subTree(TreeNode node1, TreeNode node2){
        if(null == node2)
            return true;
        if(null == node1)
            return false;
        
        if(node1.data != node2.data){
            return false;
        }else {
            return subTree(node1.left,node2.left) && subTree(node1.right,node2.right);
        }
    }
}