/*Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

        For example, given
        s = "leetcode",
        dict = ["leet", "code"].

        Return true because "leetcode" can be segmented as "leet code".*/

package com.computinglife.leetcode.medium;

import java.util.Set;

/**
 * Created by youngliu on 1/22/16.
 */
public class WordBreak {
    public boolean wordBreakTIMELIMIT(String s, Set<String> wordDict) {
        return wordBreakHelper(s, wordDict, 0);
    }

    //naive方法-->Time Limit Exceeded
    public boolean wordBreakHelper(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (String word : wordDict) {
            int len = word.length();
            int end = start + len;
            if (end > s.length()) {
                continue;
            }
            if (s.substring(start, end).equals(word)) {
                if (wordBreakHelper(s, wordDict, end)) {
                    return true;
                }
            }
        }
        return false;
    }

    //dynamic programming
    public boolean wordBreakDP(String s, Set<String> wordDict) {
        boolean[] status = new boolean[s.length() + 1];
        status[0] = true;
        for (int i = 0; i < s.length(); i++) {
            //从true开始
            if (!status[i]) {
                continue;
            }
            for (String word : wordDict) {
                int len = word.length();
                int end = i + len;
                if (end > s.length()) {
                    continue;
                }
                if (status[end]) {
                    continue;
                }
                if (s.substring(i, end).equals(word)) {
                    status[end] = true;
                }
            }
        }
        return status[s.length()];
    }

    //此题也可以使用正则表达式来进行判断
}
