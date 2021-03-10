package com.ouhzrm.算法.树_leetcode热门前100道题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-10 09:02
 **/
public class 二叉树的全部路径 {
    /**
     给定一个二叉树，返回所有从根节点到叶子节点的路径。

     说明: 叶子节点是指没有子节点的节点。

     示例:

     输入:

     1
     /   \
     2     3
     \
     5

     输出: ["1->2->5", "1->3"]

     解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/binary-tree-paths
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test1(){
        TreeNode treeByRecur = TreeNode.getTreeByRecur(new Integer[]{1,2,3,4,5,6,7}, 1);
        System.out.println(binaryTreePaths(treeByRecur));
    }

    List<String> result= new ArrayList<>();
    List<String> item = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        back(root);
        return result;
    }

    void back (TreeNode root){
        if(root == null){
            return;
        }
        item.add(String.valueOf(root.val));
        if(root.left == null && root.right == null){
            String join = String.join("->", item);
            result.add(join);
        }
        back(root.left);
        back(root.right);
        item.remove(item.size()-1);
    }

}
