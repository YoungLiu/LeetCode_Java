//Implement pow(x, n).

package com.computinglife.leetcode.medium;

public class PowXN {
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		double tmp = myPow(x, Math.abs(n / 2));
		if (n > 0) {
			if ((n & 1) == 1) {
				return tmp * tmp * x;
			} else {
				return tmp * tmp;
			}
		} else {
			if ((n & 1) == 1) {
				return 1 / (tmp * tmp * x);
			} else {
				return 1 / (tmp * tmp);
			}
		}
	}
}
