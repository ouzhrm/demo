package com.ouhzrm.算法.回溯算法_全部简单和中等题型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-14 14:58
 **/
public class 括号生成 {
    /**
     数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

      

     示例 1：

     输入：n = 3
     输出：["((()))","(()())","(())()","()(())","()()()"]
     示例 2：

     输入：n = 1
     输出：["()"]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/generate-parentheses
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     提示：

     1 <= n <= 8
     */

    @Test
    public void test(){
        System.out.println(generateParenthesis(1));
    }

    public List<String> generateParenthesis(int n) {
        String[] kuohao = new String[]{"(",")"};
        StringBuilder path = new StringBuilder();
        List<String> result = new ArrayList<>();
        backTrack( n, kuohao, path, result);
        return result;
    }


    int zheng = 0;
    int fan = 0;
    void backTrack(int n,String[] kuohao, StringBuilder path,List<String> result){
        if(zheng == 0 && path.length() == n*2 && "(".equals(String.valueOf(path.charAt(0))) && ")".equals(String.valueOf(path.charAt(path.length()-1)))){
            result.add(path.toString());
        }
        if(path.length() >= n*2){
            return;
        }

        for(int i = 0;i <kuohao.length;i++){
            if("(".equals(kuohao[i])){
                ++zheng;
            }else{
                --zheng;
            }
            if(zheng >= 0){
                path.append(kuohao[i]);
                backTrack( n, kuohao,  path, result);
                path.deleteCharAt(path.length()-1);
            }
            if("(".equals(kuohao[i])){
                --zheng;
            }else{
                ++zheng;
            }
        }
    }



}
