//Given a string S, find the longest palindromic substring in S. 
//You may assume that the maximum length of S is 1000, 
//and there exists one unique longest palindromic substring.

package com.computinglife.leetcode.medium;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		char[] arrayS = s.toCharArray();
		int maxscale1 = 0;
		int maxpoint1 = 0;
		int scale = 0;
		for (int i = 0; i < arrayS.length; i++) {
			while ((i - scale) >= 0 && (i + scale) < arrayS.length) {
				if (arrayS[i - scale] == arrayS[i + scale]) {
					scale++;
				} else {
					break;
				}
			}
			if (scale > maxscale1) {
				// 暂存回文记录
				maxscale1 = --scale;
				maxpoint1 = i;
			}
			scale = 0;
		}

		int maxpoint2 = 0;
		int maxscale2 = 0;
		for (int i = 0; i < arrayS.length; i++) {
			while ((i - scale) >= 0 && (i + 1 + scale) < arrayS.length) {
				if (arrayS[i - scale] == arrayS[i + 1 + scale]) {
					scale++;
				} else {
					break;
				}
			}
			if (scale > maxscale2) {
				// 暂存回文记录
				maxscale2 = scale;
				maxpoint2 = i;
			}
			scale = 0;
		}

		StringBuilder ret = new StringBuilder();
		if (2 * maxscale1 + 1 > 2 * maxscale2) {
			for (int i = maxpoint1 - maxscale1; i < maxpoint1 + maxscale1 + 1; i++) {
				ret.append(arrayS[i]);
			}
		} else {
			for (int i = maxpoint2 - maxscale2 + 1; i < maxpoint2 + maxscale2 + 1; i++) {
				ret.append(arrayS[i]);
			}
		}
		return ret.toString();
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring test = new LongestPalindromicSubstring();
		System.out.println(test.longestPalindrome("bbaabbccff"));
	}
}
