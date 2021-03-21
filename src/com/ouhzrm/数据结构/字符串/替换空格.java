package com.ouhzrm.数据结构.字符串;

/**
 * @description: https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/solution/mian-shi-ti-05-ti-huan-kong-ge-by-leetcode-solutio/
 * @author(itcode): zhouyh3
 * @create: 2021-03-16 21:59
 **/
public class 替换空格 {

    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

    //优化减少空间，双指针解法
    //图解：https://mmbiz.qpic.cn/mmbiz_gif/ciaqDnJprwv7SRf2YqUnSPt9bfdD5jA9Pliaznlenvr1dtfPibqqSDfRZibqQOtpqEZeVQ5ibwICaokWvNdPOwGaexA/640?wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1
}
