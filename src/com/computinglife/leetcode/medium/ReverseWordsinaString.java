/*
Reverse Words in a String
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

Clarification:
What constitutes a word?
    A sequence of non-space characters constitutes a word.
    Could the input string contain leading or trailing spaces?
    Yes. However, your reversed string should not contain leading or trailing spaces.
    How about multiple spaces between two words?
    Reduce them to a single space in the reversed string.
*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 1/29/16.
 */
public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        s = s.trim();
        String[] sArray = s.split(" ");
        if (sArray.length == 1 && sArray[0].equals("")) {
            return "";
        }
        //reverse
        for (int i = 0, j = sArray.length - 1; i <= j; i++, j--) {
            String tmp = sArray[i];
            sArray[i] = sArray[j];
            sArray[j] = tmp;
        }
        StringBuilder res = new StringBuilder();
        for (String tmp : sArray) {
            if (tmp.equals("")) {
                continue;
            }
            res.append(tmp);
            res.append(" ");
        }
        String result = res.toString().trim();
        return result;
    }

    public static void main(String[] args) {
        ReverseWordsinaString test = new ReverseWordsinaString();
        String res = test.reverseWords("   liu yang     yangyang   ");
        System.out.println(res);
    }
}
