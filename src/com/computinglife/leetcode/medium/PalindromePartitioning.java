/*Given a string s, partition s such that every substring of the partition is a palindrome.

        Return all possible palindrome partitioning of s.

        For example, given s = "aab",
        Return

        [
            ["aa","b"],
            ["a","a","b"]
        ]*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngliu on 1/8/16.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        helper(res, list, s);
        return res;
    }

    private void helper(List<List<String>> res, List<String> list, String str) {
        if (str.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        int len = str.length();
        for (int i = 1; i <= len; i++) {
            String subStr = str.substring(0, i);
            if (isPalindrome(subStr)) {
                list.add(subStr);
                String surplus = str.substring(i);
                helper(res, list, surplus);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
