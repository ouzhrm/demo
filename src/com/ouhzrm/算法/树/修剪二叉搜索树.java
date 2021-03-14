package com.ouhzrm.算法.树;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-07 18:15
 **/
public class 修剪二叉搜索树 {
    /**
     给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树不应该改变保留在树中的元素的相对结构（即，如果没有被移除，原有的父代子代关系都应当保留）。 可以证明，存在唯一的答案。

     所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。

      

     示例 1：


     输入：root = [1,0,2], low = 1, high = 2
     输出：[1,null,2]
     示例 2：


     输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
     输出：[3,2,null,1]
     示例 3：

     输入：root = [1], low = 1, high = 2
     输出：[1]
     示例 4：

     输入：root = [1,null,2], low = 1, high = 3
     输出：[1,null,2]
     示例 5：

     输入：root = [1,null,2], low = 2, high = 4
     输出：[2]
      

     提示：

     树中节点数在范围 [1, 104] 内
     0 <= Node.val <= 104
     树中每个节点的值都是唯一的
     题目数据保证输入是一棵有效的二叉搜索树
     0 <= low <= high <= 104

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/trim-a-binary-search-tree
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 所以对于一棵树，只需要将根节点root的值与L和R进行比较，有以下三种情况：
     *
     * root.Val > R,此时最后需要返回的根节点一定在左子树
     * root.Val < L，此时最后需要返回的根节点一定在右子树
     * L <= root.Val <= R，此时根节点就是最后需要返回的根节点，那么需要对左右两子树分别进行‘删除’
     *
     * 作者：yexiso
     * 链接：https://leetcode-cn.com/problems/trim-a-binary-search-tree/solution/ji-jian-dan-di-gui-dai-ma-cjavago-by-avphn4vwuo/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if(root.val < low){
            //坑一： 要有return
            return trimBST(root.right,low,high);
        }
        if(root.val > high){
            return trimBST(root.left,low,high);
        }
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }

}
