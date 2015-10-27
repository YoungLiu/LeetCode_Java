//Given a digit string, return all possible letter combinations that the number could represent.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below.
//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
	public List<String> letterCombinations(String digits) {
		// 初始化数字字母映射
		Map<Character, List<String>> map = new HashMap<Character, List<String>>() {
			{
				put('2', Arrays.asList(new String[] { "a", "b", "c" }));
				put('3', Arrays.asList(new String[] { "d", "e", "f" }));
				put('4', Arrays.asList(new String[] { "g", "h", "i" }));
				put('5', Arrays.asList(new String[] { "j", "k", "l" }));
				put('6', Arrays.asList(new String[] { "m", "n", "o" }));
				put('7', Arrays.asList(new String[] { "p", "q", "r", "s" }));
				put('8', Arrays.asList(new String[] { "t", "u", "v" }));
				put('9', Arrays.asList(new String[] { "w", "x", "y", "z" }));
			}
		};
		List<String> ret = new ArrayList<String>();
		if (digits.length() == 0) {
			return ret;
		}
		if (digits.length() == 1) {
			return map.get(digits.charAt(0));
		}
		List<String> tmp = letterCombinations(digits.substring(1, digits.length()));
		for (String first : map.get(digits.charAt(0))) {
			for (String rest : tmp) {
				ret.add(first + rest);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		LetterCombinationsofaPhoneNumber testCombinationsofaPhoneNumber = new LetterCombinationsofaPhoneNumber();
		System.out.println(testCombinationsofaPhoneNumber.letterCombinations("233"));
	}
}
