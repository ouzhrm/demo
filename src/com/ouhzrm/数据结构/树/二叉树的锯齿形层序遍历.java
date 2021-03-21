package com.ouhzrm.数据结构.树;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-28 13:55
 **/
public class 二叉树的锯齿形层序遍历 {
    /**
     给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

     例如：
     给定二叉树 [3,9,20,null,null,15,7],

     3
     / \
     9  20
     /  \
     15   7
     返回锯齿形层序遍历如下：

     [
     [3],
     [20,9],
     [15,7]
     ]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){

        TreeNode root = new TreeNode();
        root.val = 1;

        TreeNode left = new TreeNode();
        left.val = 2;
        TreeNode left1 = new TreeNode();
        left1.val = 4;
//        TreeNode left2 = new TreeNode();
//        left2.val = 4;
        left.left = left1;
//        left.right = left2;

        TreeNode right = new TreeNode();
        right.val = 3;
//        TreeNode right1 = new TreeNode();
//        right1.val = 4;
        TreeNode right2 = new TreeNode();
        right2.val = 5;
//        right.left = right1;
        right.right = right2;

        root.left = left;
        root.right = right;
        System.out.println(zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int j = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> item = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node != null) {
                    if(j == 0) {
                        item.addLast(node.val);
                    }else {
                        item.addFirst(node.val);
                    }
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }
            j = j == 0 ? 1 : 0;
            result.add(item);
        }
        return result;
    }
}
