package com.ouhzrm.算法.回溯算法_全部简单和中等题型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-02 11:32
 **/
public class 分割回文串 {
    @Test
    public void test(){
        System.out.println(partition("level"));
    }


    /**
     * 输入: "aab", level(l,e,v,e,l,ele,level)
     * 输出:
     * [
     *   ["aa","b"],
     *   ["a","a","b"]
     * ]
     */

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backTrack(s,path,result);
        return result;
    }

    public boolean isHuiWen(String str){
        if (str == null || str.length() <= 0) {
            return false;
        }
        int middle = str.length() / 2;
        for(int i = 0;i < middle;i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public void backTrack(String selectedTable, List<String> path,List<List<String>> result){
        //终止条件
        if(selectedTable == null || selectedTable.length() == 0){
            //只有是回文，并且是最后一个字符串才会终止
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i <= selectedTable.length(); i++) {
            String substring = selectedTable.substring(0, i);
            if (isHuiWen(substring)){
                //做出选择
                path.add(substring);
                String lastStr = selectedTable.substring(i);
                //回溯
                backTrack(lastStr, path,result);
                //撤销选择
                path.remove(path.size()-1);
            }
        }
    }

}
