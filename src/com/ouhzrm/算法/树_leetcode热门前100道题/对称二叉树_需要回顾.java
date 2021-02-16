package com.ouhzrm.算法.树_leetcode热门前100道题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-16 17:29
 **/
public class 对称二叉树_需要回顾 {

    /**
     给定一个二叉树，检查它是否是镜像对称的。

      

     例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

     1
     / \
     2   2
     / \ / \
     3  4 4  3
      

     但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

     1
     / \
     2   2
     \   \
     3    3
      

     进阶：

     你可以运用递归和迭代两种方法解决这个问题吗？

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/symmetric-tree
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test2(){
        String a = null;
        System.out.println(a.equals(null));
    }


    @Test
    public void test(){

        TreeNode root = new TreeNode();
        root.val = 1;

        TreeNode left = new TreeNode();
        left.val = 2;
        TreeNode left1 = new TreeNode();
        left1.val = 3;
        TreeNode left2 = new TreeNode();
        left2.val = 4;
        left.left = left1;
        left.right = left2;

        TreeNode right = new TreeNode();
        right.val = 2;
        TreeNode right1 = new TreeNode();
        right1.val = 4;
        TreeNode right2 = new TreeNode();
        right2.val = 3;
        right.left = right1;
        right.right = right2;

        root.left = left;
        root.right = right;
        System.out.println(isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        return is(root,root);
    }

    boolean is(TreeNode r1,TreeNode r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        if(r1.val == r2.val){
            return is(r1.left,r2.right) && is(r1.right, r2.left);
        }else{
            return false;
        }
    }











//    boolean result = true;
//    boolean tmp = false;
//    List<String> path = new ArrayList<>();
//    public boolean isSymmetric(TreeNode root) {
//        binaryTree(root,root);
//        return result;
//    }
//
//    int index = 0;
//    int middle = 0;
//    public void binaryTree(TreeNode root,TreeNode node){
//        if(node == null || !result){
//            return;
//        }
//        binaryTree(root,node.left);
//        if(tmp){
//            System.out.println("-------"+path);
//            index++;
//        }
//        //[2, 2, null, 1, 2, 2, null]
////        if(tmp && path.size() > 0 && (path.get(middle-index) == null || node.val != path.get(middle-index))) {
//        if(tmp && path.size() > 0 && String.valueOf(node.val).equals(path.get(middle-index))) {
//            System.out.println(path+", index = "+index+", middle="+middle);
//            System.out.println("path.get(middle-index) = "+path.get(middle-index));
//            System.out.println("node.val="+String.valueOf(node.val));
//            result = false;
//        }
//        if(node == root){
//            middle = path.size();
//            System.out.println("-------"+path);
//            tmp = true;
//        }
//        if(node.left == null && node.right != null){
//            path.add("N");
//        }
//        path.add(String.valueOf(node.val));
//        if(node.left != null && node.right == null){
//            path.add("N");
//        }
//        //System.out.println(path);
//        binaryTree(root,node.right);
//    }
}
