//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
//determine if the input string is valid.
//
//The brackets must close in the correct order, 
//"()" and "()[]{}" are all valid but "(]" and "([)]" are not.

package com.computinglife.leetcode.easy;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		char[] charArray = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (char tmp : charArray) {
			if (tmp == '(' || tmp == '{' || tmp == '[') {
				stack.push(tmp);
			}
			if (tmp == ')' || tmp == '}' || tmp == ']') {
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				if (Math.abs(top - tmp) == 1 || Math.abs(top - tmp) == 2) {
					continue;
				} else {
					return false;
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		ValidParentheses test = new ValidParentheses();
		System.out.println(test.isValid(""));
	}

}
