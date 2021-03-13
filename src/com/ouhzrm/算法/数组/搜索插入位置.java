package com.ouhzrm.算法.数组;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-11 22:33
 **/
public class 搜索插入位置 {

    public int searchInsert(int[] nums, int target) {
        if(nums.length <= 0){
            return 0;
        }
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int middle = (end+start)/2;
            if(nums[middle] < target){
                start = middle+1;
                continue;
            }else if(nums[middle] > target){
                end = middle -1;
                continue;
            }else{
                return middle;
            }
        }
        return -1;
    }

}
