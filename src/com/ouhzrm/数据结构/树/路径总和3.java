package com.ouhzrm.数据结构.树;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-07 21:06
 **/
public class 路径总和3 {
    /**
     https://leetcode-cn.com/problems/path-sum-iii/
     */

    @Test
    public void test(){
        TreeNode treeByRecur = TreeNode.getTreeByRecur(new Integer[]{1,2,null,1}, 1);
        System.out.println(pathSum(treeByRecur,3));
    }

    Map<Integer,Integer> preSumCount = new HashMap<>();
    public int pathSum(TreeNode root, int sum) {
        //前缀和0也是一条路径
        preSumCount.put(0,1);
        return back(root,sum,0);
    }

    /**
     * 前缀和。就是到达当前元素的路径上，之前所有元素的和。
     */

    int back(TreeNode root, int target,int sum){
        if(root == null) return 0;
        //当前节点
        int result = 0;
        sum+=root.val;
        result +=preSumCount.getOrDefault(sum-target,0);
        preSumCount.put(sum,preSumCount.getOrDefault(sum,0)+1);
        result+=back(root.left,target,sum);
        result+=back(root.right,target,sum);
        preSumCount.put(sum,preSumCount.getOrDefault(sum,0)-1);
        sum-=root.val;
        return result;
    }
}
