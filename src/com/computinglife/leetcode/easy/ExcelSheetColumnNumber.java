//Given a column title as appear in an Excel sheet, return its corresponding column number.
//
//For example:
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28

package com.computinglife.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		char[] dictionary = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		Map<Character, Integer> dicMap = new HashMap<>();
		int count = 1;
		for (char tmp : dictionary) {
			dicMap.put(tmp, count++);
		}
		char[] aim = s.toCharArray();
		reverse(aim, 0, aim.length - 1);
		int result = 0;
		for (int i = 0; i < aim.length; i++) {
			if (i == 0) {
				result += dicMap.get(aim[i]);
			} else {
				result += dicMap.get(aim[i]) * Math.pow(26, i);
			}
		}
		return result;
	}

	public void reverse(char[] nums, int start, int end) {
		char tmp = 0;
		for (; start < end; start++, end--) {
			tmp = nums[end];
			nums[end] = nums[start];
			nums[start] = tmp;
		}
	}

	public static void main(String[] args) {
		ExcelSheetColumnNumber test = new ExcelSheetColumnNumber();
		System.out.println(test.titleToNumber("AB"));
	}
}
