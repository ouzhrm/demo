package com.ouhzrm.算法.回溯_leetcode全部简单和中等题型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-12 22:00
 **/
public class 字母大小写全排列_需要回顾 {
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
        System.out.println(letterCasePermutation("1a2b"));
    }

    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> ans = new ArrayList();
        ans.add(new StringBuilder());

        for (char c: S.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    //debug发现复制一份item，并添加进去，然后各append大小写
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; ++i)
                    ans.get(i).append(c);
            }
        }

        List<String> finalans = new ArrayList();
        for (StringBuilder sb: ans)
            finalans.add(sb.toString());
        return finalans;
    }
}
