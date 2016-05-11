/*Given an integer, write a function to determine if it is a power of three.

        Follow up:
        Could you do it without using any loop / recursion?*/

package com.computinglife.leetcode.easy;

/**
 * Created by YanceyLiu on 5/3/2016.
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        return n % 3 == 0 && isPowerOfThree(n / 3);
    }

    public boolean bestMethod(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }

    public boolean anotherMethod(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public boolean bestbestMethod(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
