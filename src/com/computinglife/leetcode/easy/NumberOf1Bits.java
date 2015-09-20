//Write a function that takes an unsigned integer and returns the number of ¡¯1' bits it has
//        (also known as the Hamming weight).
//        For example, the 32-bit integer ¡¯11' has binary representation 00000000000000000000000000001011,
//        so the function should return 3.

package com.computinglife.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Young on 2015/9/20.
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        List<Integer> binary = toBinary(n);
        return binary.size();
    }

    public List<Integer> toBinary(int n) {
        List<Integer> result = new ArrayList<>();
        while (n != 0) {
            if (n % 2 != 0) {
                result.add(1);
            }
            n = n >>> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOf1Bits test = new NumberOf1Bits();
        System.out.println(test.hammingWeight(214748364));
    }
}
