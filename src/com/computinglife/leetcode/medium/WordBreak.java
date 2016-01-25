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
    public boolean wordBreak(String s, Set<String> wordDict) {
        return wordBreakHelper(s, wordDict, 0);
    }

    //naive方法
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
            if (s.substring(start, end).equals(s)) {
                if (wordBreakHelper(s, wordDict, start + len)) {
                    return true;
                }
            }
        }
        return false;
    }


}
