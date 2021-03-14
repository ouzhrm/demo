package com.ouhzrm.算法.链表.oneway;

/**
 * @description: 单向链表model
 * @author(itcode): zhouyh3
 * @create: 2021-03-13 22:12
 **/
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode get(int[] s) {
        ListNode root = new ListNode(s[0]);//生成链表的根节点，并将数组的第一个元素的值赋给链表的根节点
        ListNode other = root;//生成另一个节点，并让other指向root节点，other在此作为一个临时变量，相当于指针
        for (int i = 1; i < s.length; i++) {//由于已给root赋值，所以i从1开始
            ListNode temp = new ListNode(s[i]);//每循环一次生成一个新的节点,并给当前节点赋值
            other.next = temp;//将other的下一个节点指向生成的新的节点
            other = temp;//将other指向最后一个节点(other的下一个节点)  other=other.getNext();
        }
        return root;
    }

    public static void print(ListNode node){
        if(node == null) return;
        System.out.println(node.val);
        print(node.next);
    }
}
