//Given a roman numeral, convert it to an integer.
//
//Input is guaranteed to be within the range from 1 to 3999.

package com.computinglife.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
	public int romanToInt(String s) {
		// 初始化罗马数字
		Map<Character, Integer> map = new HashMap<Character, Integer>() {
			{
				put('I', 1);
				put('V', 5);
				put('X', 10);
				put('L', 50);
				put('C', 100);
				put('D', 500);
				put('M', 1000);
			}
		};
		int pre = 0;
		int sum = 0;
		char[] charArray = s.toCharArray();
		for (char tmp : charArray) {
			// 左减数字只能是占一位,默认之前已经加了一个，所以这里减两个
			if (map.get(tmp) > pre) {
				sum -= 2 * pre;
			}
			sum += map.get(tmp);
			pre = map.get(tmp);
		}
		return sum;
	}

	public static void main(String[] args) {
		RomantoInteger test = new RomantoInteger();
		System.out.println(test.romanToInt("DCXXI"));
	}
}
