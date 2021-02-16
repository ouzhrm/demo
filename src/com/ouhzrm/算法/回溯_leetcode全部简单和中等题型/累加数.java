package com.ouhzrm.算法.回溯_leetcode全部简单和中等题型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-12 14:15
 **/
public class 累加数 {

    /**
     累加数是一个字符串，组成它的数字可以形成累加序列。

     一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。

     给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。

     说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。

     示例 1:

     输入: "112358"
     输出: true
     解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
     示例 2:

     输入: "199100199"
     输出: true
     解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
     进阶:
     你如何处理一个溢出的过大的整数输入?

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/additive-number
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){
        System.out.println(isAdditiveNumber("121474836472147483648"));
    }


    //max  必须要用Long
    String max = Long.MAX_VALUE +"";
    boolean result =false;
    public boolean isAdditiveNumber(String num) {
        if(num.length() < 3){
            return false;
        }
        List<Long> path = new ArrayList<>();
        int length = 0;
        backTrack(num,num.length(), path, length);
        return result;
    }

    void backTrack(String num, int totalLength,List<Long> path,int length){
        if(path.size() >= 3 && length == totalLength){
            int sum = 0;
            for(int i = 0; i< path.size()-2;i++){
                if((path.get(i)+path.get(i+1)) == path.get(i+2)){
                    ++sum;
                }else{
                    break;
                }
            }
            if(sum == (path.size() -2)){
                result = true;
                return;
            }
        }
        if(result) return;

        for(int i = 0; i <= num.length();i++){
            String substring = num.substring(0, i);
            if(!"".equals(substring) && substring.length() < max.length()){
                if(substring.length() > 1 && substring.charAt(0) == '0') continue;
                path.add(Long.parseLong(substring));
                length += substring.length();
                backTrack( num.substring(i), totalLength,path,length);
                length -= substring.length();
                path.remove(path.size()-1);
            }

        }
    }





}
