/*Given two words (beginWord and endWord), and a dictionary's word list,
        find the length of shortest transformation sequence from beginWord to endWord, such that:

        Only one letter can be changed at a time
        Each intermediate word must exist in the word list
        For example,

        Given:
        beginWord = "hit"
        endWord = "cog"
        wordList = ["hot","dot","dog","lot","log"]
        As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
           6return its length 5.

        Note:
        Return 0 if there is no such transformation sequence.
        All words have the same length.
        All words contain only lowercase alphabetic characters.*/

package com.computinglife.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by youngliu on 1/7/16.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.isEmpty() || endWord.isEmpty() || beginWord.length() != endWord.length()) {
            return 0;
        }
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 1;
        int curNum = 0; //代表广度优先遍历每一层进入队列的元素总数
        int lastNum = 1;//代表每次在队列中的游标，到0了说明一层结束整体level应当前向加一,然后重新用curNum赋值
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            lastNum--;
            for (int i = 0; i < cur.length(); i++) {
                char[] charArrays = cur.toCharArray();
                for (char c = 'a'; c < 'z'; c++) {
                    charArrays[i] = c;
                    String tmp = new String(charArrays);
                    if (tmp.equals(endWord)) {
                        return level + 1;
                    }
                    if (wordList.contains(tmp) && !visited.contains(tmp)) {
                        queue.offer(tmp);
                        visited.add(tmp);
                        curNum++;
                    }
                }
            }
            if (lastNum == 0) {
                lastNum = curNum;
                curNum = 0;
                level++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder test = new WordLadder();
        Set<String> wordList = new HashSet<String>() {
            {
                add("hot");
                add("dot");
                add("dog");
                add("lot");
                add("log");
            }
        };
        //"hit" -> "hot" -> "dot" -> "dog" -> "cog"
        System.out.println(test.ladderLength("hit", "cog", wordList));
    }
}
