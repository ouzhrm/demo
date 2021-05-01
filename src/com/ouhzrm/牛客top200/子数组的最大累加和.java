package com.ouhzrm.牛客top200;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-04-21 22:32
 **/
public class 子数组的最大累加和 {

    public int maxsumofSubarray (int[] arr) {
        // write code here
        if(arr.length == 0 || arr == null) return 0;
        int max = 0;
        int cur = 0;
        for(int i : arr){
            cur  = cur+i;
            max = cur < max? max:cur;
            cur = cur < 0? 0: cur;
        }
        return max;
    }
}
