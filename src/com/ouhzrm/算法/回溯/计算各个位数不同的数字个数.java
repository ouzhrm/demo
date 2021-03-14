package com.ouhzrm.算法.回溯;

import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-02 10:13
 **/
public class 计算各个位数不同的数字个数 {

    /**
     * 0       1
     * 1       9
     * 2     9 * 9
     * 3    9 * 9 * 8
     * 4   9 * 9 * 8 * 7
     * n   f(n-1)*(10-n+1)
     */
    public int countNumbersWithUniqueDigits(int n) {
        int result = 0;
        for(int i = 0;i <= n;i++){
            result +=digui(i);
        }
        return result;
    }

    int digui(int i){
        if(i == 0) {
            return 1;
        }
        if(i == 1){
            return 9;
        }
        return digui(i -1)*(10-i+1);
    }

    @Test
    public void test(){
        System.out.println(countNumbersWithUniqueDigits(0));
        System.out.println(countNumbersWithUniqueDigits(1));
        System.out.println(countNumbersWithUniqueDigits(2));
        System.out.println(countNumbersWithUniqueDigits(3));
        System.out.println(countNumbersWithUniqueDigits(4));
    }

}
