package com.ouhzrm.数据结构.树;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-04 22:31
 **/
public class 从中序与后序遍历序列构造二叉树 {
    /**
     根据一棵树的中序遍历与后序遍历构造二叉树。

     注意:
     你可以假设树中没有重复的元素。

     例如，给出

     中序遍历 inorder = [9,3,15,20,7]
     后序遍历 postorder = [9,15,7,20,3]
     返回如下的二叉树：

     3
     / \
     9  20
     /  \
     15   7

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public TreeNode reverse(int[] postorder, int[] inorder, Map<Integer,Integer> inorderMap, int postStart, int postEnd, int inStart, int inEnd){
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }
        int index = inorderMap.get(postorder[postEnd]);
        int right_total = inEnd -index;
        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = reverse(postorder,inorder,inorderMap,postStart,postEnd-right_total-1,inStart,index-1);
        root.right = reverse(postorder,inorder,inorderMap,postEnd-right_total,postEnd-1,index+1,inEnd);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inorderMap = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        return reverse(postorder,inorder,inorderMap,0,postorder.length-1,0,inorder.length-1);

    }
}
