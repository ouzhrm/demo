链表分单向链表、双向链表、环型链表

//单链表结构
class ListNode {
    int val;  // 节点上存储的元素
    ListNode next;  // 指向下一个节点的指针
    ListNode(int val){
        this.val = val;
    }
};

链表的删除/新增时间复杂度O（1），查询的复杂度O（n）