//package com.computinglife.leetcode.medium;
//
///**
// * Created by YanceyLiu on 4/30/2016.
// */
//
//import java.util.Iterator;
//import java.util.Stack;
//
///**
// * // This is the interface that allows for creating nested lists.
// * // You should not implement it, or speculate about its implementation
// * public interface NestedInteger {
// * <p>
// * // @return true if this NestedInteger holds a single integer, rather than a nested list.
// * public boolean isInteger();
// * <p>
// * // @return the single integer that this NestedInteger holds, if it holds a single integer
// * // Return null if this NestedInteger holds a nested list
// * public Integer getInteger();
// * <p>
// * // @return the nested list that this NestedInteger holds, if it holds a nested list
// * // Return null if this NestedInteger holds a single integer
// * public List<NestedInteger> getList();
// * }
// */
//public class NestedIterator implements Iterator<Integer> {
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        for (int i = nestedList.size() - 1; i >= 0; i--) {
//            s.push(nestedList.get(i));
//        }
//    }
//
//    @Override
//    public Integer next() {
//        NestedInteger top = s.peek();
//        s.pop();
//        return top.getInteger();
//    }
//
//    @Override
//    public boolean hasNext() {
//        while (!s.isEmpty()) {
//            NestedInteger top = s.peek();
//            if (top.isInteger()) {
//                return true;
//            }
//            s.pop();
//            for (int i = top.getList().size() - 1; i >= 0; i--) {
//                s.push(top.getList().get(i));
//            }
//        }
//        return false;
//    }
//
//    private Stack<NestedInteger> s;
//}
//
///**
// * Your NestedIterator object will be instantiated and called as such:
// * NestedIterator i = new NestedIterator(nestedList);
// * while (i.hasNext()) v[f()] = i.next();
// */