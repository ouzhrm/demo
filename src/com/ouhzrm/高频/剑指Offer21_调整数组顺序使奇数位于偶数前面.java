package com.ouhzrm.高频;

import org.junit.Test;

/**
 * @description: https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @author(itcode): zhouyh3
 * @create: 2021-03-28 12:10
 **/
public class 剑指Offer21_调整数组顺序使奇数位于偶数前面 {

    @Test
    public void test(){
        int[] res = exchange(new int[]{1,2,3,4,5,6});
        for(int i : res){
            System.out.print(i+",");
        }
    }

    //思路： 头尾指针向中间靠拢，但注意越界
    public int[] exchange(int[] nums) {
        if (nums.length <= 1) return nums;
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail) {
            //注意越界，需要加上tail >= 0
            while (nums[tail] % 2 == 0 && tail >= 0) {
                tail--;
            }
            //注意越界，需要加上head < nums.length
            while (nums[head] % 2 != 0 && head < nums.length) {
                head++;
            }
            //注意越界，需要加上head < nums.length && tail >= 0
            if (head <= tail && tail >= 0 && head < nums.length) {
                nums[head] ^= nums[tail];
                nums[tail] ^= nums[head];
                nums[head] ^= nums[tail];
                head++;
                tail--;
            }
        }
        return nums;
    }

}
