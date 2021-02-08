package com.ouhzrm.算法;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （4，2，6，1，3，5，7）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {

    static int index = 0;
    static int index2 = 0;
    static TreeNode result = null;
    static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        TreeNode leftNode = KthNode(pRoot.left, k);
        System.out.println("leftNode  = "+ (leftNode == null ? null : leftNode.val));
        if(leftNode != null){
            return leftNode;
        }
        index++;
        System.out.println("pRoot  = "+ (pRoot==null?null:pRoot.val));
        if(index == k){
            return pRoot;
        }
        TreeNode rightNode = KthNode(pRoot.right, k);
        System.out.println("rightNode  = "+ (rightNode==null?null:rightNode.val));
        if(rightNode != null){
            return rightNode;
        }
        return null;
    }

    public static void main(String[] args) {
        //4，2，6，1，3，5，7
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t1.left = t2;
        t1.right = t3;

        System.out.println("result = "+KthNode(t1,2).val);
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "val=" + val;
        }
    }
}

