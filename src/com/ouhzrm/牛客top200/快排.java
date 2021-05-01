package com.ouhzrm.牛客top200;

import org.junit.Test;

/**
 * @description: https://www.nowcoder.com/practice/2baf799ea0594abd974d37139de27896?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey
 * @author(itcode): zhouyh3
 * @create: 2021-04-20 17:35
 **/
public class 快排 {

    @Test
    public void test(){
        int[] ints = MySort(new int[]{6, 5, 4, 3, 2, 1});
        for(int i : ints){
            System.out.println(i);
        }
    }


    public int[] MySort (int[] arr) {
        // write code here
        quickSort(arr,0,arr.length-1);
        return arr;
    }

    void quickSort(int[] arr, int left, int right){
        if(left >= right) return;
        int middle = right;
        int ltmp = left;
        int rtmp = right;
        while(ltmp < rtmp){
            //坑一：要有ltmp <= arr.length-1
            while(ltmp <= arr.length-1 && arr[ltmp] <= arr[middle]){
                ltmp++;
            }
            if(ltmp < rtmp){
                arr[ltmp] ^= arr[middle];
                arr[middle] ^= arr[ltmp];
                arr[ltmp] ^= arr[middle];
                middle = ltmp;
            }
            //坑二：要有rtmp >= 0
            while(rtmp >= 0 && arr[middle] <= arr[rtmp]){
                rtmp--;
            }
            if(ltmp < rtmp){
                arr[middle] ^= arr[rtmp];
                arr[rtmp] ^= arr[middle];
                arr[middle] ^= arr[rtmp];
                middle = rtmp;
            }
        }
        quickSort(arr, left, middle-1);
        quickSort(arr, middle+1, right);
    }

}
