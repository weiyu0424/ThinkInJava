package com.weiyu.offer.tree;

import com.weiyu.offer.TreeNode;

import java.util.*;

/**
 * Created by Wei Yu on 2017/8/17.
 */
public class  TreeTrace {
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


    /**
     * 层次遍历
     * @param root
     * @return
     */
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

    /**
     * 非递归式先序遍历
     * @param root
     */
    public static List<Integer> preOrderIterative(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(null == root)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.val + ",");
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return list;
    }

    /**
     * 非递归式中序遍历
     * @param root
     * @return
     */
    public static List<Integer> midOrderIterative(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(null == root)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = root;
        while(!stack.isEmpty() || head != null){
            if(head != null){
                stack.push(head);
                head = head.left;
            }else{
                head = stack.pop();
                System.out.print(head.val + ",");
                head = head.right;
            }
        }
        return list;
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public static List<Integer> postOrderIterative(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(null == root)
            return list;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        while(!s1.isEmpty()){
            TreeNode node = s1.pop();
            s2.push(node);
            if(null != node.left){
                s1.push(node.left);
            }

            if(null != node.right){
                s1.push(node.right);
            }
        }

        while(!s2.isEmpty()){
            TreeNode node = s2.pop();
            list.add(node.val);
            System.out.print(node.val + ",");
        }
        return list;
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
        List<Integer> treeNodes = TreeTrace.layerTrace(root);
        System.out.println("层次遍历：" + treeNodes);
        System.out.println("=======非递归先序遍历============");
        TreeTrace.preOrderIterative(root);
        System.out.println();
        System.out.println("=======非递归中序遍历============");
        TreeTrace.midOrderIterative(root);
        System.out.println();
        System.out.println("=======非递归后序遍历============");
        TreeTrace.postOrderIterative(root);

    }
}
