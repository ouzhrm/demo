package com.ouhzrm.高频;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode-cn.com/problems/lru-cache/
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 *
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *  
 *
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *  
 *
 * 提示：
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * 最多调用 3 * 104 次 get 和 put
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author(itcode): zhouyh3
 * @create: 2021-03-21 13:15
 **/
public class LRUCache {

    //关键设计：双端链表+哈希表（value=链表元素值）
    class DListNode{
        int key;
        int val;
        DListNode pre;
        DListNode next;

        public DListNode(){}
        public DListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    Map<Integer,DListNode> keyNode;
    DListNode head;
    DListNode tail;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        keyNode = new HashMap<>();
        head = new DListNode();
        tail = new DListNode();
        head.next=tail;
        tail.pre=head;
        this.capacity = capacity;
    }

    /**
     * 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1
     */
    public int get(int key) {
        //如果key存在，移动到头节点
        DListNode node = keyNode.get(key);
        if(node == null){
            return -1;
        }
        node = moveToHead(node);
        return node.val;
    }

    private DListNode moveToHead(DListNode node) {
        //1、删除节点
        node = deleteNode(node);

        //2.添加节点
        addHead(node);
        return node;
    }

    /**
     * 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     */
    public void put(int key, int value) {
        DListNode node = keyNode.get(key);
        if(node != null){
            node.val = value;
            keyNode.put(key,node);
            moveToHead(node);
        }else{
            node = new DListNode(key,value);
            keyNode.put(key,node);
            size++;
            if(size > capacity){
                DListNode dListNode = deleteNode(tail.pre);
                //坑一：记得移除
                keyNode.remove(dListNode.key);
                size--;
            }
            //坑二：记得添加
            addHead(node);
        }
    }

    private DListNode deleteNode(DListNode node) {
        DListNode pre = node.pre;
        DListNode next = node.next;
        node.pre = null;
        node.next = null;
        pre.next = next;
        next.pre = pre;
        return node;
    }

    private void addHead(DListNode node) {
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }

}
