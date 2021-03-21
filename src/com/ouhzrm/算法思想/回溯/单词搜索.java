package com.ouhzrm.算法思想.回溯;

import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-05 13:51
 **/
public class 单词搜索 {
    /**
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格
     * 是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * <p>
     * 示例:
     * <p>
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * <p>
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     *  
     * <p>
     * 提示：
     * <p>
     * board 和 word 中只包含大写和小写英文字母。
     * 1 <= board.length <= 200
     * 1 <= board[i].length <= 200
     * 1 <= word.length <= 10^3
     */
    @Test
    public void test() {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backTrack(board, visited,word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }


    Boolean backTrack(char[][] board,boolean[][] visited, String word, int index, int i, int j) {
        //终止条件
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (!visited[i][j]&&board[i][j] == word.charAt(index)) {
            index++;
            //记录当前位置已走过
            visited[i][j] = true;
            //做出选择
//            path.append(board[i][j]);
            //回溯
            Boolean result = backTrack(board,visited, word, index, i - 1, j) || backTrack(board,visited, word, index, i + 1, j) ||
                    backTrack(board, visited,word, index, i, j - 1) || backTrack(board,visited, word, index, i, j + 1);
            //撤回选择
//            path.deleteCharAt(path.length() - 1);
            //index--;
            visited[i][j] = false;
            return result;
        }
        return false;
    }


}
