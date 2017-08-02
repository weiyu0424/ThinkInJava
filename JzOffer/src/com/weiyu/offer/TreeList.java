package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/6/29.
 */
public class TreeList {
    public TreeNode convert(TreeNode root) {
        if(null == root)
            return null;
        if(null == root.left && null == root.right)
            return root;

        TreeNode left = convert(root.left);
        while(left != null && left.right != null)
            left = left.right;

        if(left != null){
            root.left = left;
            left.right = root;
        }

        TreeNode right = convert(root.right);
        if(right != null){
            root.right = right;
            right.left = root;
        }
        return left != null ? left : root;
    }


    public TreeNode Convert(TreeNode pRootOfTree) {
        if(null == pRootOfTree)
            return null;
        if(null == pRootOfTree.left && null == pRootOfTree.right)
            return pRootOfTree;

        TreeNode left = convert(pRootOfTree.left);
        TreeNode temp = left;
        while(temp != null && temp.right != null)
            temp = temp.right;

        if(left != null){
            pRootOfTree.left = temp;
            temp.right = pRootOfTree;
        }

        TreeNode right = convert(pRootOfTree.right);
        if(right != null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left != null ? left : pRootOfTree;
    }
}
