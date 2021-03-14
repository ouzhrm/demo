package com.ouhzrm.算法.链表;

import com.ouhzrm.算法.链表.oneway.ListNode;
import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-13 18:35
 **/
public class 移除链表元素 {

    @Test
    public void test(){
        int[] array = new int[]{1,2,6,3,4,5,6};
        ListNode listNode = ListNode.get(array);
        ListNode listNode1 = removeElements(listNode, 6);
        ListNode.print(listNode1);
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        head.next = removeElements(head.next,val);

        if(head.val == val){
            return head.next;
        }else{
            return head;
        }
    }

}
