//Given two strings s and t, determine if they are isomorphic.
//
//Two strings are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
//
//For example,
//Given "egg", "add", return true.
//
//Given "foo", "bar", return false.
//
//Given "paper", "title", return true.
//
//Note:
//You may assume both s and t have the same length.

package com.computinglife.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s.equals("") || t.equals("")) {
			return true;
		}
		int[] sList = change(s);
		int[] tList = change(t);
		for (int i = 0; i < sList.length; i++) {
			if (sList[i] != tList[i]) {
				return false;
			}
		}
		return true;
	}

	public int[] change(String s) {
		char[] tmp = s.toCharArray();
		Map<Character, Integer> tmpMap = new HashMap<Character, Integer>();
		int[] result = new int[tmp.length];
		int num = 0;
		for (int i = 0; i < tmp.length; i++) {
			if (tmpMap.containsKey(tmp[i])) {
				result[i] = tmpMap.get(tmp[i]);
			} else {
				tmpMap.put(tmp[i], num++);
				result[i] = tmpMap.get(tmp[i]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		IsomorphicStrings test = new IsomorphicStrings();
		System.err.println(test.isIsomorphic("paper", "title"));
	}

}
