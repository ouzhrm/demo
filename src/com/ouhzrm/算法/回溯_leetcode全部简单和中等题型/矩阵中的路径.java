package com.ouhzrm.算法.回溯_leetcode全部简单和中等题型;

import java.util.LinkedList;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-01-31 14:36
 **/
public class 矩阵中的路径 {

    class zhubiao{
        int row; // rows
        int col; // col
        zhubiao(int col, int row){
            this.col = col;
            this.row = row;
        }

    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] kawei = new char[rows][cols];
        int curRow = 0,curCol = 0;
        for (int i = 0; i < matrix.length; i++) {
            curCol = i;
            if (curCol >= cols) {
                //TODO cols == 0
                curRow = curCol / cols;
                curCol = cols - curRow * cols;
            }
            LinkedList<zhubiao> selectedTable =  new LinkedList<>();
            if (matrix[i] == str[0]) {
                kawei[curRow][curCol] = str[0];
//                int tempRows = curRows;
//                int tempCols = curCols;
//                int index = 0;
//                while (tempRows > 0 && tempCols > 0 && tempCols < cols && tempRows < rows) {
//                      if(kawei[tempRows][tempCols] == str[index]){
//                          index++;
//                      }else{
//
//                      }
//                }
                int tmpRow = curRow+1;
                int tmpCol = curCol;
                if(tmpRow > 0 && tmpRow < rows){
                    selectedTable.add(new zhubiao(tmpRow,tmpCol));
                }
                tmpRow = curRow-1;
                if(tmpRow > 0 && tmpRow < rows){
                    selectedTable.add(new zhubiao(tmpRow,tmpCol));
                }

                tmpRow = curRow;
                tmpCol  = curCol + 1;
                if(tmpCol > 0 && tmpCol < cols){
                    selectedTable.add(new zhubiao(tmpRow,tmpCol));
                }
                tmpCol  = curCol - 1;
                if(tmpCol > 0 && tmpCol < cols){
                    selectedTable.add(new zhubiao(tmpRow,tmpCol));
                }
                int index = 1;
                while(selectedTable.size() > 0){
                    zhubiao poll = selectedTable.poll();
                    if (matrix[i] == str[index]) {

                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
