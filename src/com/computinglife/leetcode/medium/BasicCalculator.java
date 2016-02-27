/*Implement a basic calculator to evaluate a simple expression string.

        The expression string may contain open ( and closing parentheses ),
        the plus + or minus sign -, non-negative integers and empty spaces .

        You may assume that the given expression is always valid.

        Some examples:
        "1 + 1" = 2
        " 2-1 + 2 " = 3
        "(1+(4+5+2)-3)+(6+8)" = 23
        Note: Do not use the eval built-in library function.*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by youngliu on 2/27/16.
 */
public class BasicCalculator {
    public int calculate(String s) {
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
                } else {
                    result = Integer.parseInt(list.get(i));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator test = new BasicCalculator();
        System.out.println(test.calculate("    1   2 "));
    }
}
