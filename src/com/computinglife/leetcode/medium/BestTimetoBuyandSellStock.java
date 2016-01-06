/*Say you have an array for which the ith element is the price of a given stock on day i.

        If you were only permitted to complete at most one transaction
        (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 1/6/16.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfitBack(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int indexBuy = 0, indexSell = 0, leastBuy = 0, i = 0;
        while (i < len - 1) {
            int buy, sell;
            while (i + 1 < len && prices[i + 1] < prices[i]) {
                i++;
            }
            buy = i++;
            while (i < len && prices[i - 1] <= prices[i]) {
                i++;
            }
            sell = i - 1;
            if (prices[buy] <= prices[indexBuy]) {
                if (prices[sell] - prices[buy] >= prices[indexSell] - prices[indexBuy]) {
                    indexBuy = buy;
                    indexSell = sell;
                }
            } else {
                if (prices[sell] > prices[indexSell]) {
                    indexSell = sell;
                }
            }
            if (prices[buy] > prices[leastBuy]) {
                indexBuy = leastBuy;
            }
            if (prices[buy] < prices[leastBuy]) {
                leastBuy = buy;
            }
        }
        return prices[indexSell] - prices[indexBuy];
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int res = prices[1] - prices[0], minPrices = prices[0];
        for (int i = 2; i < len; i++) {
            minPrices = Math.min(prices[i - 1], minPrices);
            if (res < prices[i] - minPrices) {
                res = prices[i] - minPrices;
            }
        }
        if (res < 0) {
            return 0;
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStock test = new BestTimetoBuyandSellStock();
        int[] prices = new int[]{1, 2};
        System.out.println(test.maxProfitBack(prices));
    }
}
