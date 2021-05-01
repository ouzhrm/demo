//package com.ouhzrm.高频;
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * @description: https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
// * @author(itcode): zhouyh3
// * @create: 2021-04-01 21:26
// **/
//public class 数组中的逆序对 {
//
//    @Test
//    public void test(){
//        System.out.println(reversePairs(new int[]{7,5,6,4}));
//    }
//
//    int result = 0;
//    public int reversePairs(int[] nums) {
//        backTrack(nums,new LinkedList<>(),new int[nums.length],-1);
//        return result;
//    }
//
//    void backTrack(int[] nums, LinkedList<Integer> paths,int[] used,int index){
//        if(paths.size() > 0 && paths.getLast()  < paths.getFirst()){
//            System.out.println(paths.getLast()+" - "+paths.getFirst());
//        }
//        if(paths.size() == nums.length){
//            return;
//        }
//        for(int i = 0; i< nums.length;i++){
//            if(used[i] == 0 && i > index){
//                used[i]++;
//                paths.add(nums[i]);
//                backTrack(nums,paths,used,i);
//                paths.removeLast();
//                used[i]--;
//            }
//        }
//    }
//
//}
