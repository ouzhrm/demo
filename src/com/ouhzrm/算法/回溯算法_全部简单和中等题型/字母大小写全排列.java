package com.ouhzrm.算法.回溯算法_全部简单和中等题型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-12 22:00
 **/
public class 字母大小写全排列 {
    /**
     给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

      

     示例：
     输入：S = "a1b2"
     输出：["a1b2", "a1B2", "A1b2", "A1B2"]

     输入：S = "3z4"
     输出：["3z4", "3Z4"]

     输入：S = "12345"
     输出：["12345"]
      

     提示：

     S 的长度不超过12。
     S 仅由数字和字母组成。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/letter-case-permutation
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){
        System.out.println(letterCasePermutation("a1b2"));
    }

    public List<String> letterCasePermutation(String S) {
        char[] chars = S.toCharArray();
        StringBuilder path = new StringBuilder();
        List<String> result = new ArrayList<>();
        backTrack( chars, path, result);
        return result;
    }

    void backTrack(char[] chars,StringBuilder path,List<String> result){
        if(path.length() == chars.length){
            result.add(path.toString());
            return;
        }

        for(int i = 0;i< chars.length;i++){
            if((chars[i] - 'a') >= 0){
                path.append(chars[i]);
                chars[i] = Character.toUpperCase(chars[i]);
                backTrack(chars,path, result);
                path.deleteCharAt(path.length()-1);
            }else{
                path.append(chars[i]);
            }
        }
    }
}
