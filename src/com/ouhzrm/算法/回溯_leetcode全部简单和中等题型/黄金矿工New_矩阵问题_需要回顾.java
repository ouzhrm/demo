package com.ouhzrm.算法.回溯_leetcode全部简单和中等题型;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-12 19:01
 **/
public class 黄金矿工New_矩阵问题_需要回顾 {
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int max = 0; //保留最大的数字

    public int getMaximumGold(int[][] grid) {

        int now = 0;//记录当前的黄金总值

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0)   // 尝试所有非0的位置作为起点
                {
                    backtracking(grid, now, i, j);
                }
            }
        }

        return max;
    }

    void backtracking(int[][] grid, int now, int i, int j) {
        if (grid[i][j] == 0) { //返回条件：节点已经被回溯到或者是本身值就为0
            if (now > max) {
                max = now;
            }
            return;
        }
        int temp = grid[i][j]; //帮助记录当前的黄金的值
        now += grid[i][j]; //标准回溯中的步骤，将当前的节点标记为访问过
        grid[i][j] = 0;

        for (int q = 0; q < dir.length; q++) // 对其所有符合要求的邻居节点进行回溯
        {

            int tx = i + dir[q][0];
            int ty = j + dir[q][1];

            if (tx < 0 || ty < 0 || tx >= grid.length || ty >= grid[0].length) continue;
            backtracking(grid, now, tx, ty);

        }

        grid[i][j] = temp; //标准回溯中的步骤，将当前的节点标记为未被访问过
        now -= grid[i][j];

    }
}
