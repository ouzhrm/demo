package com.ouhzrm.牛客top200;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @description: https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey
 * @author(itcode): zhouyh3
 * @create: 2021-04-21 11:15
 **/
public class 最小的K个数 {



    void quickSort(int[] arr, int left, int right,int k){
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
        if(k < middle+1){
            quickSort(arr, left, middle-1,k);
        }else{
            quickSort(arr, middle+1, right,k);
        }
    }

    @Test
    public void test(){
        System.out.println(GetLeastNumbers_Solution2(new int[]{4,5,1,6,2,7,3,8},4));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        quickSort(input, 0, input.length-1,k);
        ArrayList<Integer> list =new ArrayList<>();
        for(int i =0;i < k;i++){
            list.add(input[i]);
        }
        return list;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> items = new ArrayList<Integer>((int) (k / 0.75 + 1));
        //先对堆进行简单小顶堆构造
        int len = input.length - 1;
        if(input.length < k){
            return items;
        }
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(input, i, len);
        }
        int tmp = 0;
        while (len >= 0) {
            //交换栈顶和栈尾
            if (tmp == k) {
                return items;
            }
            items.add(input[0]);
            swap(input, 0, len);
            tmp++;
            //调整堆
            adjustHeap(input, 0, --len);
        }
        return items;
    }

    public void adjustHeap(int[] array, int root, int len) {
        //定义左右指针，临时j指针
        int left, right, j;
        //确保向下迭代时有左右子节点
        while ((left = 2 * root + 1) <= len) {
            right = left + 1;
            j = left;
            //比较左右子节点大小,前提临时j指针不等于len,否则会把已经排好的序重新打乱了
            if (j != len && array[left] > array[right]) {
                j++;
            }
            if (array[root] > array[j]) {
                swap(array, root, j);
            } else {
                break;
            }
            root = j;
        }

    }

    private void swap(int[] array, int root, int j) {
        array[root] ^= array[j];
        array[j] ^= array[root];
        array[root] ^= array[j];
    }

}
