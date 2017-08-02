package com.weiyu.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Wei Yu on 2017/6/22.
 */
public class TreeTrace {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(null == root)
            return null;
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode[] nodes = new TreeNode[Byte.MAX_VALUE];
        int front = -1,rear = -1;
        rear = (rear + 1) % Byte.MAX_VALUE;
        nodes[rear] = root;
        while(front != rear){
            front = (front + 1) % Byte.MAX_VALUE;
            TreeNode node = nodes[front];
            result.add(node.val);
            if(root.left != null){
                rear = (rear + 1) % Byte.MAX_VALUE;
                nodes[rear] = root.left;
            }

            if(root.right != null){
                rear = (rear + 1) % Byte.MAX_VALUE;
                nodes[rear] = root.right;
            }
        }
        return result;
    }
}
