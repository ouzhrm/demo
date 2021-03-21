package com.ouhzrm.数据结构.链表;

import com.ouhzrm.数据结构.链表.oneway.ListNode;
import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-14 13:57
 **/
public class 反转链表 {

    @Test
    public void test(){
        int[] array = new int[]{1,2,3,4,5,6};
        ListNode listNode = ListNode.get(array);
        ListNode.print(reverseList(listNode));
        //ListNode.print(reverseList2(listNode));
    }

    //https://leetcode-cn.com/problems/reverse-linked-list/
    //双指针解法
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    //递归解法
    public ListNode reverseList2(ListNode head) {
        return reverse(null,head);
    }

    ListNode reverse(ListNode pre,ListNode cur){
        if(cur == null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        // 可以和双指针法的代码进行对比，如下递归的写法，其实就是做了这两步
        // pre = cur;
        // cur = temp;
        return reverse(cur,temp);
    }
}
