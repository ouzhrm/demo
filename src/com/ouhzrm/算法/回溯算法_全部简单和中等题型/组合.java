package com.ouhzrm.算法.回溯算法_全部简单和中等题型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-13 19:52
 **/
public class 组合 {
    /**
     给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

     示例:

     输入: n = 4, k = 2
     输出:
     [
     [2,4],
     [3,4],
     [2,3],
     [1,2],
     [1,3],
     [1,4],
     ]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/combinations
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){
        System.out.println(combine(4,2));
    }


    public List<List<Integer>> combine(int n, int k) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backTrack(n, k, path, result, 1);
        return result;
    }

    void backTrack(int n, int k, List<Integer> path, List<List<Integer>> result, int index) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i <= n; i++) {
            if (path.contains(i) || (path.size() > 0 && path.get(path.size() - 1) > i)) continue;
            path.add(i);
            backTrack(n, k, path, result, index + 1);
            path.remove(path.size() - 1);
        }
    }

}
