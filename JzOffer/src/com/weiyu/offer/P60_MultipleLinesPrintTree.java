package com.weiyu.offer;

import java.util.*;

/**
 * Created by Wei Yu on 2017/8/2.
 */
public class P60_MultipleLinesPrintTree {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> colls = new ArrayList<>();
        if(null == pRoot) {
            return colls;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int count = 1;
        int level = 0;
        ArrayList<Integer> line = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            line.add(node.val);
            count--;

            if(node.left != null){
                queue.add(node.left);
                level++;
            }

            if(node.right != null){
                queue.add(node.right);
                level++;
            }
            //TreeNode removedNode = queue.remove();
            if(0 == count){
                colls.add(line);
                line = new ArrayList<>();
                count = level;
                level = 0;
            }
        }
        return colls;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;
        ArrayList<ArrayList<Integer>> result = new P60_MultipleLinesPrintTree().Print(node1);
        System.out.println(result);
    }
}
