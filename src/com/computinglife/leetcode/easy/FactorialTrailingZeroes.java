//Given an integer n, return the number of trailing zeroes in n!.
//
//Note: Your solution should be in logarithmic time complexity.

package com.computinglife.leetcode.easy;

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int result = 0;
		while (n != 0) {
			result += n / 5;
			n /= 5;
		}
		return result;
	}

	public static void main(String[] args) {
		FactorialTrailingZeroes test = new FactorialTrailingZeroes();
		System.out.println(test.trailingZeroes(10));
	}
}
