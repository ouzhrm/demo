package com.ouhzrm.高频;

import com.ouhzrm.数据结构.链表.oneway.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @author(itcode): zhouyh3
 * @create: 2021-03-22 17:25
 **/
public class 相交链表 {

    /**
     * 考虑构建两个节点指针 A​ , B 分别指向两链表头节点 headA , headB ，做如下操作：
     *
     * 指针 A 先遍历完链表 headA ，再开始遍历链表 headB ，当走到 node 时，共走步数为：
     * a + (b - c)
     * a+(b−c)
     *
     * 指针 B 先遍历完链表 headB ，再开始遍历链表 headA ，当走到 node 时，共走步数为：
     * b + (a - c)
     * b+(a−c)
     *
     * 如下式所示，此时指针 A , B 重合，并有两种情况：
     *
     * a + (b - c) = b + (a - c)
     * a+(b−c)=b+(a−c)
     */
    //解法1：双指针
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpB = headB;
        ListNode tmpA = headA;
        while(tmpB != tmpA){//如果这块不相交，tmpB=tmpA=null会跳出循环
            tmpA = tmpA == null?headB:tmpA.next;
            tmpB = tmpB == null?headA:tmpB.next;
        }
        return tmpA;
    }

    //TODO:解法二：hashmap(key=ListNode, value++)
}
