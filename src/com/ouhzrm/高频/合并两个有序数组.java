package com.ouhzrm.高频;

import org.junit.Test;

/**
 * @description: https://leetcode-cn.com/problems/merge-sorted-array/
 * @author(itcode): zhouyh3
 * @create: 2021-03-23 10:25
 **/
public class 合并两个有序数组 {


    @Test
    public void test(){
        /**
         * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
         * 输出：[1,2,2,3,5,6]
         */
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        merge(nums1,m,nums2,n);
        for(int i : nums1){
            System.out.print(i+",");
        }
    }

    //思路：双指针+从后往前排，注意屁股那部分要加上
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length == m){
            mer(nums2,nums1,n-1,m-1,nums2.length-1);
        }else{
            mer(nums1,nums2,m-1,n-1,nums1.length-1);
        }
    }

    void mer(int[] mainArr,int[] otherArr ,int mainInd, int otherInd,int index){
        //注意边界问题，otherInd>=0 && mainInd >= 0必须要加上
        while(index >= 0 && otherInd>=0 && mainInd >= 0){
            if(mainArr[mainInd] <= otherArr[otherInd]){
                mainArr[index--] = otherArr[otherInd--];
            }else{
                mainArr[index--] = mainArr[mainInd--];
            }
        }
        while(index >= 0 && otherInd>=0){
            mainArr[index--] = otherArr[otherInd--];
        }
        while(index >= 0 && mainInd >= 0){
            mainArr[index--] = mainArr[mainInd--];
        }
    }


    //常规解法
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m+n];
        int i1 = 0;
        int i2 = 0;
        int index = 0;
        while(i1 < m && i2 < n){
            if(nums1[i1] <= nums2[i2]){
                arr[index++] = nums1[i1];
                i1++;
            }else{
                arr[index++] = nums2[i2];
                i2++;
            }
        }
        while(i1 < m){
            arr[index++] = nums1[i1];
            i1++;
        }
        while(i2 < n){
            arr[index++] = nums2[i2];
            i2++;
        }
        if(nums1.length > m){
            for(int i = 0;i<arr.length;i++){
                nums1[i] = arr[i];
            }
        }
        if(nums2.length > n){
            for(int i = 0;i<arr.length;i++){
                nums2[i] = arr[i];
            }
        }
    }

}
