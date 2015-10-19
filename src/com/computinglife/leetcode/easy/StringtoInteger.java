//Implement atoi to convert a string to an integer.
//
//Hint: Carefully consider all possible input cases. If you want a challenge, 
//please do not see below and ask yourself what are the possible input cases.
//
//Notes: It is intended for this problem to be specified vaguely 
//(ie, no given input specs). You are responsible to gather all the input requirements up front.

package com.computinglife.leetcode.easy;

public class StringtoInteger {
	public int myAtoi(String str) {
		int p = 0;
		int ret = 0;
		while (p < str.length() && Character.isWhitespace(str.charAt(p))) {
			p++;
		}
		if (p == str.length()) {
			return 0;
		}
		boolean negFlag = false;
		if (str.charAt(p) == '-') {
			negFlag = true;
		}
		if (str.charAt(p) == '+' || str.charAt(p) == '-') {
			p++;
		}
		for (; p < str.length(); p++) {
			int tmp = str.charAt(p) - '0';
			if (tmp > 9 || tmp < 0) {
				break;
			}
			if (!negFlag && ret > (Integer.MAX_VALUE - tmp) / 10) {
				return Integer.MAX_VALUE;
			} else if (negFlag && ret < (Integer.MIN_VALUE + tmp) / 10) {
				return Integer.MIN_VALUE;
			}
			ret = ret * 10 + (negFlag ? -tmp : tmp);
		}
		return ret;

	}

}
