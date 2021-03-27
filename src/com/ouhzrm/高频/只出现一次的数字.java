package com.ouhzrm.高频;

/**
 * @description: https://leetcode-cn.com/problems/single-number/
 * @author(itcode): zhouyh3
 * @create: 2021-03-27 16:13
 **/
public class 只出现一次的数字 {

    //思路： 异或
    public int singleNumber(int[] nums) {
        int num  = nums[0];
        for(int i = 1; i< nums.length;i++){
            num ^= nums[i];
        }
        return num;
    }

}
