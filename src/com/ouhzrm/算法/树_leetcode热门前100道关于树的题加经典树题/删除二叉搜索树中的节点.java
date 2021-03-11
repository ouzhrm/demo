package com.ouhzrm.算法.树_leetcode热门前100道关于树的题加经典树题;

import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-10 21:17
 **/
public class 删除二叉搜索树中的节点 {

    @Test
    public void test1(){
        TreeNode treeByRecur = TreeNode.getTreeByRecur(new Integer[]{0}, 1);
        TreeNode treeNode = deleteNode(treeByRecur, 0);
        TreeNode.prePrintTree(treeNode);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(key < root.val){
            root.left =  deleteNode(root.left,key);
        }
        if(key > root.val){
            root.right =  deleteNode(root.right,key);
        }
        if(key == root.val){
            if(root.right == null && root.left != null){
                return root.left;
            }
            if(root.right != null && root.left == null){
                return root.right;
            }
            if(root.right == null && root.left == null){
                return null;
            }
            if(root.left != null && root.right != null){
                TreeNode tmp = root.left;
                TreeNode tmp2 = root.right;
                root = root.right;
                while(tmp2 != null){
                    if(tmp2.left == null){
                        tmp2.left = tmp;
                        break;
                    }else{
                        tmp2 = tmp2.left;
                    }
                }
            }
        }
        return root;
    }

}
