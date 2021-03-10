package com.ouhzrm.算法.树_leetcode热门前100道题;

import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-10 14:47
 **/
public class 最大二叉树 {
    /**
     * https://leetcode-cn.com/problems/maximum-binary-tree/
     */

    @Test
    public void tyee(){
        TreeNode.prePrintTree(constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}));
    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return back(nums,0,nums.length-1);
    }

    TreeNode back(int[] nums,int start,int end) {
        if(start > end) return null;
        int max = 0;
        int maxInd = 0;
        for(int i = start; i<= end;i++){
            if(max <= nums[i]){
                max = nums[i];
                maxInd = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxInd]);
        root.left = back(nums,start, maxInd-1);
        root.right = back(nums,maxInd+1, end);
        return root;
    }
}
