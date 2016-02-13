/*Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

        If the fractional part is repeating, enclose the repeating part in parentheses.

        For example,

        Given numerator = 1, denominator = 2, return "0.5".
        Given numerator = 2, denominator = 1, return "2".
        Given numerator = 2, denominator = 3, return "0.(6)".*/

package com.computinglife.leetcode.medium;

import java.util.HashMap;

/**
 * Created by youngliu on 2/14/16.
 */
public class FractiontoRecurringDecimal {
    public String fractionToDecimal2(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        int integer = numerator / denominator;
        res.append(integer);
        if (numerator % denominator == 0) {
            return res.toString();
        } else {
            res.append(".");
        }

        int contro = numerator - (integer * denominator);
        int contro_tmp = contro;
        while (contro != 0) {
            while (contro * 10 < denominator) {
                res.append(0);
                contro *= 10;
            }
            int decimal = (contro * 10) / denominator;
            contro = (contro * 10) - (decimal * denominator);
            if (contro_tmp == contro) {
                res.append("(" + decimal + ")");
                contro = 0;
            } else {
                res.append(decimal);
                contro_tmp = contro;
            }
        }
        return res.toString();
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "";
        }
        String res = "";

        if (numerator < 0 ^ denominator < 0) {
            res += "-";
        }
        long num = numerator,den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        long quotient = num / den;
        res += quotient;
        long reminder = num % den * 10;
        if (reminder == 0) {
            return res;
        }
        HashMap<Long, Integer> map = new HashMap<>();
        res += ".";
        while (reminder != 0) {
            if (map.containsKey(reminder)) {
                int start = map.get(reminder);
                String part1 = res.substring(0, start);
                String part2 = res.substring(start, res.length());
                res = part1 + "(" + part2 + ")";
                return res;
            }
            map.put(reminder, res.length());
            long tmp = reminder / den;
            res += tmp;
            reminder = (reminder % den) * 10;
        }
        return res;
    }

    public static void main(String[] args) {
        FractiontoRecurringDecimal test = new FractiontoRecurringDecimal();
        System.out.println(test.fractionToDecimal(1, 99));
    }
}
