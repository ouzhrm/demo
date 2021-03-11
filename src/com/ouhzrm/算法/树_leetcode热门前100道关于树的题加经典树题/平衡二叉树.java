package com.ouhzrm.算法.树_leetcode热门前100道关于树的题加经典树题;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-07 14:06
 **/
public class 平衡二叉树 {

    /**
     https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
     */
    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return flag;
    }
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            flag = false;
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
