package com.ouhzrm.算法.树_leetcode热门前100道题;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static void prePrintTree(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            prePrintTree(root.left);
            prePrintTree(root.right);
        }
    }

    static void middlePrintTree(TreeNode root){
        if(root != null){
            prePrintTree(root.left);
            System.out.println(root.val);
            prePrintTree(root.right);
        }
    }

    static TreeNode getTreeByQueue(Integer[] array){
        if(array.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for(int i = 1; i < array.length; i++){
            TreeNode node = queue.peek();
            if(isLeft){
                if(array[i] != null){
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            }else {
                if(array[i] != null){
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }

    //左子树位置是2 * index,右子树位置是2 * index + 1
    static TreeNode getTreeByRecur(Integer[] array,int index){
        if(index > array.length){
            return null;
        }
        Integer val = array[index-1];
        if(val == null){
            return null;
        }
        TreeNode root = new TreeNode(val);
        root.left = getTreeByRecur(array, 2 * index);
        root.right = getTreeByRecur(array, 2 * index+1);
        return root;
    }

}
