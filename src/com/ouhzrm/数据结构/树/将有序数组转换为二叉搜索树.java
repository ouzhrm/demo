package com.ouhzrm.数据结构.树;

import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-06 21:53
 **/
public class 将有序数组转换为二叉搜索树 {

    /**
     给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

     高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

      

     示例 1：


     输入：nums = [-10,-3,0,5,9]
     输出：[0,-3,9,-10,null,5]
     解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：

     示例 2：


     输入：nums = [1,3]
     输出：[3,1]
     解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
      

     提示：

     1 <= nums.length <= 104
     -104 <= nums[i] <= 104
     nums 按 严格递增 顺序排列

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */



    @Test
    public void test(){
        TreeNode treeNode = sortedArrayToBST(new int[]{1, 2, 3, 4, 5});
        TreeNode.middlePrintTree(treeNode);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        TreeNode root = new TreeNode();
        if(length == 1){
            root.val = nums[0];
            return root;
        }else if(length == 2){
            root.val = nums[0];
            root.left = new TreeNode(nums[1]);
            return root;
        }
        return buildbinarySearchTree(nums,0,nums.length-1);
    }

    //递归三要素
    //1、定义函数
    private TreeNode buildbinarySearchTree(int[] nums, int start, int end) {
        //2、结束条件
        if(start > end){
            return null;
        }
        int middle = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[middle]);
        //3、缩小范围，建立等价公式
        root.left = buildbinarySearchTree(nums,start,middle-1);
        root.right = buildbinarySearchTree(nums,middle+1,end);
        return root;
    }
}
