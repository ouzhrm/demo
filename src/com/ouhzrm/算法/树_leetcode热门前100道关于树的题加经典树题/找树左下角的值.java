package com.ouhzrm.算法.树_leetcode热门前100道关于树的题加经典树题;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-07 19:18
 **/
public class 找树左下角的值 {
    /**
     * 513. 找树左下角的值
     * 给定一个二叉树，在树的最后一行找到最左边的值。
     *
     * 示例 1:
     *
     * 输入:
     *
     *     2
     *    / \
     *   1   3
     *
     * 输出:
     * 1
     *
     *
     * 示例 2:
     *
     * 输入:
     *
     *         1
     *        / \
     *       2   3
     *      /   / \
     *     4   5   6
     *        /
     *       7
     *
     * 输出:
     * 7
     *
     *
     * 注意: 您可以假设树（即给定的根节点）不为 NULL。
     *
     */

    int max =-1;
    int val;

    public int findBottomLeftValue(TreeNode root) {
        back(root,1);
        return val;
    }

    void back(TreeNode root ,int height){
        if(root == null) return;
        if(max < height){
            max = height;
            val = root.val;
        }
        back(root.left,height+1);
        back(root.right,height+1);
    }
}
