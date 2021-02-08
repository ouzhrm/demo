package com.ouhzrm.算法.回溯算法;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-08 11:27
 **/
public class 幂集_面试题 {
    /**
     幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。

     说明：解集不能包含重复的子集。

     示例:

     输入： nums = [1,2,3]
     输出：
     [
        [3],
       [1],
       [2],
       [1,2,3],
       [1,3],
       [2,3],
       [1,2],
       []
     ]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/power-set-lcci
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){
        int[] nums = new int[]{};
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
