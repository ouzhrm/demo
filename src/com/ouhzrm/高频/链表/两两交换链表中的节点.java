package com.ouhzrm.高频.链表;

import com.ouhzrm.数据结构.链表.oneway.ListNode;
import org.junit.Test;

/**
 * @description: https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @author(itcode): zhouyh3
 * @create: 2021-03-25 10:24
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例 1：
 *
 * 1 -> 2 -> 3 -> 4
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *  
 *
 * 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 **/
public class 两两交换链表中的节点 {

    @Test
    public void test(){
        ListNode listNode = ListNode.get(new int[]{1, 2, 3,4});
        System.out.println(swapPairs(listNode));

    }

    //进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）

    /**
     * https://pic.leetcode-cn.com/42c91b69e3f38d63a0d0153c440724e69bd2d24b95091b4dcc5c68172f8f4e1e-%E8%BF%AD%E4%BB%A3.gif
     */
    /**
     * pre -> 1 -> 2 -> 3 -> 4 -> null
     */
    //思路： 虚拟头节点 + 双指针
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode tmp = pre;
        while(tmp != null && tmp.next != null && tmp.next.next != null){
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;
            //1 -> 3
            node1.next = node2.next;
            //2 -> 1
            node2.next = node1;
            // pre -> 2
            tmp.next = node2;
            tmp = tmp.next.next;
        }
        return pre.next;
    }
}
