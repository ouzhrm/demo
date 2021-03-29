package com.ouhzrm.高频.链表;

import com.ouhzrm.数据结构.链表.oneway.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/linked-list-cycle/
 * @author(itcode): zhouyh3
 * @create: 2021-03-22 18:31
 **/
public class 环形链表 {


    @Test
    public void test(){
        ListNode node = new ListNode(1);
        System.out.println(hasCycle(node));
    }

    //解法思想：快慢指针
    public boolean hasCycle(ListNode head) {
        if(head == null) return  false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && slow != null){
            if(fast == slow) return true;
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                fast = fast.next;
            }
            slow = slow.next;
        }
        return false;
    }
}
