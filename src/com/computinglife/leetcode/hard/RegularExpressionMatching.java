package com.computinglife.leetcode.hard;

/**
 * Created by yliu on 8/6/16.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        return recursive(sArray, pArray, 0, 0);
    }

    public boolean recursive(char[] s, char[] p, int sIndex, int pIndex) {
        if (pIndex == p.length) {
            return sIndex == s.length ? true : false;
        }
        if (pIndex < p.length - 1 && p[pIndex + 1] == '*') {
            return recursive(s, p, sIndex, pIndex + 2) || (sIndex < s.length && (s[sIndex] == p[pIndex] || p[pIndex] == '.') && recursive(s, p, sIndex + 1, pIndex));
        } else {
            if(sIndex >= s.length){
                return false;
            }
            return (s[sIndex] == p[pIndex] || p[pIndex] == '.') ? recursive(s,p, sIndex + 1, pIndex + 1) : false;
        }
    }

    public static void main(String[] args){
        RegularExpressionMatching test = new RegularExpressionMatching();
        System.out.println(test.isMatch("aaa", "a.a"));
    }
}
