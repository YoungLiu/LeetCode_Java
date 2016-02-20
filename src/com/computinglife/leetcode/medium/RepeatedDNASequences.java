/*All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
for example: "ACGAATTCCG". When studying DNA,
it is sometimes useful to identify repeated sequences within the DNA.

        Write a function to find all the 10-letter-long sequences (substrings)
        that occur more than once in a DNA molecule.

        For example,

        Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

        Return:
        ["AAAAACCCCC", "CCCCCAAAAA"].*/

package com.computinglife.leetcode.medium;

import java.util.*;

/**
 * Created by youngliu on 2/19/16.
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequencesBack(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            if (map.containsKey(s.substring(i, i + 10))) {
                int count = map.get(s.substring(i, i + 10)) + 1;
                map.put(s.substring(i, i + 10), count);
            } else {
                map.put(s.substring(i, i + 10), 1);
            }
        }

        for (String tmp : map.keySet()) {
            if (map.get(tmp) > 1) {
                res.add(tmp);
            }
        }
        return res;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if (len <= 10) {
            return res;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        Set<Integer> tmpSet = new HashSet<>();
        Set<Integer> addedSet = new HashSet<>();

        int hash = 0;
        for (int i = 0; i < len; i++) {
            if (i < 9) {
                hash = (hash << 2) + map.get(s.charAt(i));
            } else {
                hash = (hash << 2) + map.get(s.charAt(i));
                hash &= (1 << 20) - 1;
                if (tmpSet.contains(hash) && !addedSet.contains(hash)) {
                    res.add(s.substring(i - 9, i + 1));
                    addedSet.add(hash);
                } else {
                    tmpSet.add(hash);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        RepeatedDNASequences test = new RepeatedDNASequences();
        List<String> res = test.findRepeatedDnaSequences("AAAAAAAAAAA");
        for (String tmp : res) {
            System.out.println(tmp);
        }
    }

}
