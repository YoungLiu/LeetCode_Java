//Given two strings s and t, write a function to determine if t is an anagram of s.
//
//For example,
//s = "anagram", t = "nagaram", return true.
//s = "rat", t = "car", return false.
//
//Note:
//You may assume the string contains only lowercase alphabets.

package com.computinglife.leetcode.easy;

import java.util.Arrays;

public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();

		Arrays.sort(sArray);
		Arrays.sort(tArray);

		return String.valueOf(sArray).equals(String.valueOf(tArray));

	}

	public static void main(String[] args) {
		ValidAnagram validAnagram = new ValidAnagram();

		System.out.println(validAnagram.isAnagram("liuyang", "yanglio"));
	}

}
