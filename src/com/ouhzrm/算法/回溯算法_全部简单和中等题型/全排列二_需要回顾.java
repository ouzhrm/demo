package com.ouhzrm.算法.回溯算法_全部简单和中等题型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-09 16:19
 **/
public class 全排列二_需要回顾 {
    /**
     给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

      

     示例 1：

     输入：nums = [1,1,2]
     输出：
     [[1,1,2],
     [1,2,1],
     [2,1,1]]
     示例 2：

     输入：nums = [1,2,3]
     输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
      

     提示：

     1 <= nums.length <= 8
     -10 <= nums[i] <= 10

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/permutations-ii
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){
        int[] nums = new int[]{1,2,3};
        System.out.println(permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] kengwei = new boolean[nums.length];
        backTrack(nums, result, path,kengwei);
        return result;
    }

    void backTrack(int[] nums,List<List<Integer>> result, List<Integer> path,boolean[] kengwei){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i< nums.length;i++){
            if(!kengwei[i]){
                //最关键的一行代码，同级相等剪枝
                if(i > 0 && nums[i] == nums[i - 1] && kengwei[i - 1] == false) continue;
                path.add(nums[i]);
                kengwei[i] = true;
                backTrack( nums, result,  path, kengwei);
                kengwei[i] = false;
                path.remove(path.size()-1);
            }

        }

    }
}
