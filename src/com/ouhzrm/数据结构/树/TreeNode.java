package com.ouhzrm.数据结构.树;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void prePrintTree(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            prePrintTree(root.left);
            prePrintTree(root.right);
        }
    }

    public static void middlePrintTree(TreeNode root){
        if(root != null){
            prePrintTree(root.left);
            System.out.println(root.val);
            prePrintTree(root.right);
        }
    }

    public static TreeNode getTreeByQueue(Integer[] array){
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

    /**
     *
     * @param array 无
     * @param index 默认值为1
     * @return
     */
    final static int DEFAULT = 1;
    public static TreeNode getTreeByRecur(Integer[] array,int index){
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
