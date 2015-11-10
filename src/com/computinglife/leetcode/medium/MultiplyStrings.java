//Given two numbers represented as strings, return multiplication of the numbers as a string.
//
//Note: The numbers can be arbitrarily large and are non-negative.

package com.computinglife.leetcode.medium;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		int[] nums = new int[num1.length() + num2.length()];
		int len1 = num1.length();
		int len2 = num2.length();
		for (int i = len1 - 1; i >= 0; i--) {
			for (int j = len2 - 1; j >= 0; j--) {
				int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				nums[i + j] += (temp + nums[i + j + 1]) / 10;
				nums[i + j + 1] = (nums[i + j + 1] + temp) % 10;
			}
		}
		StringBuilder res = new StringBuilder();
		for (int i : nums) {
			if (res.length() > 0 || i > 0) {
				res.append(i);
			}
		}
		return res.length() == 0 ? "0" : res.toString();
	}

	public static void main(String[] args) {

	}
}
