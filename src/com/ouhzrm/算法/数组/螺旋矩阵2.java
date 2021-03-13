package com.ouhzrm.算法.数组;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-13 17:31
 **/
public class 螺旋矩阵2 {

    /**
     * https://leetcode-cn.com/problems/spiral-matrix-ii/
     */

    //模拟过程
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }
}
