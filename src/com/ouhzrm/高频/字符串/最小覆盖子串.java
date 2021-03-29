package com.ouhzrm.高频.字符串;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode-cn.com/problems/minimum-window-substring/
 * @author(itcode): zhouyh3
 * @create: 2021-03-28 16:01
 **/
public class 最小覆盖子串 {


    @Test
    public void test() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    /**
     * 滑动窗口概要代码模板
     *
     **/
//    int left = 0, right = 0;
//
//    while (right < s.size()) {`
//        // 增大窗口
//        window.add(s[right]);
//        right++;
//
//        while (window needs shrink) {
//            // 缩小窗口
//            window.remove(s[left]);
//            left++;
//        }
//    }

    /**
     * 滑动窗口详细代码模板
     **/
//    void slidingWindow(string s, string t) {
//        unordered_map<char, int> need, window;
//        for (char c : t) need[c]++;
//
//        int left = 0, right = 0;
//        int valid = 0;
//        while (right < s.size()) {
//            // c 是将移入窗口的字符
//            char c = s[right];
//            // 右移窗口
//            right++;
//            // 进行窗口内数据的一系列更新
//        ...
//
//            /*** debug 输出的位置 ***/
//            printf("window: [%d, %d)\n", left, right);
//            /********************/
//
//            // 判断左侧窗口是否要收缩
//            while (window needs shrink) {
//                // d 是将移出窗口的字符
//                char d = s[left];
//                // 左移窗口
//                left++;
//                // 进行窗口内数据的一系列更新
//            ...
//            }
//        }
//    }
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            Integer val = need.getOrDefault(c, 0);
            need.put(c, ++val);
        }
        int left = 0, right = 0, valid = 0, start = 0, len = Integer.MAX_VALUE;
        char[] sArr = s.toCharArray();
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = sArr[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                Integer winCount = window.getOrDefault(c, 0);
                Integer neCount = need.getOrDefault(c, 0);
                window.put(c, ++winCount);
                //valid 用于判断窗口是否收缩
                if (winCount == neCount) valid++;
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = sArr[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    Integer win = window.getOrDefault(d, 0);
                    Integer ne = need.getOrDefault(d, 0);
                    if (win == ne) valid--;
                    window.put(d, --win);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
