package com.ouhzrm.算法.树_leetcode热门前100道题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-16 22:06
 **/
public class 二叉树的层序遍历 {
    /**
     给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

      

     示例：
     二叉树：[3,9,20,null,null,15,7],

     3
     / \
     9  20
     /  \
     15   7
     返回其层序遍历结果：

     [
     [3],
     [9,20],
     [15,7]
     ]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){

        TreeNode root = new TreeNode();
        root.val = 1;

        TreeNode left = new TreeNode();
        left.val = 2;
        TreeNode left1 = new TreeNode();
        left1.val = 3;
        TreeNode left2 = new TreeNode();
        left2.val = 4;
        left.left = left1;
        left.right = left2;

        TreeNode right = new TreeNode();
        right.val = 2;
        TreeNode right1 = new TreeNode();
        right1.val = 4;
        TreeNode right2 = new TreeNode();
        right2.val = 3;
        right.left = right1;
        right.right = right2;

        root.left = left;
        root.right = right;
        System.out.println(levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result =  new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> item = new ArrayList<>();
            //关键，记录queue的长度
            int size = queue.size();
            for(int i = 0;i < size;i++){
                TreeNode poll = queue.poll();
                if(poll !=null){
                    item.add(poll.val);
                    if(poll.left !=null){
                        queue.addLast(poll.left);
                    }
                    if(poll.right !=null){
                        queue.addLast(poll.right);
                    }
                }
            }
            if(item.size() > 0){
                result.add(item);
            }

        }

        return result;
    }

}
