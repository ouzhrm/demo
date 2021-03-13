package com.ouhzrm.算法.数组;

import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-13 12:30
 **/
public class 移除元素 {

    /**
     * https://leetcode-cn.com/problems/remove-element/
     * @param nums
     * @param val
     * @return
     */

    @Test
    public void test(){
        int[] array = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(array,2));
    }

    //双指针思想
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int indVal = 0;
        for(int i = 0; i< nums.length;i++){
            if(nums[i] != val){
                nums[indVal++] = nums[i];
            }else{
                length--;
            }
        }
        return length;
    }
}
