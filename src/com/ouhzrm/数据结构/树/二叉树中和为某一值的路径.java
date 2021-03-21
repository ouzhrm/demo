package com.ouhzrm.数据结构.树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-07 16:44
 **/
public class 二叉树中和为某一值的路径 {
    /**
     https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
     */

    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        track(root,sum);
        return list;
    }

    @Test
    public void test(){
        LinkedList<Integer> list = new LinkedList<>();
        list.push(1);
        list.push(2);
        list.push(3);
        System.out.println(list);
        System.out.println(list.poll());
        System.out.println(list);
        System.out.println(list.poll());
        System.out.println(list);
    }

    private void track(TreeNode root, int sum) {
        if(root == null) return;
        //坑二：为保存list的item内部排列顺序，要用add方法
        path.add(root.val);
        sum  = sum - root.val;
        if(sum == 0 && root.left == null && root.right == null){
            //坑一： add的时候需要new一下
            list.add(new LinkedList<>(path));
        }
        track(root.left,sum);
        track(root.right,sum);
        path.removeLast();
    }
}
