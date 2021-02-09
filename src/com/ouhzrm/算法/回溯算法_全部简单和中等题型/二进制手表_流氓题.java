package com.ouhzrm.算法.回溯算法_全部简单和中等题型;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-09 14:38
 **/
public class 二进制手表_流氓题 {
    /**
     二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。

     每个 LED 代表一个 0 或 1，最低位在右侧。

     例如，上面的二进制手表读取 “3:25”。

     给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。

     示例：

     输入: n = 1
     返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
      

     提示：

     输出的顺序没有要求。
     小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
     分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
     超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/binary-watch
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                int cnt = Integer.bitCount(i) + Integer.bitCount(j);
                if (cnt == num) {
                    // res.add(String.format("%d:%02d", i, j));
                    StringBuilder sb = new StringBuilder();
                    sb.append(i).append(':');
                    if (j < 10) {
                        sb.append('0');
                    }
                    sb.append(j);
                    res.add(sb.toString());
                }
            }
        }

        return res;
    }


}
