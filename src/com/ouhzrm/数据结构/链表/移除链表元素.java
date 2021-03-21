package com.ouhzrm.数据结构.链表;

import com.ouhzrm.数据结构.链表.oneway.ListNode;
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

    //递归
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        head.next = removeElements(head.next,val);

        if(head.val == val){
            return head.next;
        }else{
            return head;
        }
    }

    @Test
    public void tes2t(){
        int[] array = new int[]{1,2,6,3,4,5,6};
        ListNode listNode = ListNode.get(array);
        ListNode listNode1 = removeElements2(listNode, 6);
        ListNode.print(listNode1);
    }

    //虚拟头节点
    public ListNode removeElements2(ListNode head, int val) {
        ListNode tmp = new ListNode(val-1);
        tmp.next = head;
        ListNode prev = tmp;
        while(prev.next !=null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return tmp.next;
    }

}
