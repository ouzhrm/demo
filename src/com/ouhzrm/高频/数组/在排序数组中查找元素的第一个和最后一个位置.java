package com.ouhzrm.高频.数组;

import org.junit.Test;

/**
 * @description: https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @author(itcode): zhouyh3
 * @create: 2021-03-24 15:51
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 **/
public class 在排序数组中查找元素的第一个和最后一个位置 {

    @Test
    public void test1(){
        //
        int[] arr = new int[]{2,2};
        int[] ints = searchRange(arr, 3);
        for(int i :ints){
            System.out.println(i);
        }
    }

    //思路： 二分法，但注意越界问题
    int[] result = new int[]{-1,-1};
    boolean flag = true;
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return result;
        result[0] = getHead(nums, 0, nums.length-1, target);
        return result;
    }

    public int getHead(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] < target) {
                left = middle + 1;
            } else if (arr[middle] > target) {
                right = middle - 1;
            } else {
                if(flag){
                    result[1] = getTail(arr,middle+1,right,target);
                    flag = false;
                }
                right = middle -1;
            }
        }
        //注意越界
        //加条件left < arr.length原因： 如果arr=3,4,4,5, target = 6
        //加条件target == arr[left]原因： 如果arr=5,7,7,8,8,10, target = 6
        if(left < arr.length && target == arr[left]){
            return left;
        }
        return -1;
    }

    //注意越界
    //加条件right >= 0原因： 如果arr=3,4,4,5, target = 2
    //加条件target == arr[right]原因： 如果arr=5,7,7,8,8,10, target = 6
    public int getTail(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] < target) {
                left = middle + 1;
            } else if (arr[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        //注意越界
        if(right >= 0 && target == arr[right]){
            return right;
        }
        return -1;
    }

}
