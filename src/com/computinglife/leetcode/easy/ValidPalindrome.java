//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//        For example,
//        "A man, a plan, a canal: Panama" is a palindrome.
//        "race a car" is not a palindrome.
//
//        Note:
//        Have you consider that the string might be empty? This is a good question to ask during an interview.
//
//        For the purpose of this problem, we define empty string as valid palindrome.

package com.computinglife.leetcode.easy;

/**
 * Created by youngliu on 9/28/15.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^\\w]", "");
        s = s.toUpperCase();
        char[] sArray = s.toCharArray();
        int j = sArray.length - 1;
        for (int i = 0; i < j; i++, j--) {
            if (sArray[i] != sArray[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        ValidPalindrome test = new ValidPalindrome();
        Long start = System.currentTimeMillis();
        System.out.print(test.isPalindrome(" ")+"\n");
        Long end = System.currentTimeMillis();
        System.out.println((end-start));
    }
}
