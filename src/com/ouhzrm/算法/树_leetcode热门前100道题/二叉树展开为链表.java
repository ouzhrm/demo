package com.ouhzrm.算法.树_leetcode热门前100道题;

import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-17 15:35
 **/
public class 二叉树展开为链表 {

    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *  
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,2,5,3,4,null,6]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6]
     * 示例 2：
     *
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [0]
     * 输出：[0]
     *  
     *
     * 提示：
     *
     * 树中结点数在范围 [0, 2000] 内
     * -100 <= Node.val <= 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){

        TreeNode root = new TreeNode();
        root.val = 1;

        TreeNode left = new TreeNode();
        left.val = 2;
        TreeNode left1 = new TreeNode();
        left1.val = 4;
        TreeNode left2 = new TreeNode();
        left2.val = 5;
        left.left = left1;
        left.right = left2;

        TreeNode right = new TreeNode();
        right.val = 3;
        TreeNode right1 = new TreeNode();
        right1.val = 6;
        TreeNode right2 = new TreeNode();
        right2.val = 7;
        right.left = right1;
        right.right = right2;

        root.left = left;
        root.right = right;
        flatten(root);
    }

    //核心思想：向上整理
    public void flatten(TreeNode root) {
        if(root == null) return;
//        if(root.left != null){
//            TreeNode tmp = new TreeNode(root.left.val);
//            tmp.left= null;
//            tmp.right = root.right;
//            root.right = tmp;
//        }
        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 1、粘一份left right节点出来
        TreeNode left = root.left;
        TreeNode right = root.right;


        // 2、操作root左子树：将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、操作root右子树：找到当前右子树的末端，将原先的右子树接上该末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

}
