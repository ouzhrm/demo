package com.ouhzrm.算法.回溯算法_全部简单和中等题型;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-08 11:22
 **/
public class 字符串的排列_剑指Offer {

    @Test
    public void test() {
        String[] qqes = permutation("aab");
        for (String s : qqes) {
            System.out.println(s);
        }

    }

    public String[] permutation(String s ) {
        StringBuilder path = new StringBuilder();
        char[] chars = s.toCharArray();
        Set<String> tmp = new HashSet<>();
        boolean[] position = new boolean[s.length()];
        backTrack(tmp, path, chars, position);
        String[] result= new String[tmp.size()];
        Iterator<String> iterator = tmp.iterator();
        int i = 0;
        while(iterator.hasNext()){
            String next = iterator.next();
            result[i] = next;
            i++;
        }
        return result;
    }

    void backTrack(Set<String> tmp, StringBuilder path, char[] chars, boolean[] position) {
        //终止条件
        if (path.length() == chars.length && !tmp.contains(path.toString())) {
            tmp.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if(!position[i]){
                //做出选择
                path.append(chars[i]);
                position[i] = true;
                //递归
                backTrack(tmp, path, chars, position);
                //撤销选择
                path.deleteCharAt(path.length() - 1);
                position[i] = false;
            }
        }
    }
}
