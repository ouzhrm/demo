package com.ouhzrm.高频.树;

import com.ouhzrm.数据结构.树.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @author(itcode): zhouyh3
 * @create: 2021-03-24 17:17
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 **/
public class 二叉树的后序遍历_迭代解法 {
    /**
     *
     *           1
     *       2       3
     *   4      5  6      7
     *
      */
    @Test
    public  void test(){
        TreeNode root = TreeNode.getTreeByQueue(new Integer[]{1,2,3,4,5,6,7});
        System.out.println(postorderTraversal(root));
    }


    /**
     * 如要实现前序、后序遍历，只需要调整左右子节点的入栈顺序即可。
     */
    class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node,String color){
            this.node = node;
            this.color = color;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root,"white"));

        while(!stack.empty()){
            ColorNode cn = stack.pop();

            if(cn.color.equals("white")){
                //后序遍历
                stack.push(new ColorNode(cn.node,"gray"));
                if(cn.node.right != null) stack.push(new ColorNode(cn.node.right,"white"));
                if(cn.node.left != null)stack.push(new ColorNode(cn.node.left,"white"));
            }else{
                res.add(cn.node.val);
            }
        }

        return res;
    }



}
