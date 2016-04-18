//Given an integer, convert it to a roman numeral.
//
//Input is guaranteed to be within the range from 1 to 3999.

package com.computinglife.leetcode.medium;

public class IntegertoRoman {
	// 左减占位只有一位
	public enum Type {
		M(1000), CM(900), D(500), CD(400), C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);
		private final int value;

		Type(int value) {
			this.value = value;
		}
	}

	public String intToRoman(int num) {
		StringBuilder ret = new StringBuilder();
		for (Type t : Type.values()) {
			while (num >= t.value) {
				ret.append(t);
				num -= t.value;
			}
		}
		return ret.toString();
	}

	public static void main(String[] args) {
		IntegertoRoman test = new IntegertoRoman();
		System.out.println(test.intToRoman(56));
	}
}
