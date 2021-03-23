package com.ouhzrm.高频;

import com.ouhzrm.数据结构.链表.oneway.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @author(itcode): zhouyh3
 * @create: 2021-03-23 16:23
 **/
public class 反转链表的一部分 {

    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     *  
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * 输出：[1,4,3,2,5]
     * 示例 2：
     *
     * 输入：head = [5], left = 1, right = 1
     * 输出：[5]
     *  
     *
     * 提示：
     *
     * 链表中节点数目为 n
     * 1 <= n <= 500
     * -500 <= Node.val <= 500
     * 1 <= left <= right <= n
     *  
     *
     * 进阶： 你可以使用一趟扫描完成反转吗？
     */

    //思路：先知道反转前n个节点
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        if(left == 1){
            //right就是要反转的个数
            return reverse(head,right);
        }
        //赋值回原来的head.next，指向下一个链表
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode tmp = null;
    public ListNode reverse(ListNode head, int n) {
        if(n == 1){
            tmp = head.next;//记录第n+1个节点
            return head;
        }
        //first=5
        ListNode first = reverse(head.next,n-1);
        //head=4, head.next=5, head.next.next=head即5->4
        head.next.next = head;
        //删除4->5的引用,并在屁股最后指向第n+1个节点
        head.next = tmp;
        return first;
    }

}
