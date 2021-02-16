package com.ouhzrm.算法.回溯_leetcode全部简单和中等题型;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-15 12:54
 **/
public class 添加与搜索单词_数据结构设计_需要回顾 {

    /**
     请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。

     实现词典类 WordDictionary ：

     WordDictionary() 初始化词典对象
     void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
     bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
      

     示例：

     输入：
     ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
     [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
     输出：
     [null,null,null,null,false,true,true,true]

     解释：
     WordDictionary wordDictionary = new WordDictionary();
     wordDictionary.addWord("bad");
     wordDictionary.addWord("dad");
     wordDictionary.addWord("mad");
     wordDictionary.search("pad"); // return False
     wordDictionary.search("bad"); // return True
     wordDictionary.search(".ad"); // return True
     wordDictionary.search("b.."); // return True
      

     提示：

     1 <= word.length <= 500
     addWord 中的 word 由小写英文字母组成
     search 中的 word 由 '.' 或小写英文字母组成
     最多调用 50000 次 addWord 和 search

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/solution/yu-dao-tong-pei-fu-shi-di-gui-chu-li-python-dai-ma/
     */

    public class WordDictionary {

        class Node {
            private Node[] next;
            private boolean isWord;

            public Node() {
                next = new Node[26];
                isWord = false;
            }
        }

        private Node root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Node();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            int len = word.length();
            Node curNode = root;
            for (int i = 0; i < len; i++) {
                char curChar = word.charAt(i);
                Node next = curNode.next[curChar - 'a'];
                if (next == null) {
                    curNode.next[curChar - 'a'] = new Node();
                }
                curNode = curNode.next[curChar - 'a'];
            }
            if (!curNode.isWord) {
                curNode.isWord = true;
            }
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return match(word, root, 0);
        }

        private boolean match(String word, Node node, int start) {
            if (start == word.length()) {
                return node.isWord;
            }
            char alpha = word.charAt(start);
            if (alpha == '.') {
                for (int i = 0; i < 26; i++) {
                    if (node.next[i] != null && match(word, node.next[i], start + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (node.next[alpha - 'a'] == null) {
                    return false;

                }
                return match(word, node.next[alpha - 'a'], start + 1);
            }
        }
    }


}
