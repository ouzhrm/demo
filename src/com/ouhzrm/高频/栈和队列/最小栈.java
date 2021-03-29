package com.ouhzrm.高频.栈和队列;

/**
 * @description: https://leetcode-cn.com/problems/min-stack/
 * @author(itcode): zhouyh3
 * @create: 2021-03-25 11:39
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 **/
public class 最小栈 {


    class Node{
        int val;
        int min;
        Node next;

        public Node(){}

        public Node(int val,int min){
            this.val = val;
            this.min = min;
        }
    }

    //思路：用链表实现，链表元素是一个对象，每个对象存当前节点之前的最小值
    class MinStack {

        Node head;

        /** initialize your data structure here. */
        public MinStack() {
        }

        public void push(int val) {
            if(head == null){
                head = new Node(val,val);
            }else{
                Node node = new Node(val, val <= head.min ? val : head.min);
                node.next = head;
                head = node;
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }

}
