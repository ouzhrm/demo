package com.ouhzrm.牛客top200;

import com.ouhzrm.数据结构.链表.oneway.ListNode;

import java.util.HashMap;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-04-21 16:06
 **/
public class 合并有序链表 {

    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        HashMap map = new HashMap();
        map.put("123","123");
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            ListNode tmp = l1.next;
            l1.next = mergeTwoLists(tmp,l2);
            return l1;
        }else{
            ListNode tmp = l2.next;
            l2.next = mergeTwoLists(l1,tmp);
            return l2;
        }

    }

}
