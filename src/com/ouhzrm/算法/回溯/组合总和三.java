package com.ouhzrm.算法.回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-07 11:00
 **/
public class 组合总和三 {
    /**
     找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

     说明：

     所有数字都是正整数。
     解集不能包含重复的组合。 
     示例 1:

     输入: k = 3, n = 7
     输出: [[1,2,4]]
     示例 2:

     输入: k = 3, n = 9
     输出: [[1,2,6], [1,3,5], [2,3,4]]
     */

    @Test
    public void test(){
        System.out.println(combinationSum3(3,7));
//        List<Integer> path = new ArrayList<>();
//        System.out.println(path.get(0));

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k < 0 || n < 1){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrack(n,k,path,result,0);
        return result;
    }

    //start: 2021-02-07 11:01

    void backTrack(int n ,int k,List<Integer> path , List<List<Integer>> result,int sortAscIndex){
        //终止条件
        if(path.size() == k){
            int sum = 0;
            for(int i = 0;i < path.size();i++){
                sum += path.get(i);
            }
            if(sum == n){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for(int i = 1;i <= 9;i++){
            if(!path.contains(i) && sortAscIndex < i){
                //做出选择
                path.add(i);
                //回溯
                backTrack(n ,k, path , result,i);
                //撤回选择
                path.remove(path.size() -1);
            }
        }
    }

}
