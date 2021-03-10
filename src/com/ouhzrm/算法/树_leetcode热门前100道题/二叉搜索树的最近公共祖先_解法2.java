package com.ouhzrm.算法.树_leetcode热门前100道题;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-07 15:21
 **/
public class 二叉搜索树的最近公共祖先_解法2 {
    /**
     https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((p.val-root.val) * (q.val - root.val) <= 0){
            return root;
        }
        return lowestCommonAncestor(p.val < root.val ? root.left:root.right,p,q);
    }
}
