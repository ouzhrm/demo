package com.ouhzrm.高频.链表;

import com.ouhzrm.数据结构.链表.oneway.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-14 13:57
 **/
public class 反转链表前N个节点 {

    @Test
    public void test(){
        int[] array = new int[]{1,2,3,4,5,6};
        ListNode listNode = ListNode.get(array);
        ListNode.print(reverseList(listNode,3));
        //ListNode.print(reverseList2(listNode));
    }

    ListNode tmp = null;
    public ListNode reverseList(ListNode head, int n) {
        if(n == 1){
            tmp = head.next;//记录第n+1个节点
            return head;
        }
        //first=5
        ListNode first = reverseList(head.next,n-1);
        //head=4, head.next=5, head.next.next=head即5->4
        head.next.next = head;
        //删除4->5的引用,并最后指向第n+1个节点
        head.next = tmp;
        return first;
    }
}
