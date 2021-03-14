package com.ouhzrm.算法.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/3sum/
 * @author(itcode): zhouyh3
 * @create: 2021-03-14 21:08
 **/
public class 三数之和 {
    //图解：https://mmbiz.qpic.cn/mmbiz_gif/ciaqDnJprwv6F831HvaQ2TT2RcWdIXNkPDiaz37VWEPSCk5qFbQSbp1XdUXVJpgYjKVlP9JHwrXBVYQ3aGsj8w5w/640?wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1
    //去重的话,双指针比较合适，hashmap不太合适

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for(int i = 0;i < len;++i) {
            if(nums[i] > 0) return lists;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int curr = nums[i];
            int L = i+1, R = len-1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if(tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }
}
