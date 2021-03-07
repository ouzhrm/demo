package com.ouhzrm.算法.树_leetcode热门前100道题;

import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-07 11:46
 **/
public class 完全二叉树的节点个数 {
    /**
     给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

     完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。

      

     示例 1：


     输入：root = [1,2,3,4,5,6]
     输出：6
     示例 2：

     输入：root = []
     输出：0
     示例 3：

     输入：root = [1]
     输出：1
      

     提示：

     树中节点的数目范围是[0, 5 * 104]
     0 <= Node.val <= 5 * 104
     题目数据保证输入的树是 完全二叉树

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test2(){
        TreeNode tree = TreeNode.getTreeByRecur(new Integer[]{1, 2, 3, 4, 5,6}, 1);
         System.out.println(countNodes(tree));
    }

    /**
     * left == right
     * 这说明左子树一定是完全二叉树，因为最后一层的节点已经填充到右子树了，所以左子树的节点个数就是 2left - 1，
     * 再加上当前的 root 节点，则是 2left 个节点，再对右子树递归统计
     * left != right
     * 说明此时倒数第二层满了，但最后一层不满，而且左子树没有完全填充，右子树是一颗满二叉树，因此同上，
     * 右子树的节点个数为 2right，再对左子树进行递归统计
     */
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = calcDepth(root.left);
        int rightDepth = calcDepth(root.right);
        if(leftDepth == rightDepth){
            return countNodes(root.right) + (1 << leftDepth);
        } else{
            return countNodes(root.left) + (1 << rightDepth);
        }
    }

    private int calcDepth(TreeNode root) {
        int depth = 0;
        while(root != null){
            depth++;
            root = root.left;
        }
        return depth;

    }
}
