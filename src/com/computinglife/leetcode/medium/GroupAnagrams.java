//Given an array of strings, group anagrams together.
//
//For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
//Return:
//
//[
//  ["ate", "eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//Note:
//For the return value, each inner list's elements must follow the lexicographic order.
//All inputs will be in lower-case.

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		Map<Integer, List<String>> mapToRecord = new HashMap<>();
		// int primeTable[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
		// 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
		// 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163,
		// 167, 173, 179, 181, 191, 193, 197,
		// 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277,
		// 281, 283, 293, 307, 311, 313, 317,
		// 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409
		// };
		int fingerprint;
		int[] primeTable = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
				97, 101 };
		for (String tmp : strs) {
			fingerprint = 1;
			char[] tmps = tmp.toCharArray();
			for (char charInTmp : tmps) {
				fingerprint *= primeTable[charInTmp - 'a'];
			}
			if (mapToRecord.containsKey(fingerprint)) {
				mapToRecord.get(fingerprint).add(tmp);
			} else {
				List<String> newList = new ArrayList<>();
				newList.add(tmp);
				mapToRecord.put(fingerprint, newList);
			}
		}
		// 接下来按字母升序逐一处理每个指纹数字对应的字符串list
		for (Integer key : mapToRecord.keySet()) {
			sort(mapToRecord.get(key));
			res.add(mapToRecord.get(key));
		}
		return res;
	}

	public void sort(List<String> sList) {
		int length = sList.size();
		while (--length > 0) {
			for (int i = 1; i <= length; i++) {
				if (sList.get(i).compareTo(sList.get(i - 1)) < 0) {
					// 交换
					String tmp = sList.get(i);
					sList.set(i, sList.get(i - 1));
					sList.set(i - 1, tmp);
				}
			}
		}
	}

	public static void main(String[] args) {
		GroupAnagrams test = new GroupAnagrams();
		String[] testString = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(test.groupAnagrams(testString));
	}
}
