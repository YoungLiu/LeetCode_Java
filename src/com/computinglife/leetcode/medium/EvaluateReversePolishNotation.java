/*Evaluate the value of an arithmetic expression in Reverse Polish Notation.

        Valid operators are +, -, *, /. Each operand may be an integer or another expression.

        Some examples:
        ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
        ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6*/

package com.computinglife.leetcode.medium;

import java.util.Stack;

/**
 * Created by youngliu on 1/29/16.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<>();
        int res = 0;
        for (String tmp : tokens) {
            if (tmp.equals("+")) {
                int tmp1 = Integer.parseInt(stack.pop());
                int tmp2 = Integer.parseInt(stack.pop());
                res = tmp1 + tmp2;
                stack.push(res + "");
            } else if (tmp.equals("-")) {
                int tmp1 = Integer.parseInt(stack.pop());
                int tmp2 = Integer.parseInt(stack.pop());
                res = tmp2 - tmp1;
                stack.push(res + "");
            } else if (tmp.equals("*")) {
                int tmp1 = Integer.parseInt(stack.pop());
                int tmp2 = Integer.parseInt(stack.pop());
                res = tmp1 * tmp2;
                stack.push(res + "");
            } else if (tmp.equals("/")) {
                int tmp1 = Integer.parseInt(stack.pop());
                int tmp2 = Integer.parseInt(stack.pop());
                res = tmp2 / tmp1;
                stack.push(res + "");
            } else {
                stack.push(tmp);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation test = new EvaluateReversePolishNotation();
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};
        int res = test.evalRPN(tokens);
        System.out.println(res);
    }
}
