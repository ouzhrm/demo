package com.ouhzrm.other;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2020-11-15 21:23
 **/
public class 滑动窗口 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if(num.length <= 0 || size <= 0 || num.length < size){
            return new ArrayList<Integer>();
        }
        //坑一：没有考虑到size == 1
        if(size == 1){
            ArrayList<Integer> list=new ArrayList<>();
            for(int i:num){
                list.add(i);
            }
            return list;
        }
        ArrayList<Integer> maxList = new ArrayList<>(num.length - size + 1);
        int indexFirst = 0;
        int indexSecond = size - 1;
        int tmp = 0;
        while (indexSecond < num.length) {
            //坑二： 要和tmp比较
            if (num[indexFirst] <= num[indexSecond] && num[indexSecond] > tmp) {
                tmp = num[indexSecond];
            } else if (num[indexFirst] > num[indexSecond] && num[indexFirst] > tmp) {
                tmp = num[indexFirst];
            }
            indexFirst++;
            //坑四： indexFirst == indexSecond 才移动，否则容易跳过一个比较
            if (indexFirst == indexSecond) {
                maxList.add(tmp);
                indexSecond++;
                //坑三： tmp要回归为0
                tmp = 0;
                indexFirst = indexSecond - size + 1;
            }
        }
        return maxList;
    }

    @Test
    public void demo() {
        int[] num = new int[]{10,14,12,11};
        ArrayList<Integer> integers = maxInWindows(num, 1);
        System.out.println(integers);
        //[4,4,6,6,6,5]
    }
}
