package com.ouhzrm.数据结构.字符串;

import org.junit.Test;

/**
 * @description: https://leetcode-cn.com/problems/reverse-string/
 * @author(itcode): zhouyh3
 * @create: 2021-03-14 21:53
 **/
public class 反转字符串 {

    @Test
    public void test(){
        reverseString(new char[]{'1','2','3','4','5'});
    }

    public void reverseString(char[] s) {
        for(int i = 0; i< s.length/2;i++){
            swap(s,i,s.length-1-i);
        }
//        for(char i:s){
//            System.out.println(i);
//        }

    }

    //异或运算交换
    private void swap(char[] s,int s1,int s2) {
        s[s1] ^=s[s2];
        s[s2] ^=s[s1];
        s[s1] ^=s[s2];
    }

}
