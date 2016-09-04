package com.computinglife.leetcode.hard;

/**
 * Created by yliu on 8/22/16.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return false;
        }
        int sIndex = 0, pIndex = 0, match = 0, starIndex = -1;
        while(sIndex < s.length()){
            if(pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')){
                sIndex++;
                pIndex++;
            } else if(pIndex < p.length() && p.charAt(pIndex) == '*'){
                starIndex = pIndex;
                match = sIndex;
                pIndex++;
            } else if(starIndex != -1){
                sIndex = ++match;
                pIndex = starIndex + 1;
            } else {
                return false;
            }
        }

        while(pIndex < p.length() && p.charAt(pIndex) == '*'){
            pIndex++;
        }
        return pIndex == p.length();
    }

    public static void main(String[] args){
        WildcardMatching test = new WildcardMatching();
        System.out.println(test.isMatch("aab", "c*a*b"));
    }
}
