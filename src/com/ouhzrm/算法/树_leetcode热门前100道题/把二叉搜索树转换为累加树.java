package com.ouhzrm.算法.树_leetcode热门前100道题;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-27 10:50
 **/
public class 把二叉搜索树转换为累加树 {

    /**
     给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
     使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。

     提醒一下，二叉搜索树满足下列约束条件：

     节点的左子树仅包含键 小于 节点键的节点。
     节点的右子树仅包含键 大于 节点键的节点。
     左右子树也必须是二叉搜索树。
     注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同

      

     示例 1：



     输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
     输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
     示例 2：

     输入：root = [0,null,1]
     输出：[1,null,1]
     示例 3：

     输入：root = [1,0,2]
     输出：[3,3,2]
     示例 4：

     输入：root = [3,2,4,1]
     输出：[7,9,4,10]
      

     提示：

     树中的节点数介于 0 和 104 之间。
     每个节点的值介于 -104 和 104 之间。
     树中的所有值 互不相同 。
     给定的树为二叉搜索树。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     */

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        digui(root);
        return root;
    }

    /**
     * 我们只需要进行一次反向中序遍历（即遍历顺序为右子树-->根节点-->左子树），
     * 在遍历过程中需要将已经遍历的节点的值进行累加，然后再赋值给当前节点
     */
    void digui(TreeNode root){
        if(root == null) return;
        convertBST(root.right);
        sum+=root.val;
        root.val = sum;
        convertBST(root.left);
    }

}
