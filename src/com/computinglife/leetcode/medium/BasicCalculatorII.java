/*Implement a basic calculator to evaluate a simple expression string.

        The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
        The integer division should truncate toward zero.

        You may assume that the given expression is always valid.

        Some examples:
        "3+2*2" = 7
        " 3/2 " = 1
        " 3+5 / 2 " = 5
        Note: Do not use the eval built-in library function.*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by youngliu on 2/27/16.
 */
public class BasicCalculatorII {
    //Time Limit Exceeded
    public int calculate2(String s) {
        if (s == null || s.length() == 0 || s.equals("")) {
            return 0;
        }
        s = s.replaceAll(" ", "");
        List<String> preList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= 'i') {
                int start = i;
                while (s.charAt(i) >= '0' && s.charAt(i) <= 'i') {
                    i++;
                    if (i >= s.length()) {
                        break;
                    }
                }
                preList.add(s.substring(start, i));
                i--;
            } else {
                preList.add(s.substring(i, i + 1));
            }
        }
        Stack<String> stack = new Stack<>();
        for (String item : preList) {
            if (item.equals(" ")) {
                continue;
            } else if (item.equals("(")) {
                stack.push(item + "");
            } else if (item.equals(")")) {
                // pop stack and compute
                int count = 0;
                List<String> list = new ArrayList<>();
                while (!stack.peek().equals("(")) {
                    String tmp = stack.pop();
                    list.add(0, tmp);
                }
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals("+")) {
                        count += Integer.parseInt(list.get(++i));
                    } else if (list.get(i).equals("-")) {
                        count -= Integer.parseInt(list.get(++i));
                    } else if (list.get(i).equals("*")) {
                        count *= Integer.parseInt(list.get(++i));
                    } else if (list.get(i).equals("/")) {
                        if (Integer.parseInt(list.get(i + 1)) == 0) {
                            throw new IllegalArgumentException("error division");
                        }
                        count /= Integer.parseInt(list.get(++i));
                    } else {
                        count = Integer.parseInt(list.get(i));
                    }
                }
                stack.pop();
                stack.push(count + "");
            } else {
                stack.push(String.valueOf(item));
            }
        }

        int result = 0;
        //check the stack
        if (stack.isEmpty()) {
            return result;
        } else {
            List<String> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                String tmp = stack.pop();
                list.add(0, tmp);
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals("+")) {
                    result += Integer.parseInt(list.get(++i));
                } else if (list.get(i).equals("-")) {
                    result -= Integer.parseInt(list.get(++i));
                } else if (list.get(i).equals("*")) {
                    result *= Integer.parseInt(list.get(++i));
                } else if (list.get(i).equals("/")) {
                    if (Integer.parseInt(list.get(i + 1)) == 0) {
                        throw new IllegalArgumentException("error division");
                    }
                    result /= Integer.parseInt(list.get(++i));
                } else {
                    result = Integer.parseInt(list.get(i));
                }
            }
        }
        return result;
    }

    public int calculate(String s) {
        return evaluatePostfix(intfixToPostfix(s));
    }

    private int getRank(char c) {
        switch (c) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private List<Object> intfixToPostfix(String s) {
        Stack<Character> operators = new Stack<>();
        List<Object> postfix = new ArrayList<>();
        char[] chars = s.toCharArray();
        int numberBuffer = 0;
        boolean bufferingOperand = false;
        for (char item : chars) {
            if (item >= '0' && item <= '9') {
                numberBuffer = numberBuffer * 10 + item - '0';
                bufferingOperand = true;
            } else {
                if (bufferingOperand) {
                    postfix.add(numberBuffer);
                    numberBuffer = 0;
                    bufferingOperand = false;
                }

                if (item == ' ' || item == '\t') {
                    continue;
                }
                if (item == '(') {
                    operators.push(item);
                } else if (item == ')') {
                    while (operators.peek() != '(') {
                        postfix.add(operators.pop());
                    }
                    operators.pop();
                } else {
                    while (!operators.isEmpty() && getRank(item) <= getRank(operators.peek())) {
                        postfix.add(operators.pop());
                    }
                    operators.push(item);
                }
            }

        }

        if (bufferingOperand) {
            postfix.add(numberBuffer);
        }

        while (!operators.isEmpty()) {
            postfix.add(operators.pop());
        }
        return postfix;
    }

    private int evaluatePostfix(List<Object> postfix) {
        Stack<Integer> operands = new Stack<>();
        int a = 0, b = 0;
        for (Object item : postfix) {
            if (item instanceof Character) {
                char c = (char) item;
                b = operands.pop();
                a = operands.pop();
                switch (c) {
                    case '+':
                        operands.push(a + b);
                        break;
                    case '-':
                        operands.push(a - b);
                        break;
                    case '*':
                        operands.push(a * b);
                        break;
                    case '/':
                        operands.push(a / b);
                        break;
                    default:
                        break;
                }
            } else {
                operands.push((int) item);
            }
        }
        return operands.pop();
    }

    public static void main(String[] args) {
        BasicCalculatorII test = new BasicCalculatorII();
        System.out.println(test.calculate("1 + 1"));
    }
}
