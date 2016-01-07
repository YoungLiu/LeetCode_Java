/*Say you have an array for which the ith element is the price of a given stock on day i.

        Design an algorithm to find the maximum profit. You may complete as many transactions as you like
        (ie, buy one and sell one share of the stock multiple times).
        However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 1/6/16.
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    public int maxProfitBack(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int res = 0;
        int buy, sell;
        for (int i = 0; i < len; i++) {
            //递减
            while (i < len - 1 && prices[i + 1] < prices[i]) {
                i++;
            }
            buy = i++;
            //递增
            while (i < len && prices[i] >= prices[i - 1]) {
                i++;
            }
            sell = i - 1;
            res += prices[sell] - prices[buy];
        }
        return res;
    }
}
