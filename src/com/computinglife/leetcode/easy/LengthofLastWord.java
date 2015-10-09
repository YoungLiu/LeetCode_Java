//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
//return the length of last word in the string.
//
//If the last word does not exist, return 0.
//
//Note: A word is defined as a character sequence consists of non-space characters only.
//
//For example, 
//Given s = "Hello World",
//return 5.

package com.computinglife.leetcode.easy;

public class LengthofLastWord {
	public int lengthOfLastWord(String s) {

		char[] sequenceArray = s.toCharArray();
		int count = 0;
		boolean flag = true;
		for (int i = sequenceArray.length - 1; i >= 0; i--) {
			if (sequenceArray[i] == ' ' && flag) {
				continue;
			}
			flag = false;
			count++;
			if (sequenceArray[i] == ' ') {
				count--;
				break;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		LengthofLastWord test = new LengthofLastWord();
		System.out.println(test.lengthOfLastWord("liuy ddda   "));
	}

}
