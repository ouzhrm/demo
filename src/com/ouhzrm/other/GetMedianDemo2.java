package com.ouhzrm.other;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @description: 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那
 * 么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那
 * 么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据
 * 流，使用GetMedian()方法获取当前读取数据的中位数。
 * @author(itcode): zhouyh3
 * @create: 2020-11-14 19:55
 **/
public class GetMedianDemo2 {

    /**
     * 思路：
     * 定义两个队列，一个升序，一个降序，奇偶数insert交叉添加到队列里（保证两边数量平衡）,
     * 等排好序后，弹出第一个元素添加到另一个队列里，用到priorityQueue的offer, poll, peek特性
     */

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int count;

    /**
     * [5,2,3,4,1,6,7,0,8]
     */

    public void Insert(Integer num) {
        synchronized (GetMedianDemo2.class){
            count++;
            if(count % 2 == 0){
                maxHeap.offer(num);
                Integer maxPoll = maxHeap.poll();
                minHeap.offer(maxPoll);
            }else{
                minHeap.offer(num);
                Integer minPoll = minHeap.poll();
                maxHeap.offer(minPoll);
            }
        }
    }

    public Double GetMedian() {
        synchronized (GetMedianDemo2.class){
            if(count % 2 == 0){
                return Double.valueOf(maxHeap.peek()+minHeap.peek())/2;
            }else{
                return Double.valueOf(maxHeap.peek().toString());
            }
        }
    }

    @Test
    public void demo(){
        GetMedianDemo2 g = new GetMedianDemo2();
        g.Insert(5);
        System.out.println(g.GetMedian());
        g.Insert(2);
        System.out.println(g.GetMedian());
        g.Insert(3);
        System.out.println(g.GetMedian());
        g.Insert(4);
        System.out.println(g.GetMedian());
        g.Insert(1);
        System.out.println(g.GetMedian());
        g.Insert(6);
        System.out.println(g.GetMedian());
        g.Insert(7);
        System.out.println(g.GetMedian());
        g.Insert(0);
        System.out.println(g.GetMedian());
        g.Insert(8);
        System.out.println(g.GetMedian());
    }

}
