/*Given a pattern and a string str, find if str follows the same pattern.

        Here follow means a full match,
        such that there is a bijection between a letter in pattern and a non-empty word in str.

        Examples:
        pattern = "abba", str = "dog cat cat dog" should return true.
        pattern = "abba", str = "dog cat cat fish" should return false.
        pattern = "aaaa", str = "dog cat cat dog" should return false.
        pattern = "abba", str = "dog dog dog dog" should return false.
        Notes:
        You may assume pattern contains only lowercase letters,
        and str contains lowercase letters separated by a single space.*/

package com.computinglife.leetcode.easy;

import java.util.*;

/**
 * Created by YanceyLiu on 5/28/2016.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        char[] patternArray = pattern.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < patternArray.length; i++) {
            if (map.containsKey(patternArray[i])) {
                map.get(patternArray[i]).add(i);
            } else {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                map.put(patternArray[i], index);
            }
        }
        String[] strArray = str.split(" ");
        if (patternArray.length != strArray.length) {
            return false;
        }
        Set<String> used = new HashSet<>();
        for (Map.Entry element : map.entrySet()) {
            ArrayList<Integer> indexList = (ArrayList<Integer>) element.getValue();
            String tmpString = strArray[indexList.get(0)];
            if (!used.contains(tmpString)) {
                used.add(tmpString);
            } else {
                return false;
            }
            for (int i = 1; i < indexList.size(); i++) {
                if (!strArray[indexList.get(i)].equals(tmpString)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern test = new WordPattern();
        System.out.println(test.wordPattern("abba", "dog dog dog dog"));
    }
}
