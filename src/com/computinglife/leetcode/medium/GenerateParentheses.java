//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//For example, given n = 3, a solution set is:
//
//"((()))", "(()())", "(())()", "()(())", "()()()"

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public List<String> ret = new ArrayList<String>();

	public List<String> generateParenthesis(int n) {
		generate(0, 0, "", n);
		return ret;
	}

	public void generate(int left, int right, String s, int n) {
		if (right == n) {
			ret.add(s);
		}

		if (left < n) {
			generate(left + 1, right, s + "(", n);
		}
		if (right < left) {
			generate(left, right + 1, s + ")", n);
		}
	}

	public static void main(String[] args) {
		GenerateParentheses test = new GenerateParentheses();
		System.err.println(test.generateParenthesis(3));
	}

}
