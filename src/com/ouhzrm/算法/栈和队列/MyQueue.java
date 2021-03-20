package com.ouhzrm.算法.栈和队列;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * @author(itcode): zhouyh3
 * @create: 2021-03-19 09:00
 **/
public class MyQueue {

    @Test
    public void test(){
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

    Stack mainStack;
    Stack otherStack;
    int length;

    /** Initialize your data structure here. */
    public MyQueue() {
        mainStack = new Stack();
        otherStack = new Stack();
        length = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(length == 0) {
            mainStack.push(x);
            length++;
            return;
        }
        while(!mainStack.isEmpty()){
            otherStack.push(mainStack.pop());
        }
        mainStack.push(x);
        while(!otherStack.isEmpty()){
            mainStack.push(otherStack.pop());
        }
        length++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(length > 0){
            length--;
            return (Integer) mainStack.pop();
        }else{
            return 0;
        }
    }

    /** Get the front element. */
    public int peek() {
        return (Integer) mainStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return length == 0;
    }
}
