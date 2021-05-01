package com.ouhzrm.牛客top200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://www.nowcoder.com/practice/e3769a5f49894d49b871c09cadd13a61?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey
 * @author(itcode): zhouyh3
 * @create: 2021-04-21 10:30
 **/
public class 设计LRU缓存结构 {


    static class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private int k;

    public int[] LRU(int[][] operators, int k) {
        // write code here
        this.k = k;
        head.next = tail;
        tail.prev = head;
        int len = (int) Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] ans = new int[len];
        int cnt = 0;
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            } else {
                ans[cnt++] = get(operators[i][1]);
            }
        }
        return ans;
    }

    public void set(int key, int value) {
        //2,是否存在，存在则覆盖，不存在则新增并挪到头节点，新增判断大小是否大于k,大于则移除屁股，
        if (get(key) > -1) {
            map.get(key).value = value;
        } else {
            if (map.size() == k) {
                int rk = tail.prev.key;
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                map.remove(rk);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            removeToHead(node);
        }
    }

    public int get(int key) {
        //2,从map取出节点，并挪到头节点
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;

            removeToHead(node);
            return node.value;
        }
        return -1;
    }

    //1. 挪到头节点
    public void removeToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }


}
