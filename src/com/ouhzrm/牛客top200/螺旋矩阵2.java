package com.ouhzrm.牛客top200;

import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-04-22 12:48
 **/
public class 螺旋矩阵2 {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int l = 0;
        int r = n-1;
        int t = 0;
        int b = n-1;
        int num  = 1;
        while(num <= n * n){
            for(int i =l;i <= r ;i++) result[t][i] = num++; // left to right.
            t++;
            for(int i =t;i <= b ;i++) result[i][r] = num++; // top to bottom.
            r--;
            for(int i =r;i >= l ;i--) result[b][i] = num++; // right to left.
            b--;
            for(int i =b;i >= t ;i--) result[i][l] = num++; // bottom to top.
            l++;
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(generateMatrix(3));
    }

}
