package com.ouhzrm.算法.树;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-07 21:06
 **/
public class 路径总和2 {
    /**
     https://leetcode-cn.com/problems/path-sum-ii/
     */
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        back(root,targetSum);
        return result;
    }

    void back(TreeNode root, int targetSum){
        if(root == null) return;
        path.add(root.val);
        targetSum -= root.val;
        if(targetSum == 0 && root.left == null && root.right == null){
            result.add(new LinkedList<>(path));
        }
        back(root.left,targetSum);
        back(root.right,targetSum);
        targetSum +=root.val;
        path.removeLast();
    }
}
