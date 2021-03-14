package com.ouhzrm.算法.树;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-03-04 23:00
 **/
public class 根据前序和后序遍历构造二叉树_需要回顾 {
    /*
            返回与给定的前序和后序遍历匹配的任何二叉树。

         pre 和 post 遍历中的值是不同的正整数。

         

        示例：

        输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
        输出：[1,2,3,4,5,6,7]
         

        提示：

        1 <= pre.length == post.length <= 30
        pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
        每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){
//        int[] pre=  new int[]{2,1};
//        int[] post=  new int[]{1,2};
        int[] pre=  new int[]{1,2,4,5,3,6,7};
        int[] post=  new int[]{4,5,2,6,7,3,1};
        constructFromPrePost(pre,post);
    }



    public TreeNode reverse(int[] post, int[] pre, Map<Integer, Integer> preMap, int postStart, int postEnd, int preStart, int preEnd) {
        if (postStart > postEnd || preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        //坑一：注意条件(postEnd-1) >= postStart
        if((postEnd-1) >= postStart){
            int left_index = preMap.get(post[postEnd - 1]);
            //坑二：长度不能preEnd去算， 要用preStart去算
            int length = left_index - preStart -1;
            root.left = reverse(post, pre, preMap, postStart, postStart + length-1, preStart + 1, preStart + length);
            root.right = reverse(post, pre, preMap,postStart + length, postEnd - 1, preStart + length + 1, preEnd);
        }
        return root;
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Map<Integer, Integer> preMap = new HashMap<>();
        for (int i = 0; i < pre.length; i++) {
            preMap.put(pre[i], i);
        }
        Map<Integer, Integer> postMap = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            postMap.put(post[i], i);
        }
        return reverse(post, pre, preMap, 0, post.length - 1, 0, pre.length - 1);
    }




}
