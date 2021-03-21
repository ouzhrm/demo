package com.ouhzrm.算法思想.回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-07 11:00
 **/
public class 组合总和二 {
    /**
     给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

     candidates 中的每个数字在每个组合中只能使用一次。

     说明：

     所有数字（包括目标数）都是正整数。
     解集不能包含重复的组合。 
     示例 1:

     输入: candidates = [10,1,2,7,6,1,5], target = 8,
     所求解集为:
     [
     [1, 7],
     [1, 2, 5],
     [2, 6],
     [1, 1, 6]
     ]
     示例 2:

     输入: candidates = [2,5,2,1,2], target = 5,
     所求解集为:
     [
       [1,2,2],
       [5]
     ]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/combination-sum-ii
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        //1,1,2,5,6,7,10
        System.out.println(combinationSum2(candidates,8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backTrack(candidates,  target,  0, path, result,0);
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

        for(int i = index; i< candidates.length;i++){
            if(i > index && candidates[i] == candidates[i-1]) continue;
//            if(i > index){
                path.add(candidates[i]);
                //做出选择
                total += candidates[i];
                //回溯
                backTrack(candidates,  target,  total,path,  result,i+1);
                //撤销选择
                path.remove(path.size()-1);
                total -= candidates[i];
//            }
        }
    }

}
