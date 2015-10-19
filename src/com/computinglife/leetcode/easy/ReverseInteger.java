//Reverse digits of an integer.
//
//Example1: x = 123, return 321
//Example2: x = -123, return -321
//此题关键在于翻转后整数溢出的判断和处理

package com.computinglife.leetcode.easy;

public class ReverseInteger {
	public int reverse(int x) {
		int ret = 0;
		while (x != 0) {
			// 判断溢出
			if (x > 0 && ret > (Integer.MAX_VALUE - x % 10) / 10) {
				return 0;
			}
			if (x < 0 && ret < (Integer.MIN_VALUE - x % 10) / 10) {
				return 0;
			}
			ret = ret * 10 + x % 10;

			x /= 10;
		}
		return ret;
	}

	public static void main(String[] args) {
		ReverseInteger test = new ReverseInteger();
		System.out.println(test.reverse(-123));
	}
}
