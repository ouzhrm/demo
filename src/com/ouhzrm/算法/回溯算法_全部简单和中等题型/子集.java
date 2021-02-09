package com.ouhzrm.算法.回溯算法_全部简单和中等题型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-08 11:46
 **/
public class 子集 {

    /**
     给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

     示例 1：

     输入：nums = [1,2,3]
     输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     示例 2：

     输入：nums = [0]
     输出：[[],[0]]
      

     提示：

     1 <= nums.length <= 10
     -10 <= nums[i] <= 10
     nums 中的所有元素 互不相同

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/subsets
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrack(nums, result, path,-1);
        result.add(new ArrayList<>());
        return result;
    }

    void backTrack(int[] nums, List<List<Integer>> result,  List<Integer> path,int index) {
        if (path.size() > 0) {
            result.add(new ArrayList<>(path));
        }
        //终止条件(关键)
        if(index >= (nums.length-1)){
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //不能选自己需要i > index
            if(i > index){
                //做出选择
                path.add(nums[i]);
                //递归
                backTrack(nums, result, path,i);
                //撤销选择
                path.remove(path.size() - 1);
            }
        }
    }
}
