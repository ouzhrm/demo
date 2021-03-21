package com.ouhzrm.数据结构.栈和队列;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: https://leetcode-cn.com/problems/implement-stack-using-queues
 * @author(itcode): zhouyh3
 * @create: 2021-03-20 10:17
 **/
public class MyStack {

    @Test
    public void test(){
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        int param_3 = obj.top();
        int param_2 = obj.pop();
        boolean param_4 = obj.empty();

    }

    int length;
    Deque mainQueue;
    Deque otherQueue;

    /** Initialize your data structure here. */
    public MyStack() {
        length = 0;
        mainQueue = new LinkedList();
        otherQueue = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(length == 0) {
            mainQueue.add(x);
            length++;
            return;
        }
        while(!mainQueue.isEmpty()){
            otherQueue.addLast(mainQueue.removeFirst());
        }
        mainQueue.add(x);
        while(!otherQueue.isEmpty()){
            mainQueue.addLast(otherQueue.removeFirst());
        }
        length++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(length > 0){
            length--;
            return (Integer) mainQueue.removeFirst();
        }
        return -1;
    }

    /** Get the top element. */
    public int top() {
        if(length > 0){
            return (Integer) mainQueue.peek();
        }
        return -1;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return length == 0;
    }

}
