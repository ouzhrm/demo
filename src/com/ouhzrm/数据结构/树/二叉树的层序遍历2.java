package com.ouhzrm.数据结构.树;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-06 21:40
 **/
public class 二叉树的层序遍历2 {
    /**
     给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

     例如：
     给定二叉树 [3,9,20,null,null,15,7],

     3
     / \
     9  20
     /  \
     15   7
     返回其自底向上的层序遍历为：

     [
     [15,7],
     [9,20],
     [3]
     ]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<LinkedList<Integer>> tmp = new LinkedList<>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0; i< size;i++){
                TreeNode item = queue.poll();
                if(item != null){
                    list.add(item.val);
                    if(item.left != null) queue.addLast(item.left);
                    if(item.right != null) queue.addLast(item.right);
                }
            }
            tmp.addFirst(list);
        }
        result.addAll(tmp);
        return result;
    }
}
