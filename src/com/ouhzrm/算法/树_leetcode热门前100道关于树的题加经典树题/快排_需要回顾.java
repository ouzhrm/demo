package com.ouhzrm.算法.树_leetcode热门前100道关于树的题加经典树题;

import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-21 15:53
 **/
public class 快排_需要回顾 {

    @Test
    public void test(){
        int[] arr = new int[]{1, 8, 5, 9, 0, 2};
//        int[] arr = new int[]{10, 293, 108 ,161, 783, 376 ,265 ,330 ,598, 646, 812};
//        quickSort(arr,0,arr.length-1);
//        sort(0,arr.length-1,arr);
        quickSort(arr,0,arr.length-1);
        for(int i :arr){
            System.out.print(i+",");
        }
    }

    void quickSort(int[] arr, int l,int r){
        if(l >= r) return;
        int ltmp = l;
        int rtmp = r;
        int middle = l;
        int key = arr[ltmp];
        while(ltmp < rtmp){
            //注意，两个while
            while(ltmp < rtmp && key <= arr[rtmp]){
                rtmp--;
            }
            //注意，两个要有if
            if(ltmp < rtmp){
                middle = rtmp;
                int tmp = arr[rtmp];
                arr[rtmp] = arr[ltmp];
                arr[ltmp] = tmp;
            }

            while(ltmp < rtmp && arr[ltmp] <= key){
                ltmp++;
            }
            if(ltmp < rtmp){
                middle = ltmp;
                int tmp = arr[rtmp];
                arr[rtmp] = arr[ltmp];
                arr[ltmp] = tmp;
            }
        }
        quickSort(arr,l,middle-1);
        quickSort(arr,middle+1,r);
    }
//
//    public void sort2(int[] a, int low, int high) {
//        if (low >= high)
//            return;
//
//        int l = low;
//        int r = high;
//        int key = a[l];
//
//        while (l < r) {
//            while (l < r && a[r] >= key) {
//                r--;
//            }
//            if (l < r) {
//                a[l] = a[r];
//            }
//
//            while (l < r && a[l] < key) {
//                l++;
//            }
//            if (l < r) {
//                a[r] = a[l];
//
//            }else {
//                a[r] = key;
//            }
//        }
//        sort2(a, low, r - 1);
//        sort2(a, r + 1, high);
//    }
//
//
//    public void sort(int left,int right,int[] array) {
//        if (left>=right) return ;
//        int start=left;
//        int end=right;
//        int flag=left;
//        while(left<right) {
//            while ((left<right)&&(array[right]>=array[flag])) {
//                right--;
//            }
//            if (array[right]<array[flag]) {
//                int tmp=array[right];
//                array[right]=array[flag];
//                array[flag]=tmp;
//                flag=right;
//            }
//            while ((left<right)&&(array[left]<=array[flag])) {
//                left++;
//            }
//            if (array[left]>array[flag]) {
//                int tmp=array[left];
//                array[left]=array[flag];
//                array[flag]=tmp;
//                flag=left;
//            }
//        }
////        for(int i :array){
////            System.out.print(i+",");
////        }
////        System.out.println();
//        sort(start, left-1, array);
//        sort(left+1, end, array);
//    }

}
