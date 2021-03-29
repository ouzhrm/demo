package com.ouhzrm.高频.数组;

import com.ouhzrm.数据结构.链表.oneway.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/add-two-numbers/
 * @author(itcode): zhouyh3
 * @create: 2021-03-23 11:05
 **/
public class 两数相加 {

    /**
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     *           [9,9,9,9]
     * 输出：     [8,9,9,9,0,0,0,1]
     */
    /**
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     */
    //思路：迭代递增，
    // 注意
    // 1、边界，
    // 2、最后可能有个0，避免可以加个判断
    // 2、是否需要进1
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //注意边界
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int addOne = 0;
        ListNode result = new ListNode();
        ListNode tmp = result;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int sum = l1.val + l2.val;
                sum = addOne == 1 ? ++sum : sum;
                addOne = sum / 10;
                tmp.val = sum % 10;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                int sum = l1.val;
                sum = addOne == 1 ? ++sum : sum;
                addOne = sum / 10;
                tmp.val = sum % 10;
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                int sum = l2.val;
                sum = addOne == 1 ? ++sum : sum;
                addOne = sum / 10;
                tmp.val = sum % 10;
                l2 = l2.next;
            }
            //注意：多加个判断if (l1 != null || l2 != null)，否则会多出个0
            if (l1 != null || l2 != null){
                tmp.next = new ListNode();
                tmp = tmp.next;
            }
        }
        //注意：还要判断下addOne是否等于1
        if(addOne == 1){
            tmp.next = new ListNode(1);
        }
        return result;
    }

}
