/*You are given coins of different denominations and a total amount of money amount.
        Write a function to compute the fewest number of coins that you need to make up that amount.
        If that amount of money cannot be made up by any combination of the coins, return -1.

        Example 1:
        coins = [1, 2, 5], amount = 11
        return 3 (11 = 5 + 5 + 1)

        Example 2:
        coins = [2], amount = 3
        return -1.

        Note:
        You may assume that you have an infinite number of each kind of coin.*/

package com.computinglife.leetcode.medium;

import java.util.Arrays;

/**
 * Created by YanceyLiu on 5/5/2016.
 */
public class CoinChange {
    public int coinChangeError(int[] coins, int amount) {
        if (coins == null || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount / coins[i] == 0) {
                continue;
            } else {
                count += amount / coins[i];
                amount %= coins[i];
                if (amount == 0) {
                    return count;
                }
            }
        }
        return -1;
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        final int INF = 0x7ffffffe;
        for (int i = 1; i <= amount; i++) {
            dp[i] = INF;
        }
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i + coins[j] <= amount) {
                    dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
                }
            }
        }
        return dp[amount] == INF ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange test = new CoinChange();
        int[] coins = {186, 419, 83, 408};
        System.out.println(test.coinChange(coins, 6249));
    }
}
