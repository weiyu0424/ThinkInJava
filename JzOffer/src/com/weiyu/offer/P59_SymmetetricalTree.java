package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/8/2.
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class P59_SymmetetricalTree {
    boolean isSymmetrical(TreeNode pRoot){
        return isSymmetrical(pRoot,pRoot);
    }

    boolean isSymmetrical(TreeNode pRoot1,TreeNode pRoot2){
        if(null == pRoot1 && null == pRoot2)
            return true;
        if(null == pRoot1 || null == pRoot2)
            return false;
        if(pRoot1.val != pRoot2.val)
            return false;

        return isSymmetrical(pRoot1.left,pRoot2.right) && isSymmetrical(pRoot1.right,pRoot2.left);
    }
}
