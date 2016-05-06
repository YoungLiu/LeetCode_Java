/*Given a string array words, find the maximum value of length(word[i]) * length(word[j])
        where the two words do not share common letters.
        You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

        Example 1:
        Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
        Return 16
        The two words can be "abcw", "xtfn".

        Example 2:
        Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
        Return 4
        The two words can be "ab", "cd".

        Example 3:
        Given ["a", "aa", "aaa", "aaaa"]
        Return 0
        No such pair of words.*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YanceyLiu on 5/6/2016.
 */
public class MaximumProductofWordLengths {
    public int maxProductBase(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        List<int[]> elements = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int[] tmpletter = new int[26];
            elements.add(tmpletter);
            for (int j = 0; j < words[i].length(); j++) {
                elements.get(i)[words[i].charAt(j) - 'a']++;
            }
        }
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                boolean flag = true;
                for (int tmp = 0; tmp < 26; tmp++) {
                    if (elements.get(i)[tmp] != 0 && elements.get(j)[tmp] != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag && words[i].length() * words[j].length() > count) {
                    count = words[i].length() * words[j].length();
                }
            }
        }
        return count;
    }

    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int[] letter = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                letter[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((letter[i] & letter[j]) == 0) {
                    count = Math.max(count,words[i].length()*words[j].length());
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaximumProductofWordLengths test = new MaximumProductofWordLengths();
        String[] strings = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(test.maxProduct(strings));
    }
}
