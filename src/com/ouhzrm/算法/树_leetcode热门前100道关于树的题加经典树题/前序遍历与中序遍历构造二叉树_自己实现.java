package com.ouhzrm.算法.树_leetcode热门前100道关于树的题加经典树题;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-17 15:02
 **/
public class 前序遍历与中序遍历构造二叉树_自己实现 {

    /**
     根据一棵树的前序遍历与中序遍历构造二叉树。

     注意:
     你可以假设树中没有重复的元素。

     例如，给出

     前序遍历 preorder = [3,9,20,15,7]
     中序遍历 inorder = [9,3,15,20,7]
     返回如下的二叉树：

     3
     / \
     9  20
     /  \
     15   7

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public TreeNode reverse(int[] preorder,int[] inorder,Map<Integer,Integer> inorderMap,int preStart,int preEnd,int inStart,int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        int index = inorderMap.get(preorder[preStart]);
        int total = index-inStart;
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = reverse(preorder,inorder,inorderMap,preStart+1,preStart+total,inStart,index-1);
        root.right = reverse(preorder,inorder,inorderMap,preStart+total+1,preEnd,index+1,inEnd);
        return root;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderMap = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        return reverse(preorder,inorder,inorderMap,0,preorder.length-1,0,inorder.length-1);
    }
}
