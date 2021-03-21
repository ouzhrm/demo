package com.ouhzrm.数据结构.链表;

import com.ouhzrm.数据结构.链表.oneway.ListNode;
import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-13 18:35
 **/
public class 新增链表元素2 {

    int[] array = new int[]{1,2,4,5,6};
    //放到堆中
    ListNode listNode = ListNode.get(array);

    @Test
    public void test(){
        //找到tmp=节点2，在2和4之间插入节点3
        ListNode tmp = listNode;
        ListNode listNode3 = new ListNode(3);
        int index = 0;
        while(index < 1){
            tmp = tmp.next;
            index++;
        }
        listNode3.next = tmp.next;
        tmp.next = listNode3;
        ListNode.print(listNode);
    }

}
