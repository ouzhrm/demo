package com.ouhzrm.算法.树;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-07 15:21
 **/
public class 二叉搜索树的最近公共祖先 {
    /**
     https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }
}
