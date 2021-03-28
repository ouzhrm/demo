package com.ouhzrm.高频;

import org.junit.Test;

/**
 * @description: https://leetcode-cn.com/problems/sqrtx/
 * @author(itcode): zhouyh3
 * @create: 2021-03-28 10:48
 **/
public class 平方根 {

    @Test
    public void test(){
        System.out.println(mySqrt(2147395599));
    }

    //思路： 二分查找, 让ans的2次方无限接近x
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int left = 0;
        int right = x;
        int ans = 0;
        while(left <= right){
            int middle = (left + right) >>> 1;
            //注意：这块防止int最大值越界，需要加个long转换，举例：x=2147395599
            if((long)middle * middle <= x){
                ans = middle;
                //注意：这块不是break
                //break;
                left = middle+1;
            }else{
                right = middle-1;
            }
        }
        return ans;
    }

}
