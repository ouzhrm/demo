package com.ouhzrm.高频;

import com.ouhzrm.数据结构.链表.oneway.ListNode;
import org.junit.Test;

/**
 * @description: https://leetcode-cn.com/problems/reverse-linked-list/
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

    //递归解法2
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

    //递归解法3
    public ListNode reverseList3(ListNode head) {
        //有个坑，head==null需要加上
        if(head == null || head.next == null) return head;
        //first=5
        ListNode first = reverseList(head.next);
        //head=4, head.next=5, head.next.next=head即5->4
        head.next.next = head;
        //删除4->5的引用
        head.next = null;
        return first;
    }
}
