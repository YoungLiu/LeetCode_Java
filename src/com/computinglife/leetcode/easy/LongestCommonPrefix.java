//Write a function to find the longest common prefix string amongst an array of strings.

package com.computinglife.leetcode.easy;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		StringBuilder ret = new StringBuilder();
		if (strs.length == 0) {
			return ret.toString();
		}
		if (strs[0].length() == 0) {
			return ret.toString();
		}
		if (strs.length == 1) {
			return strs[0];
		}
		char tmp = strs[0].charAt(0);
		int index = 0;
		boolean flag = true;
		while (flag) {
			for (int i = 0; i < strs.length; i++) {
				if (index > strs[i].length() - 1) {
					return ret.toString();
				}
				if (tmp != strs[i].charAt(index)) {
					flag = false;
					return ret.toString();
				}
			}
			ret.append(tmp);
			index++;
			if (index > strs[0].length() - 1) {
				return ret.toString();
			}
			tmp = strs[0].charAt(index);
		}
		return ret.toString();
	}

	public static void main(String[] args) {
		LongestCommonPrefix test = new LongestCommonPrefix();
		String[] testStr = { "l", "l" };
		System.out.println(test.longestCommonPrefix(testStr));
	}
}
