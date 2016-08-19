package com.computinglife.leetcode.hard;

import java.util.Stack;

/**
 * Created by yliu on 8/11/16.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int longest = 0;
        if(s == null || s.length() == 0){
            return longest;
        }
        char[] array = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < array.length; i++){
            if(array[i] == '('){
                stack.push(i);
            }else {
                if(!stack.isEmpty()){
                    if(array[stack.peek()] == '('){
                        stack.pop();
                    }else {
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        if(stack.isEmpty()){
            longest = s.length();
        }else{
            int a = s.length();
            int b = 0;
            while(!stack.isEmpty()){
                b = stack.pop();
                longest = Math.max(longest, a - b - 1);
                a = b;
            }
            longest = Math.max(longest, a);
        }
        return longest;
    }

    public static void main(String[] args){
        LongestValidParentheses test = new LongestValidParentheses();
        System.out.println(test.longestValidParentheses("())"));
    }
}
