package com.ouhzrm.算法.树;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-07 11:19
 **/
public class 二叉树最小深度 {

    public int minDepth(TreeNode root) {
        if(root  == null )return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0 || right == 0){
            return 1+left+right;
        }
        return 1+Math.min(left,right);
    }
}
