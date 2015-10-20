//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"
//Write the code that will take a string and make this conversion given a number of rows:
//
//string convert(string text, int nRows);
//convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

//此题需要好好琢磨

package com.computinglife.leetcode.easy;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 0 || numRows == 1) {
			return s;
		}
		StringBuilder ret = new StringBuilder();
		int length = s.length();
		int tmp;
		int offset;
		boolean flag;
		for (int i = 1; i <= numRows; i++) {
			tmp = i;
			flag = true;
			while ((i - 1) < length) {
				ret.append(s.charAt(i - 1));
				if (flag) {
					if (tmp == numRows) {
						offset = 2 * numRows - 2;
					} else {
						offset = 2 * numRows - 2 * tmp;
					}
					i += offset;
					flag = false;
				} else {
					if (tmp == numRows) {
						offset = 2 * numRows - 2;
					} else {
						offset = 2 * (numRows - 1) - 2 * ((i - 1) % (numRows - 1));
					}
					i += offset;
					flag = true;
				}
			}
			i = tmp;
		}
		return ret.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion test = new ZigZagConversion();
		System.out.println(test.convert("PAYPALISHIRING", 4));
	}

}
