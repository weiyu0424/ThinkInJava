package com.weiyu.offer;

import java.util.*;

/**
 * Created by Wei Yu on 2017/8/2.
 */
public class P61_ZigZagPrintTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> colls = new ArrayList<>();
        if(null == pRoot) {
            return colls;
        }

        List<Stack<TreeNode>> stacks = new ArrayList<>();
        stacks.add(new Stack<>());
        stacks.add(new Stack<>());
        int current = 0;
        int next = 1;
        stacks.get(current).push(pRoot);
        ArrayList<Integer> line = new ArrayList<>();
        while(!stacks.get(0).isEmpty() || !stacks.get(1).isEmpty()){
            TreeNode node =  stacks.get(current).pop();
            line.add(node.val);
            if(0 == current){
                if(node.left != null){
                    stacks.get(next).push(node.left);
                }

                if(node.right != null){
                    stacks.get(next).push(node.right);
                }
            }else{
                if(node.right != null){
                    stacks.get(next).push(node.right);
                }

                if(node.left != null){
                    stacks.get(next).push(node.left);
                }
            }

            if(stacks.get(current).isEmpty()){
                current = 1 - current;
                next = 1 - next;
                colls.add(line);
                line = new ArrayList<>();
            }
        }
        return colls;
    }
}
