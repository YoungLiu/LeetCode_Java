//Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
//
//For example:
//
//Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
//
//Follow up:
//Could you do it without any loop/recursion in O(1) runtime?

package com.computinglife.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class AddDigit {
    public int addDigits(int num) {
        List<Integer> tmp = null;
        while (num / 10 != 0) {
            tmp = segmentation(num);
            num = 0;
            for (Integer position : tmp) {
                num += position;
            }
        }
        return num;

    }

    public List<Integer> segmentation(int num) {
        List<Integer> result = new ArrayList<Integer>();
        do {
            result.add(num % 10);
            num /= 10;
        } while (num != 0);
        return result;
    }

    public static void main(String[] args) {
        AddDigit addDigit = new AddDigit();
        System.out.println(addDigit.addDigits(666));
    }
}
