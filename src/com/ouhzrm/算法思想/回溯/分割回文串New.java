package com.ouhzrm.算法思想.回溯;

import org.junit.Test;

import java.util.ArrayList;
/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-02 16:35
 **/
public class 分割回文串New {

    @Test
    public void test(){
        System.out.println(partition("level"));
    }

    /**
     * @param s string字符串
     * @return string字符串ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();//存放结果
        ArrayList<String> list = new ArrayList<>();
        add(result, list, s);
        return result;
    }

    //判断回文
    public boolean ishuiwen(String s) {
        if (null == s || s.length() == 0) return false;
        int length = s.length();
        int middle = length / 2;
        for (int i = 0; i < middle; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    int j = 0;

    //回溯
    public void add(ArrayList<ArrayList<String>> result, ArrayList<String> list, String s) {
        //如果传入的字符串长度为0，满足集合，新建一个list，否则回溯时remove就把list内容全部删除了
        if (s.length() == 0 || null == s) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i <= s.length(); i++) {
            String substring = s.substring(0, i);//每次增加一位进行判断
            if (ishuiwen(substring)) { //如果是回文
                list.add(substring);//把满足条件的放入到list中
                String reststirng = s.substring(i);//reststring将剩下的保存进行回溯
                add(result, list, reststirng);
                //移除刚刚添加的元素，走其他分支
                list.remove(list.size() - 1);
            }
        }
    }

}
