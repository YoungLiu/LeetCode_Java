/*
Say you have an array for which the ith element is the price of a given stock on day i.

        Design an algorithm to find the maximum profit. You may complete as many transactions as you like
        (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

        You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
        After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
        Example:

        prices = [1, 2, 3, 0, 2]
        maxProfit = 3
        transactions = [buy, sell, cooldown, buy, sell]
*/

package com.computinglife.leetcode.medium;

/**
 * Created by YanceyLiu on 5/10/2016.
 */
public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int pre_sell = 0, sell = 0, pre_buy = 0, buy = Integer.MIN_VALUE;
        for (int tmp : prices) {
            pre_buy = buy;
            buy = Math.max(pre_sell - tmp, pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy + tmp, pre_sell);
        }
        return sell;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStockwithCooldown test = new BestTimetoBuyandSellStockwithCooldown();
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(test.maxProfit(prices));
    }
}
