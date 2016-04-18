//Given a non-negative number represented as an array of digits, plus one to the number.
//
//The digits are stored such that the most significant digit is at the head of the list.

package com.computinglife.leetcode.easy;

public class PlusOne {

	public int[] plusOne(int[] digits) {
		if (digits.length == 0) {
			int[] ret = new int[] { 1 };
			return ret;
		}
		int carry = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (i == digits.length - 1 && digits[i] + 1 > 9) {
				carry = 1;
				digits[i] = digits[i] + 1 - 10;
				continue;
			}
			if (i == digits.length - 1 && digits[i] + 1 < 10) {
				digits[i] += 1;
				break;
			}
			if (i != digits.length - 1 && carry == 1 && digits[i] + carry < 10) {
				digits[i] += carry;
				carry = 0;
				break;
			}
			if (i != digits.length - 1 && carry == 1 && digits[i] + carry > 9) {
				digits[i] = digits[i] + 1 - 10;
			}
		}
		if (carry == 1) {
			// 需要重新申请一个位数加一的数组来进行进位
			int[] ret = new int[digits.length + 1];
			ret[0] = 1;
			for (int i = 0; i < digits.length - 1; i++) {
				ret[i + 1] = digits[i];
			}
			return ret;
		} else {
			return digits;
		}
	}

	public static void main(String[] args) {
		PlusOne test = new PlusOne();
		int[] digits = {};
		int[] ret = test.plusOne(digits);
		for (int tmp : ret) {
			System.out.println(tmp);
		}
	}

}
