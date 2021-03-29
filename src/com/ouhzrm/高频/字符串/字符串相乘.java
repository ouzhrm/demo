package com.ouhzrm.高频.字符串;

import org.junit.Test;

/**
 * @description: https://leetcode-cn.com/problems/multiply-strings/
 * @author(itcode): zhouyh3
 * @create: 2021-03-27 16:22
 **/
public class 字符串相乘 {

    @Test
    public void test(){
        System.out.println(multiply("456","789"));//359784
    }

    //找规律：https://pic.leetcode-cn.com/171cad48cd0c14f565f2a0e5aa5ccb130e4562906ee10a84289f12e4460fe164-image.png
    //个位数：res[i+j+1], 十位数：res[i+j], 但需要设置res[0] = 0;
    public String multiply(String num1, String num2) {
        String result = "0";
        //注意：不是num1.length()-1+num2.length()-1
        int[] res = new int[num1.length()+num2.length()];
        if("0".equals(num1) || "0".equals(num2)) return "0";
        char[] c2 = num2.toCharArray();
        char[] c1 = num1.toCharArray();
        for (int i = c1.length - 1; i >= 0; i--) {
            int n1 = c1[i] - '0';
            for (int j = c2.length - 1; j >= 0; j--) {
                int n2 = c2[j] - '0';
                int num = n1 * n2 + res[i+j+1];
                res[i+j+1] = num % 10;
                res[i+j] += num / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0 ;i < res.length;i++){
            if(i == 0 && res[0] == 0) continue;
            sb.append(res[i]);
        }
        return sb.toString();
    }


    //常规思路
    public String multiply2(String num1, String num2) {
        String result = "0";
        if("0".equals(num1) || "0".equals(num2)) return "0";
        char[] c2 = num2.toCharArray();
        char[] c1 = num1.toCharArray();
        int carry = 0;
        StringBuilder zero = new StringBuilder();
        for (int i = c1.length - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            sb.append(zero.toString());
            int n1 = c1[i] - '0';
            for (int j = c2.length - 1; j >= 0; j--) {
                int n2 = c2[j] - '0';
                int num = n1 * n2;
                int su = (num + carry) % 10;
                //坑二： carry = (num + carry)  / 10 ， 而不是 carry = num  / 10
                carry = (num + carry)  / 10;
                sb.append(su);
            }
            if(carry > 0){
                sb.append(carry);
                //坑一：注意进位置空
                carry = 0;
            }
            String single = sb.reverse().toString();
            if("0".equals(result)){
                result = single;
            }else{
                result = twoSum(result, single);
            }
            zero.append("0");
        }
        return result;
    }

    private String twoSum(String result, String single) {
        char[] c1 = result.toCharArray();
        char[] c2 = single.toCharArray();
        int carry = 0;
        int i = c1.length - 1;
        int j = c2.length - 1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0){
            int n1 = i < 0 ? 0: c1[i] - '0';
            int n2 = j < 0 ? 0: c2[j] - '0';
            int num = n1+n2;
            int su = (num + carry) % 10;
            carry = (num + carry) / 10;
            sb.append(su);
            i--;
            j--;
        }
        if(carry > 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
