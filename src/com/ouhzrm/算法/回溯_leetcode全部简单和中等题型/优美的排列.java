package com.ouhzrm.算法.回溯_leetcode全部简单和中等题型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-11 17:50
 **/
public class 优美的排列 {

    /**
     假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：

     第 i 位的数字能被 i 整除
     i 能被第 i 位上的数字整除
     现在给定一个整数 N，请问可以构造多少个优美的排列？

     示例1:

     输入: 2
     输出: 2
     解释:

     第 1 个优美的排列是 [1, 2]:
     第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
     第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除

     第 2 个优美的排列是 [2, 1]:
     第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
     第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
     说明:

     N 是一个正整数，并且不会超过15。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/beautiful-arrangement
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){

//        System.out.println(countArrangement(15));
        System.out.println(9/2);

    }

    int result = 0;
    public int countArrangement(int n) {
        boolean[] kengwei = new boolean[n];
        List<Integer> path = new ArrayList<>();
        backTrack(n , path,  kengwei);
        return result;
    }

    void backTrack(int n , List<Integer> path, boolean[] kengwei){
        if(path.size() == n){
            ++result;
        }
        if(path.size() >= n){
            return;
        }

        for(int i = 1; i <= n;i++){
            if(!kengwei[i-1] && ((i % (path.size()+1) == 0) || ((path.size()+1) % i == 0))){
                path.add(i);
                kengwei[i-1] = true;
                backTrack(n,  path,  kengwei);
                path.remove(path.size()-1);
                kengwei[i-1] = false;
            }
        }

    }
}
