package com.ouhzrm.算法.树_leetcode热门前100道题;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static void prePrintTree(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            prePrintTree(root.left);
            prePrintTree(root.right);
        }
    }

    static void middlePrintTree(TreeNode root){
        if(root != null){
            prePrintTree(root.left);
            System.out.println(root.val);
            prePrintTree(root.right);
        }
    }
}
