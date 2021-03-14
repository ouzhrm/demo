//package com.ouhzrm.算法.回溯算法_全部简单和中等题型;
//
//import java.util.LinkedList;
//
///**
// * @description:
// * @author(itcode): zhouyh3
// * @create: 2021-02-12 19:01
// **/
//public class 黄金矿工 {
//    /**
//     你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，
//     并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数
//     就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
//
//     为了使收益最大化，矿工需要按以下规则来开采黄金：
//
//     每当矿工进入一个单元，就会收集该单元格中的所有黄金。
//     矿工每次可以从当前位置向上下左右四个方向走。
//     每个单元格只能被开采（进入）一次。
//     不得开采（进入）黄金数目为0的单元格。
//     矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
//      
//
//     示例 1：
//
//     输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
//     输出：24
//     解释：
//     [[0,6,0],
//     [5,8,7],
//     [0,9,0]]
//     一种收集最多黄金的路线是：9 -> 8 -> 7。
//     示例 2：
//
//     输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
//     输出：28
//     解释：
//     [[1,0,7],
//     [2,0,6],
//     [3,4,5],
//     [0,3,0],
//     [9,0,20]]
//     一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
//      
//
//     提示：
//
//     1 <= grid.length, grid[i].length <= 15
//     0 <= grid[i][j] <= 100
//     最多 25 个单元格中有黄金。
//
//     来源：力扣（LeetCode）
//     链接：https://leetcode-cn.com/problems/path-with-maximum-gold
//     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//     */
//    public int getMaximumGold(int[][] grid) {
//        int result = 0;
//        boolean[][] kawei = new boolean[grid.length][grid[0].length];
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                LinkedList<ZuoBiao> path = new LinkedList<>();
//                path.add(new ZuoBiao(i, j));
//                int itemTotal = backTrack(grid, path, kawei,0);
//                path.remove(path.size() - 1);
//                if (result < itemTotal) {
//                    result = itemTotal;
//                }
//            }
//        }
//        return result;
//    }
//
//    class ZuoBiao {
//        int col;
//        int row;
//
//        ZuoBiao(int col, int row) {
//            this.col = col;
//            this.row = row;
//        }
//    }
//
////    boolean checkZuobiao(int i,int j,int[][] grid){
////        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
////            return false;
////        }else{
////            return true;
////        }
////    }
//
//    int backTrack(int[][] grid, LinkedList<ZuoBiao> path, boolean[][] kawei,int total) {
//        ZuoBiao zuobiao = path.poll();
//        if (zuobiao.col < 0 || zuobiao.row < 0 || zuobiao.col >= grid.length || zuobiao.row >= grid[0].length) {
//            return total;
//        }
//        if (grid[zuobiao.col][zuobiao.row] == 0) {
//            return total;
//        }
//        if (!kawei[zuobiao.col][zuobiao.row]) {
//            zuobiao = new ZuoBiao(zuobiao.col-1,zuobiao.row);
//            path.add(zuobiao);
//            zuobiao = new ZuoBiao(zuobiao.col+1,zuobiao.row);
//            path.add(zuobiao);
//            zuobiao = new ZuoBiao(zuobiao.col,zuobiao.row+1);
//            path.add(zuobiao);
//            zuobiao = new ZuoBiao(zuobiao.col,zuobiao.row-1);
//            path.add(zuobiao);
//            kawei[zuobiao.col][zuobiao.row] = true;
//            backTrack(grid, path, kawei);
//            backTrack(grid, path, kawei);
//            backTrack(grid, path, kawei);
//            backTrack(grid, path, kawei);
//            kawei[zuobiao.col][zuobiao.row] = false;
//        } else {
//
//        }
//
//        return 0;
//    }
//
//}
