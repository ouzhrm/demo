package com.ouhzrm.算法.回溯算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-09 10:21
 **/
public class 复原IP地址 {
    /**
     给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

     有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

     例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。

      

     示例 1：

     输入：s = "25525511135"
     输出：["255.255.11.135","255.255.111.35"]
     示例 2：

     输入：s = "0000"
     输出：["0.0.0.0"]
     示例 3：

     输入：s = "1111"
     输出：["1.1.1.1"]
     示例 4：

     输入：s = "010010"
     输出：["0.10.0.10","0.100.1.0"]
     示例 5：

     输入：s = "101023"
     输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
      

     提示：

     0 <= s.length <= 3000
     s 仅由数字组成

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/restore-ip-addresses
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test(){
        System.out.println(restoreIpAddresses("010010"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backTrack( s,s.length(),result,  path,0,0);
        return result;
    }

    void backTrack(String s,int strlength,List<String> result, StringBuilder path,int index,int length){
        if(index == 4 && length == strlength){
            path.deleteCharAt(path.length()-1);
            result.add(path.toString());
            path.append(".");
            return;
        }
        if(index >= 4){
            return;
        }

        for(int i = 0;i <= s.length();i++){
            if(i == 0 || i > s.length() || i > 3) continue;
            String substring = s.substring(0, i);
            if(substring.length() > 1 && substring.charAt(0) == '0') continue;
            int item = Integer.parseInt(substring);
            if(item >= 0 && item <=255){
                path.append(item).append(".");
                ++index;
                length +=substring.length();
                backTrack(s.substring(i),strlength, result,  path,index,length);
                int start = path.length()-substring.length()-1;
                start  = start < 0?0:start;
                path.delete(start,path.length());
                --index;
                length -=substring.length();
            }
        }
    }
}
