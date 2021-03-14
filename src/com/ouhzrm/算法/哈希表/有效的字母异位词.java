package com.ouhzrm.算法.哈希表;

import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-14 17:57
 **/
public class 有效的字母异位词 {

    @Test
    public void test(){
        System.out.println(isAnagram("a","ab"));
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        int[] result = new int[26];
        for(int i = 0; i< schars.length;i++){
            result[schars[i]-'a']++;
            result[tchars[i]-'a']--;
        }
        for(int item : result){
            if(item != 0) return false;
        }
        return true;
    }

}
