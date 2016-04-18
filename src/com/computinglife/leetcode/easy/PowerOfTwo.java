//Given an integer, write a function to determine if it is a power of two.

package com.computinglife.leetcode.easy;

public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		if (n == 0) {
			return false;
		}
		while (n % 2 == 0) {
			n = n / 2;
		}
		if (n == 1) {
			return true;
		} else {
			return false;
		}
	}
}
