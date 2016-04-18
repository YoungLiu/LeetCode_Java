//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...
//
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.
//
//Note: The sequence of integers will be represented as a string.

package com.computinglife.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class CountandSay {
    public String countAndSay(int n) {
        List<String> tmp1 = new ArrayList<>();
        tmp1.add(1 + "");
        StringBuilder ret = new StringBuilder();
        int count = 1;
        for (int num = 1; num < n; num++) {
            String tmp = tmp1.get(tmp1.size() - 1);
            char[] tmp2 = tmp.toCharArray();
            for (int i = 0; i < tmp2.length; i++) {
                if (i == tmp2.length - 1) {
                    ret.append(count);
                    ret.append(tmp2[i]);
                    count = 1;
                    break;
                }
                if (tmp2[i] == tmp2[i + 1]) {
                    count++;
                } else {
                    ret.append(count);
                    ret.append(tmp2[i]);
                    count = 1;
                }
            }
            tmp1.add(ret.toString());
            ret = new StringBuilder();
        }
        return tmp1.get(tmp1.size() - 1);
    }

    public static void main(String[] args) {
        CountandSay test = new CountandSay();
        System.out.println(test.countAndSay(4));
    }
}
