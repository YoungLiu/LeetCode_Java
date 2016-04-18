/*The gray code is a binary numeral system where two successive values differ in only one bit.

        Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
        A gray code sequence must begin with 0.

        For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

        00 - 0
        01 - 1
        11 - 3
        10 - 2
        Note:
        For a given n, a gray code sequence is not uniquely defined.

        For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

        For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.*/
//http://baike.baidu.com/view/358724.htm 格雷码生成和解码方法

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngliu on 12/24/15.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> sequence = new ArrayList<>();
        if (n < 0) {
            return sequence;
        }
        if (n == 0) {
            sequence.add(0);
            return sequence;
        }
        sequence.add(0);
        sequence.add(1);
        for (int i = 2; i <= n; i++) {
            int size = sequence.size();
            for (int j = size - 1; j >= 0; j--) {
                sequence.add(sequence.get(j) + (1 << (i - 1)));
            }
        }
        return sequence;
    }

    //二进制转化十进制
    public int convert(int binary) {
        int res = 0;
        List<Integer> binaryList = new ArrayList<>();
        while (binary / 10 != 0) {
            binaryList.add(binary % 10);
            binary /= 10;
        }
        binaryList.add(binary);
        int rate = 1;
        for (int tmp : binaryList) {
            res += tmp * rate;
            rate *= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        GrayCode test = new GrayCode();
        System.out.println(test.convert(01));
    }
}
