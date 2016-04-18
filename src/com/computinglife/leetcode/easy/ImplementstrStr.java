//Implement strStr().
//
//Returns the index of the first occurrence of needle in haystack, 
//or -1 if needle is not part of haystack.

package com.computinglife.leetcode.easy;

public class ImplementstrStr {
	public int strStr(String haystack, String needle) {
		char[] hayStackArray = haystack.toCharArray();
		char[] needleArray = needle.toCharArray();
		if (hayStackArray.length < needleArray.length) {
			return -1;
		}
		if (needleArray.length == 0) {
			return 0;
		}
		int tmp = 0;
		int tmpi = 0;
		for (int i = 0; i < hayStackArray.length; i++) {
			tmpi = i;
			while (tmp < needleArray.length) {
				if (i < hayStackArray.length && hayStackArray[i] == needleArray[tmp]) {
					i++;
					tmp++;
				} else {
					tmp = 0;
					break;
				}
			}
			if (tmp == needleArray.length) {
				return tmpi;
			}
			i = tmpi;
		}
		return -1;
	}

	public static void main(String[] args) {
		ImplementstrStr test = new ImplementstrStr();
		System.out.println(test.strStr("a", "a"));
	}
}
