//Given two numbers represented as strings, return multiplication of the numbers as a string.
//
//Note: The numbers can be arbitrarily large and are non-negative.

package com.computinglife.leetcode.medium;

import java.math.BigInteger;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		BigInteger bNum1 = new BigInteger(num1);
		BigInteger bNum2 = new BigInteger(num2);
		bNum1 = bNum1.multiply(bNum2);
		return bNum1.toString();
	}
}
