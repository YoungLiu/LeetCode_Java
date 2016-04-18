//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
//For example:
//
//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 

package com.computinglife.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		char[] dictionary = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		int tmp = 0;
		List<Character> ret = new ArrayList<>();
		while (n != 0) {
			tmp = n % 26;
			if (tmp == 0) {
				ret.add(dictionary[25]);
				n = n / 26 - 1;
			} else {
				ret.add(dictionary[tmp - 1]);
				n /= 26;
			}
		}
		Collections.reverse(ret);
		return ret.toString().replaceAll("[\\[\\]\\s,]", "");
	}

	public static void main(String[] args) {
		ExcelSheetColumnTitle test = new ExcelSheetColumnTitle();
		System.out.println(test.convertToTitle(702));
	}
}
