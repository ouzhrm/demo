package com.ouhzrm.高频;

import com.ouhzrm.数据结构.树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @author(itcode): zhouyh3
 * @create: 2021-03-24 17:17
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *  
 *
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 **/
public class 二叉树的前序遍历_迭代解法 {
    /**
     *
     *           1
     *       2       3
     *   4      5  6      7
     *
      */


    //进阶：递归算法很简单，你可以通过迭代算法完成吗？
    class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node,String color){
            this.node = node;
            this.color = color;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root,"white"));

        while(!stack.empty()){
            ColorNode cn = stack.pop();

            if(cn.color.equals("white")){
                if(cn.node.right != null) stack.push(new ColorNode(cn.node.right,"white"));
                if(cn.node.left != null)stack.push(new ColorNode(cn.node.left,"white"));
                //前序遍历
                stack.push(new ColorNode(cn.node,"gray"));
            }else{
                res.add(cn.node.val);
            }
        }

        return res;
    }



}
