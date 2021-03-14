package com.ouhzrm.算法.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode-cn.com/problems/two-sum/
 * @author(itcode): zhouyh3
 * @create: 2021-03-14 20:37
 **/
public class 两数之和 {
    //时间复杂度o(n), 借助hashmap
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
