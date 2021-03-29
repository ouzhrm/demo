package com.ouhzrm.高频.回溯;

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

    List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path =new LinkedList<>();
        back(nums,path,new int[nums.length]);
        return result;
    }

    List<List<Integer>> result = new LinkedList<>();
    private void back(int[] nums, LinkedList<Integer> path,int[] used) {
        if(path.size() == nums.length){
            result.add(new LinkedList<>(path));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(used[i] == 0){
                path.add(nums[i]);
                used[i]++;
                back(nums,path,used);
                used[i]--;
                path.remove(path.size()-1);
            }
        }
    }

}
