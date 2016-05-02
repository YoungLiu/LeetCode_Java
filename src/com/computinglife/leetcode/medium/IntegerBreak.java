/*Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those
integers.Return the maximum product you can get.

        For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

        Note: you may assume that n is not less than 2.

        2--->   1 1     1
        3--->   2 1     2
        4--->   2 2     4
        5--->   3 2     6
        6--->   3 3     9


        7--->   4 3     12      (12)    3 2 2
        8--->   4 4     16      (18)    3 3 2
        9--->   4 3 2   24      (27)    3 3 3
        10--->  4 3 3   36      (36)    4 3 3
        11--->  5 6     54      ()

        Hint:

        There is a simple O(n) solution to this problem.
        You may check the breaking results of n ranging from 7 to 10 to discover the regularities.*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YanceyLiu on 4/19/2016.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n < 0) {
            return -1;
        }
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        res.add(1);
        res.add(2);
        res.add(4);
        res.add(6);
        res.add(9);
        if (n < 7) {
            return res.get(n);
        }
        for (int i = 7; i <= n; i++) {
            res.add(Math.max(2 * res.get(i - 2), 3 * res.get(i - 3)));
        }
        return res.get(n);
    }

    public static void main(String[] args) {
        IntegerBreak test = new IntegerBreak();
        System.out.println(test.integerBreak(9));
    }
}
