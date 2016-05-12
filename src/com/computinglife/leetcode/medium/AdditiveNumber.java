/*
Additive number is a string whose digits can form additive sequence.

        A valid additive sequence should contain at least three numbers. Except for the first two numbers,
        each subsequent number in the sequence must be the sum of the preceding two.

        For example:
        "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

        1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
        "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
        1 + 99 = 100, 99 + 100 = 199
        Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

        Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

        Follow up:
        How would you handle overflow for very large input integers?
*/

package com.computinglife.leetcode.medium;

/**
 * Created by YanceyLiu on 5/11/2016.
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        int n = num.length();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dfs(0, i, j, n, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int start, int partition, int end, int n, String num) {
        String one = num.substring(start, partition);
        String two = num.substring(partition, end);
        if (one.length() > 1 && one.charAt(0) == '0') {
            return false;
        }
        if (two.length() > 1 && two.charAt(0) == '0') {
            return false;
        }
        long sum = Long.parseLong(one) + Long.parseLong(two);
        String surplus = num.substring(end);
        if (sum == Long.parseLong(surplus) && surplus.charAt(0) != '0') {
            return true;
        }
        int maxLen = Math.max(one.length(), two.length());
        if (end + maxLen < n) {
            boolean status = false;
            if (sum == Long.parseLong(num.substring(end, end + maxLen))) {
                status = dfs(partition, end, end + maxLen, n, num);
            }
            if (!status && sum == Long.parseLong(num.substring(end, end + maxLen + 1))) {
                status = dfs(partition, end, end + maxLen + 1, n, num);
            }
            return status;
        }
        return false;
    }

    public static void main(String[] args) {
        AdditiveNumber test = new AdditiveNumber();
        String num = "199100199";
        System.out.println(test.isAdditiveNumber(num));
    }
}













