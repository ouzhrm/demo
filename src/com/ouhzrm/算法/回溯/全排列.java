package com.ouhzrm.算法.回溯;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-01-31 20:24
 **/
public class 全排列 {

    @Test
    public void test(){
        System.out.println(permute(new int[]{1,2,3}));
    }

    List<List<Integer>> res = new LinkedList<>();
    /* 主函数，输入一组不重复的数字，返回它们的全排列 */

    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        // 这里的 选择列表 即包含在nums中
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }


    // 路径：记录在 track 中
    // 选择列表：nums 中的元素
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            //System.out.println("进入下一层决策树track = "+track);
            // 取消选择，返回上一层决策树
            track.removeLast();
           // System.out.println("取消选择，返回上一层决策树track = "+track);
        }
    }
}
