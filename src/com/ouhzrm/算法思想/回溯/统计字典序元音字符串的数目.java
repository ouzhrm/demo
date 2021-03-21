package com.ouhzrm.算法思想.回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-14 16:14
 **/
public class 统计字典序元音字符串的数目 {

    /**
     给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。

     字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。

      

     示例 1：

     输入：n = 1
     输出：5 5
     解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
     示例 2：                              5    4  3  2   1

     输入：n = 2
     输出：15 = 54321=15
     解释：仅由元音组成的 15 个字典序字符串为
     ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
       5    4    3    2    1     4   3    2    1     3   2    1     2    1   1
     注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
     示例 3：
     n=3

     输入：n = 33
     输出：66045
n=1               1                      1                1             1     1    = 5
                                                                                     10=4+3+2+1 = 10
n=2               5                     4                 3            2      1    = 5+4+3+2+1  = 15
                                                                                     20=10+6+3+1 = 10+10
n=3     5    4    3    2    1     4   3    2    1     3   2    1     2    1   1    = 5+4+3+2+1+ 4+3+2+1+ 3+2+1 +2+1 +1= 15+10+6+3+1=35
                                                                                     35=15+10+6+3+1 = 15+10+10
n=4    15   10    6    3    1    10    6    3    1    6   3    1    3     1   1    = 35+20+10+3+2 = 70

     (n-1)*5+10 +f(n-1) =

     提示：

     1 <= n <= 50 

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/count-sorted-vowel-strings
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){
        System.out.println(countVowelStrings(33));
    }


    public int countVowelStrings(int n) {
        char[] chars = new char[]{'a','e','i','o','u'};
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        backTrack(chars, n, result, path, -1);
        return result.size();
    }

    void backTrack(char[] chars, int n, List<String> result,StringBuilder path,int index){
        if(path.length() == n){
            result.add(path.toString());
            return;
        }

        for(int i = 0;i < chars.length;i++){
            if(i >= index){
                path.append(chars[i]);
                backTrack( chars,  n,  result, path, i);
                path.deleteCharAt(path.length()-1);
            }
        }

    }

}
