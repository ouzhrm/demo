package com.ouhzrm.算法.其他_可不看;

import java.util.PriorityQueue;

/**
 * @description: 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那
 * 么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那
 * 么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据
 * 流，使用GetMedian()方法获取当前读取数据的中位数。
 * @author(itcode): zhouyh3
 * @create: 2020-11-14 19:55
 **/
public class GetMedianDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        maxHeap.offer(5);
        maxHeap.offer(9);
        maxHeap.offer(2);
        maxHeap.offer(7);
        maxHeap.offer(10);
        while(!maxHeap.isEmpty()){
            Integer poll = maxHeap.poll();
            System.out.println(poll);

        }
    }


    private int count = 0;
    // 左半元素
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, (o1, o2) -> o2 - o1);
    // 右半元素
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void Insert(Integer num) {
        count++;
        // 如果是偶数，插入到最小堆（右）.
        // 必须先插入最大堆，然后把最大堆的根元素插入最小堆

        if (count % 2 == 0) {
            maxHeap.offer(num);
            int temp = maxHeap.poll();
            minHeap.offer(temp);
        }else{
            //如果是奇数，先放入最小堆，再把最小堆的根元素放入最大堆
            minHeap.offer(num);
            int temp=minHeap.poll();
            maxHeap.offer(temp);
        }
    }

    /*
     * 如果数据总数目是偶数 . 返回最小堆根元素与最大堆根元素的均值 否则返回最大堆的根元素
     */
    public Double GetMedian() {
        if (count % 2 == 0) {
            return new Double(maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return new Double(maxHeap.peek());
        }
    }

}
