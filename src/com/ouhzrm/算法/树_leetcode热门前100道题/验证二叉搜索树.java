package com.ouhzrm.算法.树_leetcode热门前100道题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-16 16:02
 **/
public class 验证二叉搜索树 {

    /**
     给定一个二叉树，判断其是否是一个有效的二叉搜索树。

     假设一个二叉搜索树具有如下特征：

     节点的左子树只包含小于当前节点的数。
     节点的右子树只包含大于当前节点的数。
     所有左子树和右子树自身必须也是二叉搜索树。
     示例 1:

     输入:
     2
     / \
     1   3
     输出: true
     示例 2:

     输入:
     5
     / \
     1   4
          / \
         3   6
     输出: false
     解释: 输入为: [5,1,4,null,null,3,6]。
          根节点的值为 5 ，但是其右子节点值为 4 。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/validate-binary-search-tree
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){

        TreeNode root = new TreeNode();
        root.val = 2;
        TreeNode left = new TreeNode();
        left.val = 1;
        TreeNode right = new TreeNode();
        right.val = 3;
        root.left = left;
        root.right = right;
        System.out.println(isValidBST(root));
    }

    boolean result = true;
    List<Integer> path = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        bst(root);
        return result;
    }



    public void bst(TreeNode node){
        if(node == null || !result) return;
        bst(node.left);
        if(path.size() > 0 && path.get(path.size() - 1) >= node.val) {
            result = false;
        }
        path.add(node.val);
        bst(node.right);
    }
}
