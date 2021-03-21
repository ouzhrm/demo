package com.ouhzrm.数据结构.数组;

import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-13 15:55
 **/
public class 长度最小的子数组 {

    @Test
    public void test(){
        int[] items = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,items));
    }

    //滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        int slow = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int count = 0;

        for(int fast = 0; fast < nums.length;fast++){
            if(sum < target){
                sum+=nums[fast];
                count++;
            }
            while(sum >= target){
                if(min == Integer.MAX_VALUE || min > count){
                    min = count;
                }
                sum-=nums[slow];
                slow++;
                count--;
            }

        }
        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }

}
