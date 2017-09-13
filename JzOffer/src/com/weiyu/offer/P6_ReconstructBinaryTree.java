package com.weiyu.offer;

import java.util.*;

/**
 * Created by Wei Yu on 2017/9/6.
 */
public class P6_ReconstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = constructCore(pre,0,pre.length - 1,in,0,in.length - 1);
        return root;
    }

    public TreeNode constructCore(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        if(preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode node = new TreeNode(pre[preStart]);
        for(int i = inStart;i <= inEnd;i++){
            if(pre[preStart] == in[i]){
                node.left = constructCore(pre,preStart + 1,preStart + i - inStart,in, inStart, i - 1);
                node.right = constructCore(pre,preStart + i - inStart + 1, preEnd,in,i + 1,inEnd);
                break;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = new P6_ReconstructBinaryTree().reConstructBinaryTree(pre, in);
        List<Integer> nodes = preTrace(root);
        System.out.println("非递归前序遍历：" + nodes);

        List<Integer> midNodes = midTrace(root);
        System.out.println("非递归中序遍历：" + midNodes);

        List<Integer> postNodes = postTrace(root);
        System.out.println("非递归后序遍历：" + postNodes);

        List<Integer> layerNodes = layerTrace(root);
        System.out.println("层次遍历：" + layerNodes);
    }


    /**
     * 非递归先序遍历
     * @param root
     * @return
     */
    public static List<Integer> preTrace(TreeNode root){
        if(null == root)
            return null;
        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            nodes.add(node.val);
            if(null != node.right)
                stack.push(node.right);
            if(null != node.left)
                stack.push(node.left);
        }
        return nodes;
    }

    /**
     * 非递归中序遍历
     * @param root
     * @return
     */
    public static List<Integer> midTrace(TreeNode root){
        List<Integer> nodes = new ArrayList<>();
        if(null == root)
            return nodes;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                TreeNode node = stack.pop();
                nodes.add(node.val);
                root = node.right;
            }
        }
        return nodes;
    }


    /**
     * 非递归后续遍历
     * @param root
     * @return
     */
    public static List<Integer> postTrace(TreeNode root){
        List<Integer> nodes = new ArrayList<>();
        if(null == root)
            return nodes;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(null != node.left)
                stack1.push(node.left);

            if(null != node.right)
                stack1.push(node.right);
        }

        while(!stack2.isEmpty()){
            nodes.add(stack2.pop().val);
        }

        return nodes;
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
        queue.offer(root);
        int count = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            count--;
            nodes.add(node.val);
            if(null != node.left){
                queue.offer(node.left);
            }

            if(null != node.right){
                queue.offer(node.right);
            }

            if(0 == count){
                System.out.println();
                count = queue.size();
            }
        }
        return nodes;
    }
}
