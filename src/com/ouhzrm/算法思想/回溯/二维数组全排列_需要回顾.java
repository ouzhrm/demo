package com.ouhzrm.算法思想.回溯;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-01-31 20:24
 **/
public class 二维数组全排列_需要回顾 {

    List<String> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<String> permute(String[][] nums) {
        // 记录「路径」
        // 这里的 选择列表 即包含在nums中
        StringBuilder track = new StringBuilder();
        boolean[][] kawei = new boolean[nums.length][nums[0].length];
        backtrack(nums, track,0,kawei);
        return res;
    }

    @Test
    public void test(){
        System.out.println(permute(new String[][]{{"A","a"},{"B","b"},{"C","c"}}));
        //[ABC, ABc, AbC, Abc, aBC, aBc, abC, abc]
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中的元素
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(String[][] nums, StringBuilder track,int index,boolean[][] kawei) {
        // 触发结束条件
        if (index == nums.length) {
            res.add(track.toString());
            return;
        }

//        for (int i = index; i < nums.length; i++) {
            for(int j = 0; j < 2; j++){
                // 排除不合法的选择
                if (kawei[index][j]) continue;
                // 做选择
                kawei[index][j] = true;
                track.append(nums[index][j]);
                // 进入下一层决策树
                if(index<=nums.length) index++;
                backtrack(nums, track,index,kawei);
                if(index<=(nums.length)) index--;
                // 取消选择，返回上一层决策树
                track.delete((track.length()-nums[index][j].length()),track.length());
                kawei[index][j] = false;
            }
//        }
    }
}
