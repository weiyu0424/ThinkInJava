package com.weiyu.offer.leetcode;

import com.weiyu.offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Wei Yu on 2017/8/17.
 */
public class P1_MinimumDepthOfTree {
    public int run(TreeNode root) {
        if(null == root)
            return 0;
        if(null == root.left){
            return run(root.right) + 1;
        }

        if(null == root.right)
            return run(root.left) + 1;
        int leftDepth = run(root.left);
        int rightDepth = run(root.right);
        return 1 + (leftDepth < rightDepth ? leftDepth : rightDepth);
    }


    public static int run1(TreeNode root){
        if(null == root)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int layer = 1;
        int num = queue.size();
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            num--;
            //layer++;
            if(null == node.left && null == node.right){
                return layer;
            }

            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);

            if(0 == num){
                layer++;
                num = queue.size();
            }

//            if(null == node.left && null == node.right)
//                return layer;
        }
        return layer;
    }

    public static List<Integer> layerTrace(TreeNode root){
        List<Integer> nodes = new ArrayList<>();
        if(null == root)
            return nodes;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            nodes.add(node.val);
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }
        return nodes;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node5.left = node6;
//        List<Integer> treeNodes = P1_MinimumDepthOfTree.layerTrace(root);
//        System.out.println(treeNodes);
        System.out.println(new P1_MinimumDepthOfTree().run1(root));
    }
}
