package com.ouhzrm.算法.回溯;

import java.util.LinkedList;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-01-31 14:36
 **/
public class 矩阵中的路径New {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        return false;
    }

    //定义回溯算法框架
    public void trackBack(char[] matrix, LinkedList<Character> path, char[] str){
        //判断结束递归条件
        for(int i = 0; i < matrix.length;i++){
            //做选择
            if(matrix[i] == str[0]){

            }
            trackBack(matrix,path,str);
            
            //撤销选择

        }

    }

    public static void main(String[] args) {

    }

}
