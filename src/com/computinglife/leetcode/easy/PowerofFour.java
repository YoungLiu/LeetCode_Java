/*Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

        Example:
        Given num = 16, return true. Given num = 5, return false.



        Follow up: Could you solve it without loops/recursion?*/

package com.computinglife.leetcode.easy;

/**
 * Created by YanceyLiu on 4/20/2016.
 */
public class PowerofFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 4 == 0) {
            num /= 4;
        }
        if (num == 1)
            return true;
        else
            return false;
    }

    public boolean noLoops(int num) {
        int rightZeros = Integer.numberOfTrailingZeros(num);
        int count = Integer.bitCount(num);
        return num > 0 && count == 1 && rightZeros % 2 == 0;
    }

    public static void main(String[] args) {
        PowerofFour test = new PowerofFour();
        System.out.println(test.noLoops(8));
    }
}
