//Compare two version numbers version1 and version2.
//If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
//
//You may assume that the version strings are non-empty and contain only digits and the . character.
//The . character does not represent a decimal point and is used to separate number sequences.
//For instance, 2.5 is not "two and a half" or "half way to version three", 
//it is the fifth second-level revision of the second first-level revision.
//
//Here is an example of version numbers ordering:
//
//0.1 < 1.1 < 1.2 < 13.37

package com.computinglife.leetcode.easy;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		// 分别处理小数点前后的两个部分
		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");

		// 判断是否含有小数点
		if (ver1.length == 1 || ver2.length == 1) {
			if (Integer.parseInt(ver1[0]) > Integer.parseInt(ver2[0])) {
				return 1;
			} else if (Integer.parseInt(ver1[0]) < Integer.parseInt(ver2[0])) {
				return -1;
			} else if (ver1.length > ver2.length) {
				for (int i = ver2.length; i < ver1.length; i++) {
					if (Integer.parseInt(ver1[i]) != 0) {
						return 1;
					}
				}
				return 0;
			} else if (ver1.length < ver2.length) {
				for (int i = ver1.length; i < ver2.length; i++) {
					if (Integer.parseInt(ver2[i]) != 0) {
						return -1;
					}
				}
				return 0;
			} else {
				return 0;
			}
		}

		// 循环小数点各个部分
		int length = Math.min(ver1.length, ver2.length);
		for (int i = 0; i < length; i++) {
			if (Integer.parseInt(ver1[i]) > Integer.parseInt(ver2[i])) {
				return 1;
			} else if (Integer.parseInt(ver1[i]) < Integer.parseInt(ver2[i])) {
				return -1;
			}
		}

		// 特殊情况
		if (ver1.length > ver2.length) {
			for (int i = ver2.length; i < ver1.length; i++) {
				if (Integer.parseInt(ver1[i]) != 0) {
					return 1;
				}
			}
			return 0;
		} else if (ver1.length < ver2.length) {
			for (int i = ver1.length; i < ver2.length; i++) {
				if (Integer.parseInt(ver2[i]) != 0) {
					return -1;
				}
			}
			return 0;
		}
		return 0;
	}

	public static void main(String[] args) {
		CompareVersionNumbers test = new CompareVersionNumbers();
		System.out.println(test.compareVersion(
				"19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000",
				"19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000"));
	}
}