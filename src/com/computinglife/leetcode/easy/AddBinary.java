//Given two binary strings, return their sum (also a binary string).
//
//        For example,
//        a = "11"
//        b = "1"
//        Return "100".

package com.computinglife.leetcode.easy;

/**
 * Created by Young on 2015/10/7.
 */
public class AddBinary {
	// public String addBinary(String a, String b) {
	// char[] tmpa = a.toCharArray();
	// int intA = 0;
	// char[] tmpb = b.toCharArray();
	// int intB = 0;
	// for (int i = tmpa.length - 1, j = 0; i >= 0; i--, j++) {
	// intA += (tmpa[i] - 48) * Math.pow(2, j);
	// }
	// for (int i = tmpb.length - 1, j = 0; i >= 0; i--, j++) {
	// intB += (tmpb[i] - 48) * Math.pow(2, j);
	// }
	// intA += intB;
	// StringBuilder tmpBuilder = new StringBuilder();
	// if(intA == 0){
	// tmpBuilder.append(0);
	// }
	// while (intA != 0) {
	// tmpBuilder.append(intA % 2);
	// intA /= 2;
	// }
	// tmpBuilder.reverse();
	// return tmpBuilder.toString();
	// }

	// 位数长的放在后面
	public String addBinary(String a, String b) {
		if (a.isEmpty())
			return b;
		if (b.isEmpty())
			return a;
		if (a.length() > b.length())
			return addBinary(b, a);

		StringBuilder sb = new StringBuilder();
		char carry = '0';

		for (int i = 0; i < b.length(); i++) {
			char aChar = i < a.length() ? a.charAt(a.length() - 1 - i) : '0';
			char bChar = b.charAt(b.length() - 1 - i);
			char current;

			if (aChar != bChar) {
				current = carry == '1' ? '0' : '1';
			} else {
				current = carry;
				carry = aChar;
			}
			sb.insert(0, current);
		}
		if (carry == '1') {
			sb.insert(0, carry);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		AddBinary test = new AddBinary();
		System.out.println(test.addBinary("11", "1000"));
	}
}
