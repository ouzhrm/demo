package com.ouhzrm.算法.链表;

import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-13 18:35
 **/
public class 新增链表元素 {

    //在4前面加个元素3

    @Test
    public void test(){
        int[] array = new int[]{1,2,4,5,6};
        ListNode listNode = ListNode.get(array);
        ListNode result = addElement(listNode, 3,4);
        ListNode.print(result);
    }

    public ListNode addElement(ListNode head, int addVal,int target) {
        if(head == null) return null;
        head.next = addElement(head.next,addVal,target);
        System.out.println(head.val);
        if(head.val == target){
            ListNode newNode = new ListNode(addVal);
            newNode.next = head;
            return newNode;
        }else{
            return head;
        }
    }

}
