package com.ouhzrm.高频.栈和队列;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @author(itcode): zhouyh3
 * @create: 2021-03-20 12:16
 **/
public class 逆波兰表达式求值 {

    @Test
    public void test(){
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            if("+".equals(token)){
                stack.push(stack.pop() + stack.pop());
                continue;
            }else if("-".equals(token)){
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                //注意先后顺序
                stack.push( pop2-pop1);
                continue;
            }else if("/".equals(token)){
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                //注意先后顺序
                stack.push( pop2/pop1);
                continue;
            }else if("*".equals(token)){
                stack.push(stack.pop() * stack.pop());
                continue;
            }
            stack.push(Integer.parseInt(token));
        }
        return stack.peek();
    }
}
