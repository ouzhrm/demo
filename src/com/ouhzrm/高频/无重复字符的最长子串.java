package com.ouhzrm.高频;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author(itcode): zhouyh3
 * @create: 2021-03-23 15:26
 *
 * /**
 *      * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *      *
 *      *  
 *      *
 *      * 示例 1:
 *      *
 *      * 输入: s = "abcabcbb"
 *      * 输出: 3
 *      * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *      * 示例 2:
 *      *
 *      * 输入: s = "bbbbb"
 *      * 输出: 1
 *      * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *      * 示例 3:
 *      *
 *      * 输入: s = "pwwkew"
 *      * 输出: 3
 *      * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *      * 示例 4:
 *      *
 *      * 输入: s = ""
 *      * 输出: 0
 *      *  
 *      *
 *      * 提示：
 *      *
 *      * 0 <= s.length <= 5 * 104
 *      * s 由英文字母、数字、符号和空格组成
 **/
public class 无重复字符的最长子串 {

    /**
     * 滑动窗口模板：
     * int left = 0, right = 0;
     *
     * while (right < s.size()) {`
     *     // 增大窗口
     *     window.add(s[right]);
     *     right++;
     *
     *     while (window needs shrink) {
     *         // 缩小窗口
     *         window.remove(s[left]);
     *         left++;
     *     }
     * }
     */

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
    }


    //思路：滑动窗口(最子串问题： 无重复字符的最长子串、最小覆盖子串、至多包含两个不同字符的最长子串、至多包含 K 个不同字符的最长子串等)
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> windows = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while(right < chars.length){
            Integer times = windows.get(chars[right]);
            if(times == null || times <= 0){
                windows.put(chars[right],1);
                int size = windows.keySet().size();
                if(max < size){
                    max = size;
                }
                right++;
                continue;
            }
            while (windows.get(chars[right]) != null && windows.get(chars[right])  > 0){
                Integer count = windows.get(chars[left]);
                if(count > 0){
                    windows.remove(chars[left]);
                }else{
                    windows.put(chars[left],1);
                }
                left++;
            }
        }
        return max;
    }


//    public int lengthOfLongestSubstring(String s) {
//        if (s.length()==0) return 0;
//        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//        int max = 0;
//        int left = 0;
//        for(int i = 0; i < s.length(); i ++){
//            if(map.containsKey(s.charAt(i))){
//                left = Math.max(left,map.get(s.charAt(i)) + 1);
//            }
//            map.put(s.charAt(i),i);
//            max = Math.max(max,i-left+1);
//        }
//        return max;
//
//    }
}
