package com.ouhzrm.高频.字符串;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @author(itcode): zhouyh3
 * @create: 2021-03-24 11:50
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 说明：
 *
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 示例 1：
 *
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * 输入："  hello world!  "
 * 输出："world! hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入："a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 示例 4：
 *
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 * 示例 5：
 *
 * 输入：s = "Alice does not even like bob"
 * 输出："bob like even not does Alice"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 *  
 *
 * 进阶：
 *
 * 请尝试使用 O(1) 额外空间复杂度的原地解法。
 *
 **/
public class 翻转字符串里的单词 {

    @Test
    public void test(){
//        System.out.println(reverseWords("  Bob    Loves  Alice   "));
//        System.out.println(reverseWords("Alice does not even like bob"));
//        System.out.println(reverseWords("a good   example"));
//        System.out.println(reverseWords("  hello world!  "));
        String s = reverseWords("a good   example");

        boolean example_good_a = s.equals("example   good a");
        System.out.println(example_good_a);

    }

    @Test
    public void te2st(){
        String a = "example   good a";
        String b = a.replaceAll("\\s+"," ");
        System.out.println(b);
    }

    //快慢指针(先反转单词，然后反转全部)
    public String reverseWords(String s) {
        //1、移除多余的空格(前后)
        int removeStart = 0;
        while(s.charAt(removeStart) == ' '){
            removeStart++;
        }
        int removeEnd = s.length()-1;
        while(s.charAt(removeEnd) == ' '){
            removeEnd--;
        }
        s = s.substring(removeStart, removeEnd+1);

        char[] chars = s.toCharArray();
        int fast = 0;
        int slow = 0;
        while(fast < chars.length){
            if(chars[fast] == ' '){
                swap(chars,slow,fast-1);
                slow = ++fast;
                while(chars[fast] == ' '){
                    fast++;
                    slow++;
                }
            }else{
                fast++;
            }
        }
        swap(chars,slow,chars.length-1);
        swap(chars,0,chars.length-1);
        String s1 = String.valueOf(chars);
        //替换中间多余的空格
        String s2 = s1.replaceAll("\\s+"," ");
        return s2;
    }

    void swap(char[] arr,int start,int end){
        while(start < end){
            arr[start] ^= arr[end];
            arr[end] ^= arr[start];
            arr[start] ^= arr[end];
            start++;
            end--;
        }
    }

}
