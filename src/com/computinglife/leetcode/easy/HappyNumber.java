//Write an algorithm to determine if a number is "happy".
//
//        A happy number is a number defined by the following process: Starting with any positive integer,
// replace the number by the sum of the squares of its digits,
// and repeat the process until the number equals 1 (where it will stay),
// or it loops endlessly in a cycle which does not include 1.
// Those numbers for which this process ends in 1 are happy numbers.
//
//        Example: 19 is a happy number
//
//        12 + 92 = 82
//        82 + 22 = 68
//        62 + 82 = 100
//        12 + 02 + 02 = 1

package com.computinglife.leetcode.easy;

import java.util.HashMap;

/**
 * Created by Young on 2015/9/18.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        String nString = Integer.toString(n);
        int sum = 0;
        HashMap<HashMap<Character, Integer>, Integer> repeat = new HashMap<HashMap<Character,Integer>,Integer>();
        while (sum != 1) {
            HashMap<Character, Integer> map = new HashMap<Character,Integer>();
            sum = 0;
            for (Character a : nString.toCharArray()) {
                map.put(a, map.getOrDefault(a, 0) + 1);
                sum += Character.getNumericValue(a) * Character.getNumericValue(a);
            }
            if (!repeat.containsKey(map)) {
                repeat.put(map, repeat.getOrDefault(map, 0) + 1);
            } else {
                return false;
            }
            nString = Integer.toString(sum);
        }
        return true;
    }

    public static void main(String[] args) {
        HappyNumber test = new HappyNumber();
        if (test.isHappy(2)) {
            System.out.println("is");
        }else{
            System.err.println("not is");
        }
    }
}
