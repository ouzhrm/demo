package com.ouhzrm.算法.回溯_leetcode全部简单和中等题型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-13 20:46
 **/
public class 顺次位 {

    /*
    我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。

    请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。

     

    示例 1：

    输出：low = 100, high = 300
    输出：[123,234]
    示例 2：

    输出：low = 1000, high = 13000
    输出：[1234,2345,3456,4567,5678,6789,12345]
     

    提示：

    10 <= low <= high <= 10^9

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/sequential-digits
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test() {
        System.out.println(sequentialDigits(10,1000000000));
//        System.out.println(sequentialDigits(100,300));
    }

    public List<Integer> sequentialDigits(int low, int high) {
        StringBuilder path = new StringBuilder();
        List<Integer> result = new ArrayList<>();
        int temp = low;
        int times = 0;
        int start = 0;
        while(temp >= 10){
            temp = temp/10;
            if(temp < 10){
                start = temp;
            }
            times++;
        }
        backTrack( low,  high,  path,  result,  start, times, 0);
        return result;
    }

    void backTrack(int low, int high, StringBuilder path, List<Integer> result, int start, int startCount,int index) {
        int item = path.length() > 0 ? Integer.parseInt(path.toString()) : 0;
        while(item <= high && index <= startCount){
            if(start+index > 9){
                index = 0;
                start = 1;
                ++startCount;
                path.delete(0,path.length());
                continue;
            }
            path.append((start + index));
            item = Integer.parseInt(path.toString());
            ++index;
            if(index == startCount+1){
                if (item >= low && item <= high) {
                    result.add(item);
                }
                index = 0;
                start++;
                path.delete(0,path.length());
            }
            if(123456789 == item){
                break;
            }
        }
    }
}
