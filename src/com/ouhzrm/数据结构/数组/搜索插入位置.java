package com.ouhzrm.数据结构.数组;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-11 22:33
 **/
public class 搜索插入位置 {

    //https://leetcode-cn.com/problems/search-insert-position
    //二分法,注意边界
    public int searchInsert(int[] nums, int target) {
//        if(nums.length <= 0){
//            return 0;
//        }
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int middle = (end+start)/2;
            if(nums[middle] < target){
                start = middle+1;
            }else if(nums[middle] > target){
                end = middle -1;
            }else{
                //最左侧那个target,则不返回，end = middle-1;最右那个target, start=middle+1
                return middle;
            }
        }
        //如果是最左侧那个target,最右那个target，那么这块需要加个边界判断
        return start;
    }

}
