package com.ouhzrm.高频.数组;

import org.junit.Test;

/**
 * @description: https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @author(itcode): zhouyh3
 * @create: 2021-03-21 20:12
 **/
public class 数组中的第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        if(nums == null) return -1;
        int index = nums.length-k;
        if(index < 0) return -1;
        quickSort(nums,0,nums.length-1,index);
        return item;
    }

    int item = -1;
    //选一个中位数，左边比中位数小，右边比中位数大
    void quickSort(int[] arr, int l,int r,int result){
        if (l > r) return;
        int middle = l;
        int key = arr[middle];
        int ltmp = l;
        int rtmp = r;
        while(ltmp < rtmp){
            while(ltmp < rtmp && key <= arr[rtmp]){
                rtmp--;
            }
            if(ltmp < rtmp){
                middle = rtmp;
                swap(arr ,ltmp, rtmp);
            }
            while(ltmp < rtmp && key >= arr[ltmp]){
                ltmp++;
            }
            if(ltmp < rtmp){
                middle = ltmp;
                swap(arr ,ltmp, rtmp);
            }
        }
        if(middle == result) {
            item =  arr[middle];
            return;
        }else if(middle < result){
            item =  arr[middle+1];
            quickSort(arr,middle+1,r,result);
        }else{
            item =  arr[middle-1];
            quickSort(arr,l,middle-1,result);
        }
    }

    public void swap(int[] arr ,int start, int end){
        arr[start] ^= arr[end];
        arr[end] ^= arr[start];
        arr[start] ^= arr[end];
    }

    @Test
    public void test(){
//        int[] arr = new int[]{1, 8, 5, 9, 0, 2};
        int[] arr = new int[]{10, 293, 108 ,161, 783, 376 ,265 ,330 ,598, 646, 812};
//        quickSort(arr,0,arr.length-1);
//        sort(0,arr.length-1,arr);
        int k = 4;
        int index = arr.length-k;
        quickSort(arr,0,arr.length-1,index);
        for(int i :arr){
            System.out.print(i+",");
        }
        System.out.println();
        System.out.println(item);
    }


}
