//Reverse bits of a given 32 bits unsigned integer.
//
//        For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
//        return 964176192 (represented in binary as 00111001011110000010100101000000).
//
//        Follow up:
//        If this function is called many times, how would you optimize it?

package com.computinglife.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Young on 2015/9/20.
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        List<Integer> original = new ArrayList<>();
        int result = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                original.add(1);
            } else {
                original.add(0);
            }
            n = n >>> 1;
        }
        while(original.size()<32){
            original.add(0);
        }
        Collections.reverse(original);
        for (int i=0;i<32;i++) {
            result += original.get(i) * Math.pow(2, i);
        }
        return result;
    }

    public static void main(String[] args){
        ReverseBits test = new ReverseBits();
        System.out.println(test.reverseBits(1));
    }
}