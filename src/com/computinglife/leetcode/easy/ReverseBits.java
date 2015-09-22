//Reverse bits of a given 32 bits unsigned integer.
//
//        For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
//        return 964176192 (represented in binary as 00111001011110000010100101000000).
//
//        Follow up:
//        If this function is called many times, how would you optimize it?
//note:这道题在用１做测试用例的情况下是无法解决的，因为在java中int的取值范围为-2147483648~2147483647
//     在返回值为int的情况下是无法返回2147483648的

package com.computinglife.leetcode.easy;

/**
 * Created by Young on 2015/9/20.
 */
public class ReverseBits {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int res = 0;
		int count = 31;
		while (n != 0) {
			if ((n & 1) == 1) {
				res = res + (1 << count);
			}
			n >>>= 1;
			count--;
		}

		return res;
	}

	public static void main(String[] args) {
		ReverseBits test = new ReverseBits();
		System.out.println(test.reverseBits(1));
		// System.out.println(1 << 31);
	}
}