//Divide two integers without using multiplication, division and mod operator.
//
//If it is overflow, return MAX_INT.

package com.computinglife.leetcode.medium;

public class DivideTwoIntegers {

	// public int divide(int dividend, int divisor) {
	//
	// }

	/* 这种方法的问题在于如果数据运算量很大，会不停的递归下去，直至jvm栈溢出，所以如下方法虽然是一个好方法，但是并不能应对大数据量的运算 */
	public int divide2(int dividend, int divisor) {
		int lolar = 1;
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			lolar = -1;
		}
		long ldividend = Math.abs((long) dividend);
		long ldivisor = Math.abs((long) divisor);

		if (ldivisor == 0) {
			if (lolar == 1) {
				return Integer.MAX_VALUE;
			} else {
				return Integer.MIN_VALUE;
			}
		}
		if ((ldividend == 0) || (ldividend < ldivisor)) {
			return 0;
		}
		long lRet = lDivide(ldividend, ldivisor);
		if (lRet > Integer.MAX_VALUE) {
			return lolar == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		} else {
			return (int) (lolar * lRet);
		}

	}

	private long lDivide(long ldividend, long ldivisor) {
		if (ldividend < ldivisor) {
			return 0;
		}
		long sum = ldivisor;
		long nums = 1;
		while ((sum + sum) <= ldivisor) {
			sum += sum;
			nums += nums;
		}
		return nums + lDivide(ldividend - sum, ldivisor);
	}

	public static void main(String[] args) {
		DivideTwoIntegers test = new DivideTwoIntegers();
		System.out.println(test.divide2(1000000000, -3));
	}
}
