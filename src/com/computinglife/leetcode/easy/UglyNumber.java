package com.computinglife.leetcode.easy;

import java.util.Scanner;
import java.util.Vector;

public class UglyNumber {

	private boolean judgeUglyNumber(Integer num) {
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				// i为num的因子，判断i是否为质数
				if (isPrime(i) && i != 2 && i != 3 && i != 5) {
					return false;
				} else {
					continue;
				}
			}
		}
		return true;
	}

	public boolean isUgly(int num) {
		if (num <= 0) {
			return false;
		}
		while (num % 2 == 0)
			num /= 2;
		while (num % 3 == 0)
			num /= 3;
		while (num % 5 == 0)
			num /= 5;
		return num == 1;

	}

	/**
	 * 判断一个数是否为素数
	 * 
	 * @param a
	 * @return
	 */
	private boolean isPrime(int a) {
		if (a < 2) {
			// 素数不小于2
			return false;
		}
		for (int i = 2; i <= Math.sqrt(a); i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// UglyNumber uglyNumber = new UglyNumber();
		// System.out.println(uglyNumber.judgeUglyNumber(Integer.parseInt(args[0])));
		Scanner scan = new Scanner(System.in);
		Vector<Long> v = new Vector<Long>();
		v.add(new Long(1));
		int i = 0, j = 0, k = 0;
		while (v.size() < 1500) {
			v.add(Math.min(Math.min(v.get(i) * 2, v.get(j) * 3), v.get(k) * 5));
			if (v.get(v.size() - 1).equals(v.get(v.size() - 2))) {
				v.remove(v.size() - 1);
			}
			if (v.get(i) * 2 == v.get(v.size() - 1))
				i++;
			else if (v.get(j) * 3 == v.get(v.size() - 1))
				j++;
			else
				k++;
		}
		int n = 1;
		while ((n = scan.nextInt()) != 0) {
			System.out.println(v.get(n - 1));
		}
	}
}
