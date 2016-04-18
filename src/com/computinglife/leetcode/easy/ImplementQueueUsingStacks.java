//Implement the following operations of a queue using stacks.
//
//push(x) -- Push element x to the back of queue.
//pop() -- Removes the element from in front of queue.
//peek() -- Get the front element.
//empty() -- Return whether the queue is empty.
//Notes:
//You must use only standard operations of a stack -- which means only push to top, 
//peek/pop from top, size, and is empty operations are valid.
//Depending on your language, stack may not be supported natively. 
//You may simulate a stack by using a list or deque (double-ended queue), 
//as long as you use only standard operations of a stack.
//You may assume that all operations are valid (for example, 
//		no pop or peek operations will be called on an empty queue).

package com.computinglife.leetcode.easy;

import java.util.Stack;

public class ImplementQueueUsingStacks {

	private Stack<Integer> stack;

	public ImplementQueueUsingStacks() {
		this.stack = new Stack<>();
	}

	// Push element x to the back of queue.
	public void push(int x) {
		stack.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		Stack<Integer> temp = new Stack<>();
		moveStack(stack, temp);
		temp.pop();
		moveStack(temp, stack);
	}

	// Get the front element.
	public int peek() {
		Stack<Integer> temp = new Stack<>();
		moveStack(stack, temp);
		int value = temp.peek();
		moveStack(temp, stack);
		return value;
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack.isEmpty();
	}

	public void moveStack(Stack<Integer> from, Stack<Integer> to) {
		int size = from.size();
		for (int i = 0; i < size; i++) {
			int value = from.pop();
			to.push(value);
		}
	}
}
