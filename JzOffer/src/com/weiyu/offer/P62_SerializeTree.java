package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/8/3.
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class P62_SerializeTree {
    private int index = -1;
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(null == root){
            sb.append("&,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }


    TreeNode Deserialize(String str) {
        index++;
        TreeNode node = null;
        String[] strs = str.split(",");
        String val = strs[index];
        if(!val.equals("&")){
            node = new TreeNode(Integer.valueOf(val));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
