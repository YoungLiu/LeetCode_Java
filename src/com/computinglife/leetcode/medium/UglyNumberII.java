/*Write a program to find the n-th ugly number.

        Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
        For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

        Note that 1 is typically treated as an ugly number.

        Hint:

        The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly.
        Try to focus your effort on generating only the ugly ones.
        An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
        The key is how to maintain the order of the ugly numbers.
        Try a similar approach of merging from three sorted lists: L1, L2, and L3.
        Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YanceyLiu on 3/3/2016.
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        List<Integer> res = new ArrayList<>();
        if (n <= 0) {
            return 0;
        }
        res.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (res.size() < n) {
            int m2 = res.get(i2) * 2, m3 = res.get(i3) * 3, m5 = res.get(i5) * 5;
            int mm = Math.min(m2, Math.min(m3, m5));
            if (mm == m2)
                i2++;
            if (mm == m3)
                i3++;
            if (mm == m5)
                i5++;
            res.add(mm);
        }
        return res.get(n - 1);
    }
}
