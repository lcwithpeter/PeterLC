/*
Source : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-i/
Author : Jiayi Lei
Date   : Nov 6, 2016

Description:
	Say you have an array for which the ith element is the price of a given 
	stock on day i.

	Design an algorithm to find the maximum profit. You may complete at most two
	transactions.

Note:
	You may not engage in multiple transactions at the same time (ie, you must 
	sell the stock before you buy again).
    
Tags: Array; Dynamic Programming
*/

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length <= 1) return 0;
        
        if(k >= prices.length / 2) return greedy(prices);
        
        int[][] table = new int[k + 1][prices.length];
        for(int i = 1; i < table.length; i++) {
            int maxDiff = table[i - 1][0] - prices[0];
            for(int j = 1; j < prices.length; j++){
                table[i][j] = Math.max(table[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, table[i - 1][j] - prices[j]);
            }
        }
        
        return table[k][prices.length - 1]; 
    }
    private int greedy(int[] prices){
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
				profit += prices[i] - prices[i-1];
			}
        }
        return profit;
    }
}
