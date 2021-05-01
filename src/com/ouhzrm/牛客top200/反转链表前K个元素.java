package com.ouhzrm.牛客top200;

import com.ouhzrm.数据结构.链表.oneway.ListNode;
import org.junit.Test;

/**
 * @description: 反转链表前K个元素
 * @author(itcode): zhouyh3
 * @create: 2021-03-14 13:57
 **/
public class 反转链表前K个元素 {

    @Test
    public void test(){
        int[] array = new int[]{1,2,3,4,5,6};
        ListNode listNode = ListNode.get(array);
        ListNode.print(reverseList(listNode,3));
    }

    ListNode tmp = null;
    public ListNode reverseList(ListNode head,int k) {
        if(k == 1){
            tmp = head.next;
            return head;
        }
        ListNode last = reverseList(head.next,k-1);
        head.next.next = head;
        head.next = tmp;
        return last;
    }
}
