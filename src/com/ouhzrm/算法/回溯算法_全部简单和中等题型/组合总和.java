package com.ouhzrm.算法.回溯算法_全部简单和中等题型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-07 15:43
 **/
public class 组合总和 {

    /**
     给定一个无重复元素的数组 candidates 和一个目标数 target ，
     找出 candidates 中所有可以使数字和为 target 的组合。

     candidates 中的数字可以无限制重复被选取。

     说明：

     所有数字（包括 target）都是正整数。
     解集不能包含重复的组合。 
     示例 1：

     输入：candidates = [2,3,6,7], target = 7,
     所求解集为：
     [
     [7],
     [2,2,3]
     ]
     示例 2：

     输入：candidates = [2,3,5], target = 8,
     所求解集为：
     [
       [2,2,2,2],
       [2,3,3],
       [3,5]
     ]
      

     提示：

     1 <= candidates.length <= 30
     1 <= candidates[i] <= 200
     candidate 中的每个元素都是独一无二的。
     1 <= target <= 500
     */

    @Test
    public void test(){
        int[] candidates = new int[]{2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates,target));
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backTrack(candidates,  target,  0, path, result,-1);
        return result;
    }

    void backTrack(int[] candidates, int target, int total,List<Integer> path, List<List<Integer>> result,int index){
        //终止条件
        if(total > target){
            return;
        }
        if(total == target){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i< candidates.length;i++){
            if(i >= index){
                path.add(candidates[i]);
                //做出选择
                total += candidates[i];
                //回溯
                backTrack(candidates,  target,  total,path,  result,i);
                //撤销选择
                path.remove(path.size()-1);
                total -= candidates[i];
            }
        }
    }
}
