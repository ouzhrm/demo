package com.ouhzrm.算法.树_leetcode热门前100道关于树的题加经典树题;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-20 12:09
 **/
public class 二叉树的最近公共祖先_需要回顾 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null; // 1.
        if(left == null) return right; // 3.
        if(right == null) return left; // 4.
        return root; // 2. if(left != null and right != null)
    }
}
