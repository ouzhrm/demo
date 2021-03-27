package com.ouhzrm.高频;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/valid-parentheses
 * @author(itcode): zhouyh3
 * @create: 2021-03-20 10:48
 **/
public class 有效的括号 {



    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c: chars){
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                if(map.get(c) == stack.peek()){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
