package com.ouhzrm.数据结构.字符串;

/**
 * @description: https://leetcode-cn.com/problems/reverse-string-ii/
 * @author(itcode): zhouyh3
 * @create: 2021-03-16 21:42
 **/
public class 反转字符串2 {

    /**
     * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
     *
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *  
     *
     * 示例:
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     *  
     *
     * 提示：
     *
     * 该字符串只包含小写英文字母。
     * 给定字符串的长度和 k 在 [1, 10000] 范围内。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-string-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String reverseStr(String s, int k) {
        //for循环做文章，关键代码like below
//        for (int i = 0; i < s.size(); i += (2 * k)) {
//            // 1. 每隔 2k 个字符的前 k 个字符进行反转
//            // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
//            if (i + k <= s.size()) {
//                reverse(s, i, i + k - 1);
//                continue;
//            }
//            // 3. 剩余字符少于 k 个，则将剩余字符全部反转。
//            reverse(s, i, s.size() - 1);
//        }
        return null;
    }
}
