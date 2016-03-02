/*Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

        For example:
        Given n = 13,
        Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

        Hint:

        Beware of overflow.
        参考:http://blog.csdn.net/wzy_1988/article/details/47148263
        */

package com.computinglife.leetcode.medium;

/**
 * Created by YanceyLiu on 3/1/2016.
 */
public class NumberofDigitOne {
    public int countDigitOne(int n) {
        int count = 0;
        long factor = 1;
        long cdigit = 0;
        long hightN = 0;
        long lowN = 0;
        while (n / factor > 0) {
            cdigit = (n % (factor * 10)) / factor;
            hightN = n / (factor * 10);
            if (cdigit == 0) {
                count += hightN * factor;
            } else if (cdigit == 1) {
                count += hightN * factor + lowN + 1;
            } else {
                count += (hightN + 1) * factor;
            }
            lowN += cdigit * factor;
            factor *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberofDigitOne test = new NumberofDigitOne();
        System.out.println(test.countDigitOne(16));
    }
}
