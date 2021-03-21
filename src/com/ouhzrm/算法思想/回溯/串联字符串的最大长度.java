package com.ouhzrm.算法思想.回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-07 11:32
 **/
public class 串联字符串的最大长度 {

    /**
     * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，
     * 如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
     * <p>
     * 请返回所有可行解 s 中最长长度。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = ["un","iq","ue"]
     * 输出：4
     * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
     * 示例 2：
     * <p>
     * 输入：arr = ["cha","r","act","ers"]
     * 输出：6
     * 解释：可能的解答有 "chaers" 和 "acters"。
     * 示例 3：
     * <p>
     * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
     * 输出：26
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= arr.length <= 16
     * 1 <= arr[i].length <= 26
     * arr[i] 中只含有小写英文字母
     */

    @Test
    public void test(){
        //["cha","r","act","ers"]
        List<String> arr = new ArrayList<>();
        arr.add("yy");
        arr.add("bkhwmpbiisbldzknpm");
        System.out.println(maxLength(arr));
    }

    public int maxLength(List<String> arr) {
        List<String> path = new ArrayList<>();
        int[] pathChars = new int[26];
        List<List<String>> result = new ArrayList<>();
        backTrack(arr,pathChars, path, result,arr.size(), -1);
        int maxLength = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< result.size();i++){
            List<String> strings = result.get(i);
            for(String str: strings){
                sb.append(str);
            }
            if(maxLength < sb.length()){
                maxLength = sb.length();
            }
            sb = new StringBuilder();
        }
        return maxLength;
    }

    void backTrack(List<String> arr, int[] pathChars, List<String> path, List<List<String>> result,int arrSize, int index) {
        if (path.size() > 0) {
            result.add(new ArrayList<>(path));
        }
        //终止条件
        if((arrSize-1) == index){
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            if (i > index && haveNoCommonChar(pathChars,arr.get(i))) {
                //做出选择
                path.add(arr.get(i));
                char[] chars = arr.get(i).toCharArray();
                for(int j = 0; j< chars.length;j++){
                    pathChars[chars[j]-'a'] +=1;
                }
                //回溯
                backTrack(arr,pathChars, path, result, arrSize, i);
                for(int j = 0; j< chars.length;j++){
                    pathChars[chars[j]-'a'] -=1;
                }
                //撤销选择
                path.remove(path.size() - 1);
            }
        }


    }

    private boolean haveNoCommonChar(int[] pathChars, String checkItem) {
        int[] checkItemArray = new int[26];
        char[] chars = checkItem.toCharArray();
        for(int j = 0; j< chars.length;j++){
            if(pathChars[chars[j]-'a'] >=1){
                return false;
            }
            if(checkItemArray[chars[j]-'a'] >=1){
                return false;
            }
            checkItemArray[chars[j]-'a'] +=1;
        }
        return true;
    }
}


