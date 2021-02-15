package com.ouhzrm.算法.回溯算法_全部简单和中等题型;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-15 12:59
 **/
public class 格雷代码 {

    /**
     格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。

     给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。

     格雷编码序列必须以 0 开头。

      

     示例 1:

     输入: 2
     输出: [0,1,3,2]
     解释:
     00 - 0
     01 - 1
     11 - 3
     10 - 2

     对于给定的 n，其格雷编码序列并不唯一。
     例如，[0,2,3,1] 也是一个有效的格雷编码序列。

     00 - 0
     10 - 2
     11 - 3
     01 - 1
     示例 2:

     输入: 0
     输出: [0]
     解释: 我们定义格雷编码序列必须以 0 开头。
          给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
          因此，当 n = 0 时，其格雷编码序列为 [0]。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/gray-code
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public List<Integer> grayCode(int n) {
        int[] zeroOne = new int[]{0,1};
        List<Integer> result = new ArrayList();
        backTrack( zeroOne, result, 0, n ,  0);
        return result;
    }

    void backTrack(int[] zeroOne,List<Integer> result, Integer path,int n , int index){
        if(n == 0){
            result.add(path);
            return;
        }
        if(index == n){
            result.add(path);
            return;
        }

        for(int i = 0;i < zeroOne.length;i++){
            index++;
            int needAdd = 0;
            if(zeroOne[i] == 1){
                int time = 0;
                int addItem = 1;
                int circule = n-index;
                if(circule == 0){
                    needAdd+=1;
                }else{
                    while(time < circule){
                        addItem *=2;
                        time++;
                    }
                    needAdd += addItem;
                }
            }
            path += needAdd;
            backTrack( zeroOne, result,  path, n ,  index);
            path -= needAdd;
            index--;
        }
    }
}
