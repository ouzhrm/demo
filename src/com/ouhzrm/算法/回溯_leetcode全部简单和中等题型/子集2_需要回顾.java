package com.ouhzrm.算法.回溯_leetcode全部简单和中等题型;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-08 11:46
 **/
public class 子集2_需要回顾 {

    /**
     给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

     说明：解集不能包含重复的子集。

     示例:

     输入: [1,2,2]
     输出:
     [
     [2],
     [1],
     [1,2,2],
     [2,2],
     [1,2],
     []
     ]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/subsets-ii
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){
        int[] nums = new int[]{1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        //关键要排下序
        Arrays.sort(nums);
        backTrack(nums, result, path,0);
        return result;
    }

    void backTrack(int[] nums,  List<List<Integer>> result, List<Integer> path,int index) {
        //终止条件(关键)
        result.add(new ArrayList<>(path));
        if(index >= nums.length){
            return;
        }
        for (int i = index; i < nums.length; i++) {
                //关键一行代码，同级比较，相等剪枝
                //[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
                //[[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
                //[[], [1], [1, 2], [2]]
                if(i > index && nums[i] == nums[i-1]) continue;
                //做出选择
                path.add(nums[i]);
                //递归
                backTrack(nums,result, path,i+1);
                //撤销选择
                path.remove(path.size() - 1);
        }

    }

}
