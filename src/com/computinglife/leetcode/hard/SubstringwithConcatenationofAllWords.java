//You are given a string, s, and a list of words, words, that are all of the same length.
//        Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once
//        and without any intervening characters.
//
//        For example, given:
//        s: "barfoothefoobarman"
//        words: ["foo", "bar"]
//
//        You should return the indices: [0,9].
//        (order does not matter).

package com.computinglife.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yliu on 8/8/16.
 */
public class SubstringwithConcatenationofAllWords {

    // Time limit exceeded
    public List<Integer> findSubstringTime(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return res;
        }
        int len = words[0].length();
        if (len == 0) {
            return res;
        }
        HashMap<String, Integer> map01 = new HashMap<>();
        for (String tmp : words) {
            if (map01.containsKey(tmp)) {
                map01.put(tmp, map01.get(tmp) + 1);
            } else {
                map01.put(tmp, 1);
            }
        }
        for (int i = 0; i <= s.length() - len * words.length; i++) {
            HashMap<String, Integer> map02 = new HashMap<>();
            int j = 0;
            for (; j < words.length; j++) {
                String tmp = s.substring(i + j * len, i + (j + 1) * len);
                if (!map01.containsKey(tmp)) {
                    break;
                }
                if (map02.containsKey(tmp)) {
                    map02.put(tmp, map02.get(tmp) + 1);
                } else {
                    map02.put(tmp, 1);
                }
                if (map02.get(tmp) > map01.get(tmp)) {
                    break;
                }
            }
            if (j == words.length) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return res;
        }
        int len = words[0].length();
        if (len == 0) {
            return res;
        }

        return res;
    }


    public static void main(String[] args){
        String[] words = {"foo", "bar"};
        SubstringwithConcatenationofAllWords test = new SubstringwithConcatenationofAllWords();
        List<Integer> res = test.findSubstringTime("barfoothefoobarman", words);
        for(Integer tmp : res){
            System.out.println(tmp);
        }
    }
}
