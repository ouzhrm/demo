package com.ouhzrm.算法.树;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-07 14:13
 **/
public class 二叉树的镜像 {
    /**
     * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = mirrorTree(root.left);
        root.left = mirrorTree(temp);
        return root;
    }
}
