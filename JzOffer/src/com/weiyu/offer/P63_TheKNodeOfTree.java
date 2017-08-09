package com.weiyu.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wei Yu on 2017/8/3.
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class P63_TheKNodeOfTree {
    private List<TreeNode> nodes = null;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (null == pRoot || 0 == k)
            return null;
        nodes = new ArrayList<>();
        midOrder(pRoot);
        if (k > nodes.size())
            return null;
        return nodes.get(k - 1);
    }

    private void midOrder(TreeNode pRoot) {
        if (pRoot.left != null) {
            midOrder(pRoot.left);
        }
        nodes.add(pRoot);

        if (pRoot.right != null) {
            midOrder(pRoot.right);
        }
    }
}
