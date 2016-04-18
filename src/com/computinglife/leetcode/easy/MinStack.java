//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//        push(x) -- Push element x onto stack.
//        pop() -- Removes the element on top of the stack.
//        top() -- Get the top element.
//        getMin() -- Retrieve the minimum element in the stack.

package com.computinglife.leetcode.easy;

import java.util.Stack;

/**
 * Created by youngliu on 9/28/15.
 */
public class MinStack {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else if (minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        int popedElement = mainStack.pop();
        if (popedElement == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
