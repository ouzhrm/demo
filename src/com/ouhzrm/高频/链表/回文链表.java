package com.ouhzrm.高频.链表;

import com.ouhzrm.数据结构.链表.oneway.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/palindrome-linked-list/
 * @author(itcode): zhouyh3
 * @create: 2021-06-08 14:08
 **/
public class 回文链表 {

    @Test
    public void test(){
        ListNode listNode = ListNode.get(new int[]{1, 2,3, 2, 1});
        System.out.println(isPalindrome(listNode));
        ListNode listNode2 = ListNode.get(new int[]{1, 2, 2, 1});
        System.out.println(isPalindrome(listNode2));
        ListNode listNode3 = ListNode.get(new int[]{1, 2});
        System.out.println(isPalindrome(listNode3));
    }

    //快指针走到末尾，慢指针刚好到中间。其中慢指针将前半部分反转。然后比较。
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;//注意：要写在第一行，防止空指针
            ListNode slowNext = slow.next;
            slow.next = pre;
            pre = slow;
            slow = slowNext;
        }
        if(fast != null){
            slow = slow.next;
        }
        while(pre != null && slow != null){
            if(pre.val != slow.val){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    // pre = slow;
    // slow = slow.next;
    // fast = fast.next.next;
    // pre.next = prepre;
    // prepre = pre;

}
