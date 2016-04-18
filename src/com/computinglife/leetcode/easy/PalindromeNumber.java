//Determine whether an integer is a palindrome. Do this without extra space.
//
//click to show spoilers.
//
//Some hints:
//Could negative integers be palindromes? (ie, -1)
//
//If you are thinking of converting the integer to string, note the restriction of using extra space.
//
//You could also try reversing an integer. However, 
//if you have solved the problem "Reverse Integer", 
//you know that the reversed integer might overflow. How would you handle such case?
//
//There is a more generic way of solving this problem.

package com.computinglife.leetcode.easy;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int init = x;
		int reversed = 0;
		while (x != 0) {
			reversed = reversed * 10 + x % 10;
			x /= 10;
		}
		return reversed == init;
	}

	public static void main(String[] args) {
		PalindromeNumber test = new PalindromeNumber();
		System.out.println(test.isPalindrome(3235));
	}

}
