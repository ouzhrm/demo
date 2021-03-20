package com.ouhzrm.算法.栈和队列;

/**
 * @description: https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * @author(itcode): zhouyh3
 * @create: 2021-03-20 11:07
 **/
public class 删除字符串中的所有相邻重复项 {

    //这是一种解法
    //另外一种解法可以用到栈，跟有效的括号.java解法类似
    public String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        char[] result = new char[chars.length];
        if(chars.length == 0) return S;
        int reLen = 0;
        for(int i = 0;i <chars.length;i++){
            if(reLen <= 0){
                result[reLen++] = chars[i];
            }else{
                int index = reLen -1;
                if(chars[i] == result[index]){
                    result[--reLen] = chars[i];
                }else{
                    result[reLen++] = chars[i];
                }
            }
        }
        return String.copyValueOf(result,0,reLen);
    }

}
