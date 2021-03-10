package com.ouhzrm.算法.树_leetcode热门前100道题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-10 15:30
 **/
public class 二叉搜索树的最小绝对差 {


    /**
     * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
     */

    public int getMinimumDifference(TreeNode root) {
        middle(root);
        return min;
    }

    List<Integer> path = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    void middle(TreeNode root){
        if(root == null) return;
        middle(root.left);
        path.add(root.val);
        if(path.size() > 1){
            int tmp = Math.abs(root.val-path.get(path.size()-2));
            if(tmp < min){
                min = tmp;
            }
        }
        middle(root.right);
    }

//    LinkedList<Integer> path = new LinkedList<>();
//    int min = Integer.MAX_VALUE;
//    public int getMinimumDifference(TreeNode root) {
//        back(root);
//        return min;
//    }
//
//    void back(TreeNode root){
//        if(root == null) return;
//        path.add(root.val);
//        if(path.size() > 1){
//            int tmp = Math.abs(root.val-path.get(path.size()-2));
//            if(tmp < min){
//                min = tmp;
//            }
//        }
//        if(root !=null && root.left == null && root.right == null){
//            return;
//        }
//        back(root.left);
//        back(root.right);
//        path.removeLast();
//    }


}
