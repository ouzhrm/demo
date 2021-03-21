package com.ouhzrm.算法思想.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-04 17:25
 **/
public class 迭代器类设计 {

    /**
     请你设计一个迭代器类，包括以下内容：

     一个构造函数，输入参数包括：一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLength 。
     函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。
     函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 True；否则，返回 False。
      

     示例：

     CombinationIterator iterator = new CombinationIterator("abc", 2); // 创建迭代器 iterator

     iterator.next(); // 返回 "ab"
     iterator.hasNext(); // 返回 true
     iterator.next(); // 返回 "ac"
     iterator.hasNext(); // 返回 true
     iterator.next(); // 返回 "bc"
     iterator.hasNext(); // 返回 false
      

     提示：

     1 <= combinationLength <= characters.length <= 15
     每组测试数据最多包含 10^4 次函数调用。
     题目保证每次调用函数 next 时都存在下一个字母组合。
     */

    public List<String> characterss;
    public int combinationLength = 2;
    public int index;

    public 迭代器类设计(String characters, int combinationLength) {
        this.combinationLength = combinationLength;
        characterss = new ArrayList<>();
        index = 0;
        StringBuilder sb= new StringBuilder();
        backTrack(characters, sb,-1);
    }

    void backTrack(String characters,StringBuilder path,int index){
        //终止条件
        if(path.length() == combinationLength){
            characterss.add(path.toString());
            return;
        }
        char[] chars = characters.toCharArray();
        for(int i = 0;i < chars.length;i++){
            if(i > index){
                //做出选择
                path.append(chars[i]);
                //回溯
                backTrack(characters,path,i);
                //撤销选择
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public String next() {
        if(characterss == null || index >= characterss.size()){
            return null;
        }
        String s = characterss.get(index);
        if(index < characterss.size()){
            ++index;
        }
        return s;
    }

    public boolean hasNext() {
        if(index == characterss.size()){
            return false;
        }
        return characterss.get(index) != null && characterss.get(index) != "";
    }

    public static void main(String[] args) {
        迭代器类设计 iterator = new 迭代器类设计("abc", 2); // 创建迭代器 iterator

        System.out.println(iterator.next()); // 返回 "ab"
        System.out.println(iterator.hasNext());  // 返回 true
        System.out.println(iterator.next()); // 返回 "ac"
        System.out.println(iterator.hasNext());  // 返回 true
        System.out.println(iterator.next()); // 返回 "bc"
        System.out.println(iterator.hasNext());   // 返回 false
    }

//    @Test
//    public void test(){
//
//
//        backTrack("abc",sb,-1);
//        System.out.println(characterss);


//    }
}
