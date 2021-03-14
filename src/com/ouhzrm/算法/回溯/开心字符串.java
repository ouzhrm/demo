package com.ouhzrm.算法.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-05 11:21
 **/
public class 开心字符串 {

    /**
     * 一个 「开心字符串」定义为：
     * <p>
     * 仅包含小写字母 ['a', 'b', 'c'].
     * 对所有在 1 到 s.length - 1 之间的 i ，满足 s[i] != s[i + 1] （字符串的下标从 1 开始）。
     * 比方说，字符串 "abc"，"ac"，"b" 和 "abcbabcbcb" 都是开心字符串，但是 "aa"，"baa" 和 "ababbc" 都不是开心字符串。
     * <p>
     * 给你两个整数 n 和 k ，你需要将长度为 n 的所有开心字符串按字典序排序。
     * <p>
     * 请你返回排序后的第 k 个开心字符串，如果长度为 n 的开心字符串少于 k 个，那么请你返回 空字符串 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 1, k = 3
     * 输出："c"
     * 解释：列表 ["a", "b", "c"] 包含了所有长度为 1 的开心字符串。按照字典序排序后第三个字符串为 "c" 。
     * 示例 2：
     * <p>
     * 输入：n = 1, k = 4
     * 输出：""
     * 解释：长度为 1 的开心字符串只有 3 个。
     * 示例 3：
     * <p>
     * 输入：n = 3, k = 9
     * 输出："cab"
     * 解释：长度为 3 的开心字符串总共有 12 个 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"] 。第 9 个字符串为 "cab"
     * 示例 4：                             [aba,    abc,    aca,  acb,    bab,  bac,   bca,   bcb,   cab,   cac,   cba,   cbc]
     * <p>
     * 输入：n = 2, k = 7
     * 输出：""
     * 示例 5：
     * <p>
     * 输入：n = 10, k = 100
     * 输出："abacbabacb"
     *  
     * <p>
     * 提示：
     * 1 <= n <= 10
     * 1 <= k <= 100
     */


//    char[] cs = new char[]{'a','b','c'};
//    List<String> result= new ArrayList<>();
//    int length = 2;
    public String getHappyString(int n, int k) {
        StringBuilder path = new StringBuilder();
        char[] cs = new char[]{'a', 'b', 'c'};
        List<String> result = new ArrayList<>();
        backTrack(path, result, cs, n,-1);
        if(result.size() < k){
            return "";
        }
        return result.get(k-1);
    }

    public static void main(String[] args) {
        StringBuilder path = new StringBuilder();
        char[] cs = new char[]{'a', 'b', 'c'};
        List<String> result = new ArrayList<>();
        int length = 3;
        int k = 9;
        backTrack(path, result, cs, length,-1);
        System.out.println(result.get(k-1));
    }

    static void backTrack(StringBuilder path, List<String> result, char[] cs, int length,int index) {
        //终止条件
        if (path.length() == length) {
            result.add(path.toString());
            return;
        }

        for (int i = 0; i < cs.length; i++) {
            if (index == -1 || cs[i] != cs[index]) {
                //做出选择
                path.append(cs[i]);
                //递归
                backTrack(path, result, cs, length, i);
                //撤销选择
                path.deleteCharAt(path.length() - 1);
            }
        }
    }


}
