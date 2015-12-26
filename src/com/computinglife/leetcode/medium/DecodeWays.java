/*A message containing letters from A-Z is being encoded to numbers using the following mapping:

        'A' -> 1
        'B' -> 2
        ...
        'Z' -> 26
        Given an encoded message containing digits, determine the total number of ways to decode it.

        For example,
        Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

        The number of ways decoding "12" is 2.
        递推公式:
        （1）00：res[i]=0（无法解析，没有可行解析方式）；
        （2）10, 20：res[i]=res[i-2]（只有第二种情况成立）；
        （3）11-19, 21-26：res[i]=res[i-1]+res[i-2]（两种情况都可行）；
        （4）01-09, 27-99：res[i]=res[i-1]（只有第一种情况可行）；
        */

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 12/24/15.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int tmp1 = 1;//需要利用前一个字符
        int tmp2 = 1;//不需要利用前一个字符
        int tmp3;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    tmp3 = tmp1;
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i - 1) == '0' || s.charAt(i - 1) >= '3') {
                    tmp3 = tmp2;
                } else {
                    if (s.charAt(i - 1) == '2' && s.charAt(i) >= '7' && s.charAt(i) <= '9') {
                        tmp3 = tmp2;
                    } else {
                        tmp3 = tmp1 + tmp2;
                    }
                }
            }
            tmp1 = tmp2;
            tmp2 = tmp3;
        }
        return tmp2;
    }
}
