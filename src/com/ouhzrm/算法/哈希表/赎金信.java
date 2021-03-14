package com.ouhzrm.算法.哈希表;

/**
 * @description: https://leetcode-cn.com/problems/ransom-note/
 * @author(itcode): zhouyh3
 * @create: 2021-03-14 20:55
 **/
public class 赎金信 {

    //把数组当哈希表用
    public boolean canConstruct(String ransom, String magazine) {
        if (magazine.length() < ransom.length()) return false;
        int caps[] = new int[26];
        for (char c : ransom.toCharArray()) {
            int index = magazine.indexOf(c, caps[c - 'a']);
            if (index == -1)
                return false;
            caps[c - 97] = index + 1;
        }
        return true;
    }
}
