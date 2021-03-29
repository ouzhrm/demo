package com.ouhzrm.高频.字符串;

import org.junit.Test;

/**
 * @description: https://leetcode-cn.com/problems/add-strings/
 * @author(itcode): zhouyh3
 * @create: 2021-03-23 18:08
 **/
public class 字符串相加 {

    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     * <p>
     *  
     * <p>
     * 提示：
     * <p>
     * num1 和num2 的长度都小于 5100
     * num1 和num2 都只包含数字 0-9
     * num1 和num2 都不包含任何前导零
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
     */

    @Test
    public void test() {
        System.out.println(addStrings("98", "9"));
    }

    //双指针解法：num1 和num2 的长度都小于 5100
    public String addStrings(String num1, String num2) {
        return num1.length() < num2.length() ? getTotal(num2.toCharArray(), num1.toCharArray()) : getTotal(num1.toCharArray(), num2.toCharArray());
    }

    String getTotal(char[] mainArr, char[] otherArr) {
        StringBuilder result = new StringBuilder();
        int mi = mainArr.length - 1;
        int oi = otherArr.length - 1;
        int addone = 0;
        while (mi >= 0) {
            int md = mainArr[mi] - '0';
            int od = oi < 0 ? 0 : otherArr[oi] - '0';
            int item = addone == 1 ? (md + od + 1) % 10 : (md + od) % 10;
            addone = addone == 1 ? (md + od + 1) / 10 : (md + od) / 10;
            result.append(item);
            mi--;
            oi--;
        }
        //坑一
        if (addone == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }


    //传统解法：无法满足值特别大的时候，num1 和num2 的长度都小于 5100
//    public String addStrings(String num1, String num2) {
//        char[] chars1 = num1.toCharArray();
//        char[] chars2 = num2.toCharArray();
//        int sum1 = 0;
//        int len = chars1.length-1;
//        for(int i = chars1.length-1;i >=0;i--){
//            //坑一： 有可能是负数
//            if('-' == chars1[i]){
//                sum1 =  -sum1;
//                continue;
//            }
//            int digit = chars1[i]-'0';
//            digit *=Math.pow(10, len-i);
//            sum1 +=digit;
//        }
//        int sum2 = 0;
//        len = chars2.length-1;
//        for(int i = chars2.length-1;i >=0;i--){
//            if('-' == chars2[i]){
//                sum2 =  -sum2;
//                continue;
//            }
//            int digit = chars2[i]-'0';
//            digit *=Math.pow(10, len-i);
//            sum2 +=digit;
//        }
//        int sum = sum1+sum2;
//        return String.valueOf(sum);
//    }
}
