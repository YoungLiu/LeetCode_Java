package com.computinglife.leetcode.test;

/**
 * Created by yliu on 7/6/16.
 */
public class UpdateBits {
    public static int updateBits(int n, int m, int i, int j) {
        // write your code here
        int zeroClear = 0;
        for(int p = j + 1; p < 32; p++){
            zeroClear <<= 1;
            zeroClear |= 1;
        }
        for(int p = i; p <= j; p++){
            zeroClear <<= 1;
        }
        for (int p = 0; p < i; p++) {
            zeroClear <<= 1;
            zeroClear |= 1;
            m <<= 1;
        }
        int temp = n & zeroClear;
        int tmp2 = temp | m;
        return (n & zeroClear) | m;
    }

    public static void main(String[] args) {
        int res = updateBits(1024, 21, 2, 6);
        System.out.println(res);
    }
}
