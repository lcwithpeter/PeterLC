/*
Source : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
Author : Jiayi Lei
Date   : Nov 6, 2016

Description:
	Say you have an array for which the ith element is the price of a given stock
	on day i.

	Design an algorithm to find the maximum profit. You may complete as many 
	transactions as you like (ie, buy one and sell one share of the stock 
	multiple times). However, you may not engage in multiple transactions at the
	same time (ie, you must sell the stock before you buy again).
    
Tags: Array; Greedy
*/

// version 1
// 2 ms
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        
        int min = prices[0], max = 0, profit = 0;
        boolean increase = false;
        
        for(int i = 1; i < prices.length; i++){
            if(prices[i - 1] < prices[i]){
                increase = true;
                max = prices[i];
            } 
            if(prices[i - 1] > prices[i]){
                if(increase) profit += max - min;
                increase = false;
                min = prices[i];
            }
        }
        if(increase) profit += max - min;
        
        return profit;
    }
}


// verson 2
// 1 ms
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]){
                profit += prices[i] - prices[i - 1];
            }
        }
        
        return profit;
    }
}
