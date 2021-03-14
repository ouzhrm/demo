package com.ouhzrm.算法.树;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-07 20:54
 **/
public class 路径总和 {

    /**
     给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。

     叶子节点 是指没有子节点的节点。

      

     示例 1：


     输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     输出：true
     示例 2：


     输入：root = [1,2,3], targetSum = 5
     输出：false
     示例 3：

     输入：root = [1,2], targetSum = 0
     输出：false
      

     提示：

     树中节点的数目在范围 [0, 5000] 内
     -1000 <= Node.val <= 1000
     -1000 <= targetSum <= 1000

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/path-sum
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    boolean result = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        back(root,targetSum);
        return result;
    }

    void back(TreeNode root, int targetSum){
        if(result || root == null) return;
        targetSum -= root.val;
        if(targetSum == 0 && root.left == null && root.right == null){
            result = true;
            return;
        }
        back(root.left,targetSum);
        back(root.right,targetSum);
        targetSum +=root.val;
    }

}
