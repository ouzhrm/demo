package com.ouhzrm.算法.树_leetcode热门前100道关于树的题加经典树题;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-07 15:08
 **/
public class 树的子结构_需要回顾 {
    /**
     *https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
     */

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    //递归三要素：1、定义函数
    boolean recur(TreeNode A, TreeNode B) {
        //2、结束条件
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        //3、缩小范围
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
