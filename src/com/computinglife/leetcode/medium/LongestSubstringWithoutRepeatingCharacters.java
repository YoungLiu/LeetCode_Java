//Given a string, find the length of the longest substring without repeating characters. 
//For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
//which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

package com.computinglife.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		char[] arrayS = s.toCharArray();
		int max = 0;
		int head = 0;
		int tail = 0;
		Set<Character> charSet = new HashSet<Character>();
		while (head < arrayS.length) {
			while (!charSet.contains(arrayS[tail])) {
				charSet.add(arrayS[tail]);
				if (tail < arrayS.length - 1) {
					tail++;
				} else {
					tail++;
					break;
				}
			}
			max = max < (tail - head) ? (tail - head) : max;
			head++;
			tail = head;
			charSet.clear();
		}
		return max;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(test.lengthOfLongestSubstring("a"));
	}

}
