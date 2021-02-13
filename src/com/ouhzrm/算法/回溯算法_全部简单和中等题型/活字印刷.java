package com.ouhzrm.算法.回溯算法_全部简单和中等题型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-13 16:47
 **/
public class 活字印刷 {

    /**
     你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
     注意：本题中，每个活字字模只能使用一次。

     示例 1：

     输入："AAB"
     输出：8
     解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
     示例 2：

     输入："AAABBC"
     输出：188
      

     提示：

     1 <= tiles.length <= 7
     tiles 由大写英文字母组成

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/letter-tile-possibilities
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){
        System.out.println(numTilePossibilities("AAB"));
        //[A, AA, AAB, AB, ABA, A, AA, AAB, AB, ABA, B, BA, BAA, BA, BAA]
        //"A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"
    }

    public int numTilePossibilities(String tiles) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        boolean[] zanwei = new boolean[tiles.length()];
        backTrack(tiles.toCharArray(), result, path, zanwei);
        System.out.println(result);
        return result.size();
    }

    Set<String> pass = new HashSet<>();
    void backTrack(char[] titles, List<String> result, StringBuilder path, boolean[] zanwei) {
        if (path.length() > titles.length) {
            return;
        }
        if (path.length() > 0 && !pass.contains(path.toString())) {
            result.add(path.toString());
            pass.add(path.toString());
        }

        for (int i = 0; i < titles.length; i++) {
            if (!zanwei[i]) {
                path.append(titles[i]);
                zanwei[i] = true;
                backTrack(titles, result, path, zanwei);
                zanwei[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
