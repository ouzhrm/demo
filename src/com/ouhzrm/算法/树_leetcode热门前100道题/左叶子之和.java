package com.ouhzrm.算法.树_leetcode热门前100道题;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-07 19:31
 **/
public class 左叶子之和 {
    /**
     *https://leetcode-cn.com/problems/sum-of-left-leaves/
     */
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        back(root,false);
        return sum;
    }

    void back(TreeNode root,boolean flag){
        if(root == null) return;
        //坑一： 左叶子节点要加上root.left == null && root.right == null
        if(flag && root.left == null && root.right == null){
            sum+=root.val;
        }
        back(root.left,true);
        back(root.right,false);
    }
}
