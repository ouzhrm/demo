package com.ouhzrm.高频.链表;

import com.ouhzrm.数据结构.链表.oneway.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @author(itcode): zhouyh3
 * @create: 2021-03-22 18:05
 **/
public class 合并两个有序链表 {

    //虚拟头节点解法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode tmp = pre;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }else{
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }

        tmp.next = l1 !=null ? l1:l2;
        return pre.next;
    }

}
