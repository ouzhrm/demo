package com.ouhzrm.算法.回溯;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-08 10:00
 **/
public class 重复字符串的排列组合 {

    /**
     * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
     * <p>
     * 示例1:
     * <p>
     * 输入：S = "qqe"
     * 输出：["eqq","qeq","qqe"]
     * 示例2:
     * <p>
     * 输入：S = "ab"
     * 输出：["ab", "ba"]
     * 提示:
     * <p>
     * 字符都是英文字母。
     * 字符串长度在[1, 9]之间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutation-ii-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test() {
        String[] qqes = permutation("LDirNn");
        for (String s : qqes) {
            System.out.println(s);
        }

    }

    public String[] permutation(String S) {
        StringBuilder path = new StringBuilder();
        char[] chars = S.toCharArray();
        Set<String> tmp = new HashSet<>();
        boolean[] position = new boolean[S.length()];
        backTrack(tmp, path, chars, position);
        String[] result= new String[tmp.size()];
        Iterator<String> iterator = tmp.iterator();
        int i = 0;
        while(iterator.hasNext()){
            String next = iterator.next();
            result[i] = next;
            i++;
        }
        return result;
    }

    void backTrack(Set<String> tmp, StringBuilder path, char[] chars, boolean[] position) {
        //终止条件
        if (path.length() == chars.length && !tmp.contains(path.toString())) {
            tmp.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if(!position[i]){
                //做出选择
                path.append(chars[i]);
                position[i] = true;
                //递归
                backTrack(tmp, path, chars, position);
                //撤销选择
                path.deleteCharAt(path.length() - 1);
                position[i] = false;
            }
        }
    }

}
