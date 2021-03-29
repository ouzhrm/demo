package com.ouhzrm.高频.链表;

import com.ouhzrm.数据结构.链表.oneway.ListNode;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-23 13:50
 **/
public class 排序链表 {
    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     *
     * 进阶：
     *
     * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     *  
     *
     * 示例 1：
     *
     *
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     * 示例 2：
     *
     *
     * 输入：head = [-1,5,3,4,0]
     * 输出：[-1,0,3,4,5]
     * 示例 3：
     *
     * 输入：head = []
     * 输出：[]
     *  
     *
     * 提示：
     *
     * 链表中节点的数目在范围 [0, 5 * 104] 内
     * -105 <= Node.val <= 105
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

//    public ListNode sortList(ListNode head) {
//        if(head == null) return head;
//        return null;
//    }

    //（比较难理解）归并排序+快慢指针
    //解法：https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/

    /**
     * 分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
     * 我们使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
     * 找到中点 slow 后，执行 slow.next = None 将链表切断。
     * 递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
     * cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。
     */
    public ListNode sortList(ListNode head) {
        //快慢指针
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null; //截断链表，因为slow=head有关联
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        return merge(left, right);//归并
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }


//        public ListNode sortList(ListNode head) {
//            quickSort(head, null);
//            return head;
//        }

//    void quickSort(ListNode head, ListNode tail){
//        if(head == tail || head.next == tail) return;
//        int pivot = head.val;
//        ListNode left = head, cur = head.next;
//
//        while(cur != tail){
//            if(cur.val < pivot){
//                left = left.next;
//                swap(left, cur);
//            }
//            cur = cur.next;
//        }
//        swap(head, left);
//        quickSort(head, left);
//        quickSort(left.next, tail);
//    }


//    public ListNode sortList(ListNode head) {
//        if(head==null)
//            return null;
//        ListNode end=head;
//        int length=0;
//        while(end!=null){
//            length++;
//            end=end.next;
//        }
//        ListNode emptyHead = new ListNode(0, head);
//        for(int i=1;i<length;i<<=1){
//            ListNode prev = emptyHead;
//            ListNode cur = emptyHead.next;
//            while(cur!=null) {
//                ListNode start1 =cur;
//                for (int j = 1; j < i&&cur.next!=null; j++) {
//                    cur = cur.next;
//                }
//                ListNode start2 = cur.next;
//                cur.next = null;
//                cur = start2;
//                for (int j = 1; j < i && cur != null&&cur.next!=null; j++) {
//                    cur = cur.next;
//                }
//                if(cur!=null){
//                    ListNode temp=cur;
//                    cur=cur.next;
//                    temp.next=null;
//                }
//                prev.next = mergeList(start1, start2);
//                while(prev.next!=null){
//                    prev=prev.next;
//                }
//            }
//        }
//        return emptyHead.next;
//    }
//    public ListNode mergeList(ListNode head,ListNode tempHead){
//        ListNode emptyHead=new ListNode(0,head);
//        ListNode move=emptyHead;
//        while(head!=null&&tempHead!=null){
//            if(head.val<= tempHead.val){
//                move.next=head;
//                head=head.next;
//            }else{
//                move.next=tempHead;
//                tempHead=tempHead.next;
//            }
//            move=move.next;
//        }
//        move.next=head==null?tempHead:head;
//        return emptyHead.next;
//    }
}
