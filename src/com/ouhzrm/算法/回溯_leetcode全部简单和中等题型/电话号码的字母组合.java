package com.ouhzrm.算法.回溯_leetcode全部简单和中等题型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-08 11:57
 **/
public class 电话号码的字母组合 {

    /**
     给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

     示例 1：

     输入：digits = "23"
     输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     示例 2：

     输入：digits = ""
     输出：[]
     示例 3：

     输入：digits = "2"
     输出：["a","b","c"]
      

     提示：

     0 <= digits.length <= 4
     digits[i] 是范围 ['2', '9'] 的一个数字。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){
        System.out.println(letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return new ArrayList<>();
        }
        char[][] nums = new char[][]{
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
        };
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        char[] chars = digits.toCharArray();
        int[] digitArray = new int[chars.length];
        for(int i = 0;i < chars.length;i++){
            digitArray[i] =  Integer.parseInt(chars[i] + "") -2;
        }
        backTrack(nums,  result, path, digitArray,-1);
        return result;
    }

    void backTrack(char[][] nums, List<String> result, StringBuilder path,int[] digits,int index) {
        //终止条件(关键)
        if (path.toString().length() == digits.length) {
            result.add(path.toString());
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if(i > index){
                char[] item = nums[digits[i]];
                for (int j = 0; j < item.length; j++) {
                    //做出选择
                    path.append(item[j]);
                    //递归
                    backTrack(nums, result, path,digits,i);
                    //撤销选择
                    path.deleteCharAt(path.toString().length()-1);
                }
            }
        }
    }
}
