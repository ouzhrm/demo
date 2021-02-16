package com.ouhzrm.算法.回溯_leetcode全部简单和中等题型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-06 11:59
 **/
public class 拆解斐波那契数列 {

    /**
     给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。

     形式上，斐波那契式序列是一个非负整数列表 F，且满足：

     0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
     F.length >= 3；
     对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
     另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。

     返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。

     示例 1：

     输入："123456579"
     输出：[123,456,579]
     示例 2：

     输入: "11235813"
     输出: [1,1,2,3,5,8,13]
     示例 3：

     输入: "112358130"
     输出: []
     解释: 这项任务无法完成。
     示例 4：

     输入："0123"
     输出：[]
     解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
     示例 5：

     输入: "1101111"
     输出: [110, 1, 111]
     解释: 输出 [11,0,11,11] 也同样被接受。


     提示：

     1 <= S.length <= 200
     字符串 S 中只含有数字。
     */

    @Test
    public void test(){
        System.out.println(splitIntoFibonacci("1101111"));
    }

    public List<Integer> splitIntoFibonacci(String S) {

        if (S.length() < 3) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrack(S, result,path, 0,S.length());
        return result;
    }

    Boolean flag = false;
    String max = Integer.MAX_VALUE+"";


    void backTrack(String s, List<Integer> result,List<Integer> path, int index , int strLength) {
        //终止条件
        if(path.size() > 2 && (path.get(path.size() -3)+ path.get(path.size()-2)) != (path.get(path.size() -1))){
            return;
        }
        if (strLength == index) {
            int j = 0;
            while (j < (path.size() - 2)) {
                if ((path.get(j) + path.get(j + 1)) == path.get(j + 2)) {
                    if(j+3 == path.size() && !flag){
                        result.addAll(path);
                        flag = true;
                        break;
                    }
                    j++;
                }else{
                    break;
                }
            }
            return;
        }
        if(flag) return;
        for (int i = 0; i <= s.length(); i++) {
            String substring = s.substring(0, i);
            if (substring.length() > 0) {
                if(substring.length() > max.length()
                        || Long.parseLong(substring) > Long.valueOf(Integer.MAX_VALUE+"")
                        || (substring.charAt(0) == '0' && substring.length() > 1)){
                    continue;
                }
                //做出选择
                path.add(Integer.parseInt(substring));
                //回溯
                backTrack(s.substring(i), result, path,(index + substring.length()),strLength);
                //撤销选择
                path.remove(path.size() - 1);
            }
        }
    }
}
