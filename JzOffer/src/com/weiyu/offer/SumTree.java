package com.weiyu.offer;

import java.util.ArrayList;

/**
 * Created by Wei Yu on 2017/6/28.
 * 求二叉树的某条路径的和等于某个特定值的路径
 */
public class SumTree {
    public int sum = 0;
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

        if(null == root)
            return result;
        trace(root,target);
        return result;
    }

    public void trace(TreeNode root,int target){
        /*if(null == root) {
            Integer val = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            sum -= val;
            return;
        }*/
        sum += root.val;
        list.add(root.val);
        if(sum == target){
            sum -= root.val;
            result.add(list);
            list = new ArrayList<>(list);
            list.remove(list.size() - 1);
            //list = new ArrayList<>();
            return;
        }else{
            if(null != root.left)
                trace(root.left,target);
            if(null != root.right)
                trace(root.right,target);
            sum -= root.val;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String... args){
        TreeNode node = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
//        node4.left = null;
//        node4.right = null;
//        node5.left = null;
//        node5.right = null;
//        node3.left = null;
//        node3.right = null;
        SumTree tree = new SumTree();
        ArrayList<ArrayList<Integer>> result = tree.FindPath(node, 22);
        for (ArrayList<Integer> list : result) {
            System.out.print(list);
        }
    }
}
